package domain;

public enum Actions {

    PLUS("+", true),
    MINUS("-", true),
    MULTIPLY("*", true),
    DIVIDE("/", true),
    EQUALS("=", true),
    POWER("^", true),
    SQUARE("^2", false),
    SQUARE_ROOT("sqrt", false),
    ONE_DIVIDED_BY("1/x", false),
    COS("cos", false),
    SIN("sin", false),
    TAN("tan", false),
    LOG("log", false),
    PERCENT("%", false),
    ABSOLUTE("abs", false),
    BINARY("bin", false),
    CLEAR("clear", false);

    private final String sign;
    private final boolean binaryOperator;

    Actions(String actionSign, boolean binaryOperator) {
        this.sign = actionSign;
        this.binaryOperator = binaryOperator;
    }

    public String getSign() {
        return this.sign;
    }

    public boolean isBinaryOperator() {
        return binaryOperator;
    }
}
