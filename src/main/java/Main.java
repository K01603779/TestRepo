public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        switch (args[2]) {
            case "+":
                System.out.println(Calculator.add(a, b));
                break;
            case "-":
                System.out.println(Calculator.sub(a, b));
                break;
            case "*":
                System.out.println(Calculator.mul(a, b));
                break;
            case "/":
                System.out.println(Calculator.div(a, b));
                break;
            case "%":
                System.out.println(Calculator.mod(a, b));
                break;
            default:
                System.out.println(args[0]);
                break;
        }
    }
}
