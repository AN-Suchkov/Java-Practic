package pr5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchScoreApp {
    private JFrame frame;
    private JLabel resultLabel;
    private JLabel lastScorerLabel;
    private JLabel winnerLabel;
    private int milanScore = 0;
    private int madridScore = 0;

    // Задаём путь к изображению прямо в коде
    private static final String BACKGROUND_IMAGE_PATH = "C:\\Users\\Alexs\\Downloads\\4tyymb.jpg";

    public MatchScoreApp() {
        // Создаём основное окно
        frame = new JFrame("Match Score");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Создаем панель с фоновым изображением
        BackgroundPanel backgroundPanel = new BackgroundPanel(BACKGROUND_IMAGE_PATH);
        backgroundPanel.setLayout(new BorderLayout());

        // Панель для кнопок и меток
        JPanel controlPanel = new JPanel();
        controlPanel.setOpaque(false); // Делаем панель прозрачной, чтобы фон был виден
        controlPanel.setLayout(new GridLayout(3, 1));

        // Метка для отображения результата
        resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        controlPanel.add(resultLabel);

        // Метка для последнего забившего
        lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
        lastScorerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        controlPanel.add(lastScorerLabel);

        // Метка для победителя
        winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        controlPanel.add(winnerLabel);

        // Кнопки для команд
        JButton milanButton = new JButton("AC Milan");
        milanButton.addActionListener(new TeamScoreListener("AC Milan"));

        JButton madridButton = new JButton("Real Madrid");
        madridButton.addActionListener(new TeamScoreListener("Real Madrid"));

        // Добавляем компоненты в главное окно
        backgroundPanel.add(controlPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(milanButton);
        buttonPanel.add(madridButton);
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(backgroundPanel);
        frame.setVisible(true);
    }

    private class TeamScoreListener implements ActionListener {
        private String team;

        public TeamScoreListener(String team) {
            this.team = team;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (team.equals("AC Milan")) {
                milanScore++;
                lastScorerLabel.setText("Last Scorer: AC Milan");
            } else if (team.equals("Real Madrid")) {
                madridScore++;
                lastScorerLabel.setText("Last Scorer: Real Madrid");
            }

            resultLabel.setText("Result: " + milanScore + " X " + madridScore);

            // Определяем победителя
            if (milanScore > madridScore) {
                winnerLabel.setText("Winner: AC Milan");
            } else if (milanScore < madridScore) {
                winnerLabel.setText("Winner: Real Madrid");
            } else {
                winnerLabel.setText("Winner: DRAW");
            }
        }
    }

    // Внутренний класс для панели с фоновым изображением
    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            // Загружаем изображение
            ImageIcon icon = new ImageIcon(imagePath);
            backgroundImage = icon.getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Отрисовываем изображение на весь размер панели
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MatchScoreApp::new);
    }
}
