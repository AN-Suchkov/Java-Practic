package pr15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField display;
    private double num1, num2;
    private String operator;

    public CalculatorGUI() {
        // Создаем главное окно
        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 700); // Увеличен размер окна
        frame.setLayout(null);

        // Поле для отображения (экран)
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 32));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        display.setBounds(20, 20, 400, 80);
        frame.add(display);

        // Панель для кнопок с абсолютным расположением
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(20, 120, 400, 500); // Увеличен размер панели
        frame.add(buttonPanel);

        // Массив кнопок
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C" // Кнопка очистки
        };

        // Создаем кнопки и добавляем их
        int x = 10, y = 10;
        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i]);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setBounds(x, y, 80, 80); // Увеличен размер кнопок
            button.setBackground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));

            // Анонимный класс для обработки событий
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

            x += 90; // Смещение по горизонтали
            if ((i + 1) % 4 == 0) {
                x = 10;
                y += 90; // Смещение по вертикали
            }
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
