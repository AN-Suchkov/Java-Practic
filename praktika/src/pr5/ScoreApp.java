package pr5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreApp {
    private JFrame frame;
    private int milanScore = 0;
    private int madridScore = 0;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;

    public ScoreApp() {
        frame = new JFrame("Match Score");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Создаем метки для отображения результатов и статуса
        resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);

        // Создаем кнопки для команд
        JButton milanButton = new JButton("AC Milan");
        JButton madridButton = new JButton("Real Madrid");

        // Добавляем обработчики событий для кнопок
        milanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                milanScore++;
                updateScore("AC Milan");
            }
        });

        madridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                madridScore++;
                updateScore("Real Madrid");
            }
        });

        // Панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Используем FlowLayout для кнопок
        buttonPanel.add(milanButton);
        buttonPanel.add(madridButton);
        milanButton.setFocusPainted(false);
        madridButton.setFocusPainted(false);

        // Панель для меток
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1)); // Используем GridLayout для меток
        labelPanel.add(resultLabel);
        labelPanel.add(lastScorerLabel);
        labelPanel.add(winnerLabel);

        // Добавляем панели на фрейм
        frame.add(labelPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Метод для обновления счёта
    private void updateScore(String lastScorer) {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Last Scorer: " + lastScorer);

        // Определяем победителя или ничью
        if (milanScore > madridScore) {
            winnerLabel.setText("Winner: AC Milan");
        } else if (madridScore > milanScore) {
            winnerLabel.setText("Winner: Real Madrid");
        } else {
            winnerLabel.setText("Winner: DRAW");
        }
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScoreApp app = new ScoreApp();
            app.show();
        });
    }
}
