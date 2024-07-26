import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Map<String, String> operatorDescriptions = Map.of(
                "+", "add",
                "-", "subtract",
                "*", "multiply",
                "/", "divide",
                "sqr", "square",
                "sqrt", "square root"
        );

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Enter the first number: ");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input, please enter an integer");
                scan.next();
            }
            int x = scan.nextInt();

            StringBuilder line = new StringBuilder("Please enter an operator from the list of:\n");
            for (Map.Entry<String, String> entry : operatorDescriptions.entrySet()) {
                line.append(entry.getKey()).append(" (").append(entry.getValue()).append(")\n");
            }
            System.out.println(line);

            String operator;
            do {
                System.out.println("Enter a valid operator: ");
                operator = scan.next().trim();
                if (!operatorDescriptions.containsKey(operator)) {
                    System.out.println("Invalid operator. Please re-enter:");
                }
            } while (!operatorDescriptions.containsKey(operator));

            int y = 0;
            if (!operator.equals("sqrt") && !operator.equals("sqr")) {
                System.out.print("Enter the second number: ");
                while (!scan.hasNextInt()) {
                    System.out.println("Invalid input, please enter an integer");
                    scan.next();
                }
                y = scan.nextInt();
            }

            Calculator calculator = new Calculator(x, y);
            System.out.println(calculate(calculator, operator));
        }
    }

    private static String calculate(Calculator calculator, String operator) {
        return switch (operator) {
            case "+" -> String.valueOf(calculator.add());
            case "-" -> String.valueOf(calculator.subtract());
            case "*" -> String.valueOf(calculator.multiply());
            case "/" -> {
                try {
                    yield String.valueOf(calculator.divide());
                } catch (ArithmeticException e) {
                    yield e.getMessage();
                }
            }
            case "sqrt" -> {
                try {
                    yield String.valueOf(calculator.sqrt());
                } catch (ArithmeticException e) {
                    yield e.getMessage();
                }
            }
            case "sqr" -> String.valueOf(calculator.square());
            default -> "Invalid operator entered";
        };
    }
}