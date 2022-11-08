import domain.Calculator;
import ui.MainScreen;

public class Main {
    public static void main(String[] args) {
        startCalculator();
    }

    private static void startCalculator() {
        Calculator calculator = new Calculator();
        try {
            MainScreen.getInitializedInstance(calculator);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
