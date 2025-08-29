package pr12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpriteAnimation extends JPanel implements ActionListener {
    private BufferedImage spriteSheet; // Полное изображение (sprite sheet)
    private int frameWidth, frameHeight; // Размер одного кадра
    private int currentFrame = 0; // Текущий кадр
    private int totalFrames; // Общее количество кадров
    private Timer timer; // Таймер для анимации

    public SpriteAnimation(String spriteSheetName, int frameWidth, int frameHeight, int frameDelay) {
        try {
            // Загрузка изображения из того же пакета
            spriteSheet = ImageIO.read(getClass().getResource(spriteSheetName));
            System.out.println("Файл успешно загружен.");
        } catch (IOException | NullPointerException e) {
            System.err.println("Ошибка загрузки изображения: " + e.getMessage());
            return;
        }

        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.totalFrames = spriteSheet.getWidth() / frameWidth;

        // Настройка таймера для обновления анимации
        timer = new Timer(frameDelay, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (spriteSheet != null) {
            // Вычисление координат текущего кадра
            int frameX = currentFrame * frameWidth;
            g.drawImage(spriteSheet, 50, 50, 50 + frameWidth, 50 + frameHeight,
                    frameX, 0, frameX + frameWidth, frameHeight, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Обновление кадра
        currentFrame = (currentFrame + 1) % totalFrames;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sprite Animation");
        SpriteAnimation animationPanel = new SpriteAnimation("qqq.png", 70, 130, 100);

        frame.add(animationPanel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
