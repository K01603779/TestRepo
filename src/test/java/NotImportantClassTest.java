import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotImportantClassTest {
  private IDoSomething doSomething;

  @BeforeEach
  public void beforeEach() {
    doSomething = new NotImportantClass();
  }

  @Test
  public void testDoSomething() {
    Assertions.assertEquals("Doing something...", doSomething.doSomething());
  }

  @Test
  public void testFailingDoSomething() {
    // Assertions.assertEquals("", doSomething.doSomething());
    // Assertions.assertEquals("", doSomething.doSomething());
    // Assertions.assertEquals("", doSomething.doSomething());
    // Assertions.assertEquals("", doSomething.doSomething());
  }

  @Test
  public void longStream() {
    var list = List.of(1, 52, 3, 4, 66, 868, 32, 234, -1);

    list.stream()
        .sorted()
        .filter(x -> x < 100)
        .collect(Collectors.toSet())
        .forEach(x -> x.intValue());
  }

  // should be spotted by spotbugs?
  public boolean equals(Object obj) {
    return true;
  }
}
