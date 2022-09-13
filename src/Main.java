import java.util.Scanner;

public class Main {

    private static final String REGEX_DOUBLE = "-?\\d+(?:\\.\\d+)?";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startCalculator(readDouble());
    }

    private static void startCalculator(Double initValue) {
        Calculator calculator = new Calculator(initValue);
        while (true) {
            Actions action = readAction();

            if (action == Actions.STOP)
                break;

            Double number = readDouble();

            if (number == null)
                break;

            calculator.applyAction(number, action);
        }
    }

    private static Actions readAction() {
        System.out.println("Input one of actions [+, -, *, /, clear, stop]: ");
        String input = scanner.next();
        if (input.contentEquals(Actions.PLUS.getSign())) {
            return Actions.PLUS;
        } else if (input.contentEquals(Actions.MINUS.getSign())) {
            return Actions.MINUS;
        } else if (input.contentEquals(Actions.MULTIPLY.getSign())) {
            return Actions.MULTIPLY;
        } else if (input.contentEquals(Actions.DIVIDE.getSign())) {
            return Actions.DIVIDE;
        } else if (input.contentEquals(Actions.CLEAR.getSign())) {
            return Actions.CLEAR;
        } else if (input.contentEquals(Actions.STOP.getSign())) {
            return Actions.STOP;
        } else {
            System.out.println("Invalid Input");
            return readAction();
        }
    }

    private static Double readDouble() {
        System.out.println("Input number: ");
        String input = scanner.next();

        if (input.matches(REGEX_DOUBLE)) {
            return Double.parseDouble(input);
        } else if (input.contentEquals(Actions.STOP.getSign())){
            return null;
        }
        else {
            System.out.println("Invalid Input");
            return readDouble();
        }
    }
}
