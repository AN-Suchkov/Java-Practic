package pr15;

import java.awt.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {
        Frame frame = new Frame("Calculator");
        frame.setSize(350, 240);
        frame.setLayout(null);

        TextField tf1 = new TextField();
        tf1.setBounds(50, 50, 100, 30);
        TextField tf2 = new TextField();
        tf2.setBounds(200, 50, 100, 30);

        TextField result = new TextField();
        result.setBounds(50, 100, 250, 30);
        result.setEditable(false);

        Button addButton = new Button("+");
        addButton.setBounds(50, 150, 50, 30);
        Button subtractButton = new Button("-");
        subtractButton.setBounds(110, 150, 50, 30);
        Button multiplyButton = new Button("*");
        multiplyButton.setBounds(170, 150, 50, 30);
        Button divideButton = new Button("/");
        divideButton.setBounds(230, 150, 50, 30);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(tf1.getText());
                    double num2 = Double.parseDouble(tf2.getText());
                    result.setText("Сумма: " + (num1 + num2));
                } catch (NumberFormatException ex) {
                    result.setText("Введите корректные числа");
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(tf1.getText());
                    double num2 = Double.parseDouble(tf2.getText());
                    result.setText("Разность: " + (num1 - num2));
                } catch (NumberFormatException ex) {
                    result.setText("Введите корректные числа");
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(tf1.getText());
                    double num2 = Double.parseDouble(tf2.getText());
                    result.setText("Произведение: " + (num1 * num2));
                } catch (NumberFormatException ex) {
                    result.setText("Введите корректные числа");
                }
            }
        });

        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(tf1.getText());
                    double num2 = Double.parseDouble(tf2.getText());
                    if (num2 == 0) {
                        result.setText("На ноль делить нельзя");
                    } else {
                        result.setText("Частное: " + (num1 / num2));
                    }
                } catch (NumberFormatException ex) {
                    result.setText("Введите корректные числа");
                }
            }
        });

        frame.add(tf1);
        frame.add(tf2);
        frame.add(result);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
