public class Calculator {

    private final int firstInput;
    private final int secondInput;

    public Calculator(int x, int y) {
        firstInput = x;
        secondInput = y;
    }

    public int add() {
        return firstInput + secondInput;
    }

    public int subtract() {
        return firstInput - secondInput;
    }

    public int multiply() {
        return firstInput * secondInput;
    }

    public float divide() {
        if (secondInput == 0) {
            throw new ArithmeticException("Tried to divide by 0.");
        } else {
            return (float) firstInput / secondInput;
        }
    }

    public double sqrt() {
        if (firstInput < 0) {
            throw new ArithmeticException("Tried to find the square root of a negative number.");
        } else {
            return Math.sqrt(firstInput);
        }
    }

    public double square() {
        return firstInput * firstInput;
    }
}
