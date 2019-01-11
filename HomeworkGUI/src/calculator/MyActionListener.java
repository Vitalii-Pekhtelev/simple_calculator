package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private JTextField num1;
    private JTextField num2;
    private CalculatorGUI calc;
    private double a;
    private double b;

    public MyActionListener(CalculatorGUI calc, JTextField num1, JTextField num2) {
        this.calc = calc;
        this.num1 = num1;
        this.num2 = num2;
    }

    public MyActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            a = Double.parseDouble(num1.getText());
            b = Double.parseDouble(num2.getText());

            switch (button.getActionCommand()) {
                case "Сложение":
                    calc.setFieldResult(String.valueOf(CalcOperation.addition(a, b)));
                    break;
                case "Вычитание":
                    calc.setFieldResult(String.valueOf(CalcOperation.subtraction(a, b)));
                    break;
                case "Умножение":
                    calc.setFieldResult(String.valueOf(CalcOperation.multiplication(a, b)));
                    break;
                case " Деление ":
                    calc.setFieldResult(String.valueOf(CalcOperation.division(a, b)));
                    break;
            }
        }
    }
}



