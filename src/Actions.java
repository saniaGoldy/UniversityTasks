public enum Actions {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    CLEAR("clear"),
    STOP("stop");

    private final String sign;

    Actions(String actionSign){
        this.sign = actionSign;
    }

    public String getSign(){
        return this.sign;
    }
}
