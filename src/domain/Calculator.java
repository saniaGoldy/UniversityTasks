package domain;

import static java.lang.Double.NaN;

public class Calculator {

    private Double lastValue = 0.0;
    private Actions lastBinaryAction = Actions.EQUALS;

    private Double calculateBinaryAction(Actions action, Double value) {
        Double result = lastValue;
        switch (action) {
            case EQUALS -> result = value;
            case PLUS -> result += value;
            case MINUS -> result -= value;
            case MULTIPLY -> result *= value;
            case DIVIDE -> result /= value;
            case POWER -> result = Math.pow(lastValue, value);
            default -> throw new IllegalArgumentException("Unsupported action");
        }
        return result;
    }

    private Double processBinaryAction(Actions newAction, Double value) {
        if (lastBinaryAction == Actions.EQUALS) {
            lastValue = value;
            lastBinaryAction = newAction;
            return NaN;
        } else {
            lastValue = calculateBinaryAction(lastBinaryAction, value);
            lastBinaryAction = newAction;
            return lastValue;
        }
    }

    public Double processAction(Actions action, Double value) {
        if (action.isBinaryOperator()) {
            return processBinaryAction(action, value);
        } else {
            return calculateUnaryAction(action, value);
        }
    }

    public double reset() {
        lastValue = 0.0;
        lastBinaryAction = Actions.EQUALS;
        return NaN;
    }

    public String parseToBinary(String value) {
        try {
            return Long.toBinaryString(Long.parseLong(value));
        } catch (NumberFormatException ex) {
            System.err.println("Error while parse to binary." + ex);
        }
        return "";
    }

    private Double calculateUnaryAction(Actions action, Double value) {
        switch (action) {
            case SQUARE -> value *= value;
            case SQUARE_ROOT -> value = Math.sqrt(value);
            case ONE_DIVIDED_BY -> value = 1 / value;
            case COS -> value = Math.cos(Math.toRadians(value));
            case SIN -> value = Math.sin(Math.toRadians(value));
            case TAN -> value = Math.tan(Math.toRadians(value));
            case LOG -> value = Math.log10(value);
            case PERCENT -> value /= 100;
            case ABSOLUTE -> value = Math.abs(value);
            default -> throw new IllegalArgumentException("Unsupported action");
        }
        return value;
    }

}
