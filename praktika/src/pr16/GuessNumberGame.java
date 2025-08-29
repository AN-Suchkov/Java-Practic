package pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuessNumberGame {
    private JFrame frame;
    private JTextField guessField;
    private JButton guessButton;
    private int secretNumber;
    private int attempts;

    public GuessNumberGame() {
        // Инициализация
        secretNumber = (int) (Math.random() * 21);
        attempts = 0;

        frame = new JFrame("Игра Угадай число");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        guessField = new JTextField(10);
        guessField.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(guessField);

        guessButton = new JButton("Угадать");
        guessButton.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(guessButton);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        guessField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleGuess();
                }
            }
        });

        frame.setVisible(true);
    }

    private void handleGuess() {
        String guessText = guessField.getText();
        try {
            int guess = Integer.parseInt(guessText);
            attempts++;

            if (guess == secretNumber) {
                // Если угадали
                JOptionPane.showMessageDialog(frame, "Поздравляем, вы угадали число!");
                System.exit(0);
            } else if (attempts < 3) {
                // Если не угадали, даем подсказку
                String hint = (guess < secretNumber) ? "Меньше" : "Больше";
                JOptionPane.showMessageDialog(frame, "Неправильно! Попробуйте еще раз. Число " + hint + ".");
            } else {
                // Если исчерпаны все попытки
                JOptionPane.showMessageDialog(frame, "Вы исчерпали все попытки! Загаданное число было: " + secretNumber);
                System.exit(0); // Завершаем программу
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Пожалуйста, введите число!");
        }
    }

    public static void main(String[] args) {
        new GuessNumberGame();  // Запуск игры
    }
}
