package ui;

import domain.Actions;
import domain.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen implements ActionListener {

    private final JFrame frame;

    private final JPanel panel;
    private final JPanel panelSub1;
    private final JPanel panelSub2;
    private final JPanel panelSub3;
    private final JPanel panelSub4;
    private final JPanel panelSub5;
    private final JPanel panelSub6;
    private final JPanel panelSub7;
    private final JPanel panelSub8;

    private final JTextArea text;
    private final JButton[] but;
    private final JButton buttonAdd;
    private final JButton buttonMinus;
    private final JButton buttonMultiply;
    private final JButton buttonDivide;
    private final JButton buttonEqual;
    private final JButton buttonCancel;
    private final JButton buttonSquareRoot;
    private final JButton buttonSquare;
    private final JButton buttonOneDividedBy;
    private final JButton buttonCos;
    private final JButton buttonSin;
    private final JButton buttonTan;
    private final JButton buttonxpowerofy;
    private final JButton buttonlog;
    private final JButton buttonrate;
    private final JButton buttonabs;
    private final JButton buttonBinary;

    private final Calculator calculator;

    private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9"};

    private final Font font;
    private final Font textFont;

    private MainScreen(Calculator calculator) {
        frame = new JFrame("Calculator PH");

        this.calculator = calculator;

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panelSub1 = new JPanel(new FlowLayout());
        panelSub2 = new JPanel(new FlowLayout());
        panelSub3 = new JPanel(new FlowLayout());
        panelSub4 = new JPanel(new FlowLayout());
        panelSub5 = new JPanel(new FlowLayout());
        panelSub6 = new JPanel(new FlowLayout());
        panelSub7 = new JPanel(new FlowLayout());
        panelSub8 = new JPanel(new FlowLayout());

        font = new Font("Consolas", Font.PLAIN, 18);

        text = new JTextArea(1, 30);

        textFont = new Font("Consolas", Font.BOLD, 24);

        but = new JButton[10];
        for (int i = 0; i < 10; i++) {
            but[i] = new JButton(String.valueOf(i));
        }
        buttonAdd = new JButton(Actions.PLUS.getSign());
        buttonMinus = new JButton(Actions.MINUS.getSign());
        buttonMultiply = new JButton(Actions.MULTIPLY.getSign());
        buttonDivide = new JButton(Actions.DIVIDE.getSign());
        buttonEqual = new JButton(Actions.EQUALS.getSign());
        buttonSquareRoot = new JButton(Actions.SQUARE_ROOT.getSign());
        buttonSquare = new JButton(Actions.SQUARE.getSign());
        buttonOneDividedBy = new JButton(Actions.ONE_DIVIDED_BY.getSign());
        buttonCos = new JButton(Actions.COS.getSign());
        buttonSin = new JButton(Actions.SIN.getSign());
        buttonTan = new JButton(Actions.TAN.getSign());
        buttonxpowerofy = new JButton(Actions.POWER.getSign());
        buttonlog = new JButton(Actions.LOG.getSign());
        buttonrate = new JButton(Actions.PERCENT.getSign());
        buttonabs = new JButton(Actions.ABSOLUTE.getSign());
        buttonCancel = new JButton(Actions.CLEAR.getSign());
        buttonBinary = new JButton(Actions.BINARY.getSign());
    }

    public void init() {
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text.setFont(textFont);
        text.setEditable(false);

        for (int i = 0; i < 10; i++) {
            but[i].setFont(font);
        }
        buttonAdd.setFont(font);
        buttonMinus.setFont(font);
        buttonMultiply.setFont(font);
        buttonDivide.setFont(font);
        buttonEqual.setFont(font);
        buttonSquareRoot.setFont(font);
        buttonSquare.setFont(font);
        buttonOneDividedBy.setFont(font);
        buttonCos.setFont(font);
        buttonSin.setFont(font);
        buttonTan.setFont(font);
        buttonxpowerofy.setFont(font);
        buttonlog.setFont(font);
        buttonrate.setFont(font);
        buttonabs.setFont(font);
        buttonCancel.setFont(font);
        buttonBinary.setFont(font);

        panel.add(Box.createHorizontalStrut(100));
        panelSub1.add(text);
        panel.add(panelSub1);

        panelSub2.add(but[1]);
        panelSub2.add(but[2]);
        panelSub2.add(but[3]);
        panelSub2.add(Box.createHorizontalStrut(15));
        panelSub2.add(buttonAdd);
        panelSub2.add(buttonMinus);
        panel.add(panelSub2);

        panelSub3.add(but[4]);
        panelSub3.add(but[5]);
        panelSub3.add(but[6]);
        panelSub3.add(Box.createHorizontalStrut(15));
        panelSub3.add(buttonMultiply);
        panelSub3.add(buttonDivide);
        panel.add(panelSub3);

        panelSub4.add(but[7]);
        panelSub4.add(but[8]);
        panelSub4.add(but[9]);
        panelSub4.add(Box.createHorizontalStrut(15));
        panelSub4.add(buttonEqual);
        panelSub4.add(buttonCancel);
        panel.add(panelSub4);

        panelSub5.add(Box.createHorizontalStrut(92));
        panelSub5.add(but[0]);
        panelSub5.add(Box.createHorizontalStrut(210));
        panel.add(panelSub5);

        panelSub6.add(buttonSquare);
        panelSub6.add(buttonSquareRoot);
        panelSub6.add(buttonOneDividedBy);
        panelSub6.add(buttonxpowerofy);
        panel.add(panelSub6);

        panelSub7.add(buttonCos);
        panelSub7.add(buttonSin);
        panelSub7.add(buttonTan);
        panel.add(panelSub7);

        panelSub8.add(buttonlog);
        panelSub8.add(buttonrate);
        panelSub8.add(buttonabs);
        panelSub8.add(buttonBinary);
        panel.add(panelSub8);

        for (int i = 0; i < 10; i++) {
            but[i].addActionListener(this);
        }
        buttonAdd.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonSquareRoot.addActionListener(this);
        buttonOneDividedBy.addActionListener(this);
        buttonCos.addActionListener(this);
        buttonSin.addActionListener(this);
        buttonTan.addActionListener(this);
        buttonxpowerofy.addActionListener(this);
        buttonlog.addActionListener(this);
        buttonrate.addActionListener(this);
        buttonabs.addActionListener(this);
        buttonBinary.addActionListener(this);

        buttonEqual.addActionListener(this);
        buttonCancel.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void performAction(Actions action, String newDisplayedValue) {
        writer(calculator.processAction(action, reader()));
        text.replaceSelection(newDisplayedValue);
    }

    private boolean isInputValid() {
        try {
            Double.parseDouble(text.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == but[i]) {
                text.replaceSelection(buttonValue[i]);
                return;
            }
        }

        if (isInputValid() || source == buttonCancel) {
            if (source == buttonAdd) {
                performAction(Actions.PLUS, ((JButton) source).getText());
            }

            if (source == buttonMinus) {
                performAction(Actions.MINUS, ((JButton) source).getText());
            }

            if (source == buttonMultiply) {
                performAction(Actions.MULTIPLY, ((JButton) source).getText());
            }

            if (source == buttonDivide) {
                performAction(Actions.DIVIDE, ((JButton) source).getText());
            }

            if (source == buttonxpowerofy) {
                writer(calculator.processAction(Actions.POWER, reader()));
            }

            if (source == buttonSquare) {
                writer(calculator.processAction(Actions.SQUARE, reader()));
            }

            if (source == buttonSquareRoot)
                writer(calculator.processAction(Actions.SQUARE_ROOT, reader()));

            if (source == buttonOneDividedBy)
                writer(calculator.processAction(Actions.ONE_DIVIDED_BY, reader()));

            if (source == buttonCos)
                writer(calculator.processAction(Actions.COS, reader()));

            if (source == buttonSin)
                writer(calculator.processAction(Actions.SIN, reader()));

            if (source == buttonTan)
                writer(calculator.processAction(Actions.TAN, reader()));

            if (source == buttonlog)
                writer(calculator.processAction(Actions.LOG, reader()));

            if (source == buttonrate)
                writer(calculator.processAction(Actions.PERCENT, reader()));

            if (source == buttonabs)
                writer(calculator.processAction(Actions.ABSOLUTE, reader()));

            if (source == buttonEqual)
                writer(calculator.processAction(Actions.EQUALS, reader()));

            if (source == buttonCancel)
                writer(calculator.reset());

            if (source == buttonBinary)
                text.setText("" + calculator.parseToBinary(text.getText()));

        }

        text.selectAll();
    }

    public Double reader() {
        double num;
        String str;
        str = text.getText();
        num = Double.parseDouble(str);

        return num;
    }

    public void writer(final Double num) {
        if (Double.isNaN(num)) {
            text.setText("");
        } else {
            text.setText(Double.toString(num));
        }
    }

    public static MainScreen getInitializedInstance(Calculator calculator) {
        MainScreen screen = new MainScreen(calculator);
        screen.init();
        return screen;
    }
}
