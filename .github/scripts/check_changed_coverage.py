import subprocess
import xml.etree.ElementTree as ET
import sys


MIN_COVERAGE = 0.70


def get_changed_files():
    result = subprocess.check_output(
        [
            "git",
            "diff",
            "--name-only",
            "origin/main...HEAD",
        ],
        text=True,
    )

    return [
        file
        for file in result.splitlines()
        if file.startswith("src/main/java/")
           and file.endswith(".java")
    ]


def java_class_name(path):
    return (
        path
        .replace("src/main/java/", "")
        .replace(".java", "")
        .replace("/", ".")
    )


def load_coverage():

    tree = ET.parse(
        "target/site/jacoco/jacoco.xml"
    )

    root = tree.getroot()

    result = {}

    for package in root.findall("package"):

        for cls in package.findall("class"):

            name = (
                cls.attrib["name"]
                .replace("/", ".")
            )

            for counter in cls.findall("counter"):

                if counter.attrib["type"] == "LINE":

                    covered = int(
                        counter.attrib["covered"]
                    )

                    missed = int(
                        counter.attrib["missed"]
                    )

                    total = covered + missed

                    if total:
                        result[name] = (
                                covered / total
                        )

    return result


changed_files = get_changed_files()


if not changed_files:
    print(
        "No changed Java files detected."
    )
    sys.exit(0)


coverage = load_coverage()

failed = []


for file in changed_files:

    cls = java_class_name(file)

    value = coverage.get(cls)

    if value is None:
        print(
            f"⚠️ No coverage data found for {cls}"
        )
        continue

    print(
        f"{cls}: {value:.2%}"
    )

    if value < MIN_COVERAGE:
        failed.append(
            (cls, value)
        )


if failed:

    print("\nCoverage failures:")

    for cls, value in failed:

        print(
            f"❌ {cls}: {value:.2%} "
            f"(minimum {MIN_COVERAGE:.0%})"
        )

    sys.exit(1)


print(
    "\n✅ Changed files satisfy coverage requirement"
)