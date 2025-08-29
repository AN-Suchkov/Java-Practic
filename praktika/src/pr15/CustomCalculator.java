package pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomCalculator {
    private JFrame frame;
    private JTextField display;
    private double num1, num2;
    private String operator;

    public CustomCalculator() {
        // Создаем главное окно
        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 370); // Изменен размер окна
        frame.setLayout(new BorderLayout());

        // Поле для отображения (экран)
        display = new JTextField();
        display.setFont(new Font("Courier New", Font.BOLD, 28)); // Изменен шрифт
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        frame.add(display, BorderLayout.CENTER);

        // Панель для кнопок с использованием GridLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10)); // Сетка 5x4
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Массив кнопок
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C" // Кнопка очистки
        };

        // Создаем кнопки и добавляем их
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Tahoma", Font.BOLD, 18)); // Другой шрифт
            button.setBackground(new Color(255, 228, 196)); // Новый цвет кнопок
            button.setForeground(Color.DARK_GRAY);
            button.setFocusPainted(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();

                    if (command.matches("[0-9.]")) {
                        // Если нажата цифра или точка
                        display.setText(display.getText() + command);
                    } else if (command.matches("[/*\\-+]")) {
                        // Если нажата операция
                        num1 = Double.parseDouble(display.getText());
                        operator = command;
                        display.setText("");
                    } else if (command.equals("=")) {
                        // Если нажата кнопка равно
                        num2 = Double.parseDouble(display.getText());
                        double result = 0;

                        switch (operator) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                result = num1 / num2;
                                break;
                        }
                        display.setText(String.valueOf(result));
                    } else if (command.equals("C")) {
                        // Если нажата кнопка очистки
                        display.setText("");
                        num1 = 0;
                        num2 = 0;
                        operator = null;
                    }
                }
            });
            buttonPanel.add(button);
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CustomCalculator();
    }
}
