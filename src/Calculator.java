public class Calculator {
    private Double lastValue;

    public Calculator(Double initialValue) {
        lastValue = initialValue;
    }

    public Double applyAction(Double value, Actions action) {
        System.out.print(lastValue + action.getSign() + value + "=");

        if (action == Actions.STOP)
            return null;

        switch (action) {
            case PLUS -> lastValue += value;
            case MINUS -> lastValue -= value;
            case DIVIDE -> lastValue /= value;
            case MULTIPLY -> lastValue *= value;
            case CLEAR -> lastValue = 0.0;
        }

        System.out.println(lastValue);
        return lastValue;
    }
}
