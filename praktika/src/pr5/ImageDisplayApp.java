package pr5;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageDisplayApp {
    private JFrame frame;
    private JLabel imageLabel;

    public ImageDisplayApp(String imagePath) {
        // Создаем новое окно
        frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Загружаем изображение
        ImageIcon imageIcon = new ImageIcon(imagePath);
        imageLabel = new JLabel(imageIcon);

        // Проверяем, удалось ли загрузить изображение
        if (imageIcon.getIconWidth() == -1) {
            showErrorDialog("Image not found", "The specified image file does not exist: " + imagePath);
            return; // Не продолжаем, если изображение не найдено
        }

        // Добавляем метку с изображением в окно
        frame.getContentPane().add(imageLabel, BorderLayout.CENTER);

        // Устанавливаем видимость окна
        frame.setVisible(true);
    }

    private void showErrorDialog(String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
        frame.dispose(); // Закрываем окно после показа сообщения
    }

    private static void showErrorDialogStatic(JFrame frame, String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        // Проверяем, что передан путь к изображению
        if (args.length < 1) {
            System.out.println("Please provide the image path as a command line argument.");
            System.exit(1);
        }

        String imagePath = args[0];

        // Проверка существования файла
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            // Показываем сообщение об ошибке и завершаем программу
            showErrorDialogStatic(null, "Image not found", "The specified image file does not exist: " + imagePath);
            System.exit(1);
        }

        // Создаем экземпляр приложения
        SwingUtilities.invokeLater(() -> new ImageDisplayApp(imagePath));
    }
}
