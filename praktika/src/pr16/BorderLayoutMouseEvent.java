package pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BorderLayoutMouseEvent {
    private static boolean dialogOpen = false;

    public static void main(String[] args) {
        // Создаем окно
        JFrame frame = new JFrame("Пример макета с событиями мыши");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        // Создаем панели для каждой области макета
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.LIGHT_GRAY);
        JPanel westPanel = new JPanel();
        westPanel.setBackground(Color.CYAN);
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.GREEN);
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.YELLOW);
        JPanel eastPanel = new JPanel();
        eastPanel.setBackground(Color.PINK);

        centerPanel.setPreferredSize(new Dimension(300, 300));
        westPanel.setPreferredSize(new Dimension(150, 400));
        southPanel.setPreferredSize(new Dimension(600, 100));
        northPanel.setPreferredSize(new Dimension(600, 100));
        eastPanel.setPreferredSize(new Dimension(150, 400));

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(eastPanel, BorderLayout.EAST);

        centerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showDialog(frame, "Добро пожаловать в ЦАО");
            }
        });

        westPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showDialog(frame, "Добро пожаловать в ЗАО");
            }
        });

        southPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showDialog(frame, "Добро пожаловать ЮАО");
            }
        });

        northPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showDialog(frame, "Добро пожаловать в САО");
            }
        });

        eastPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showDialog(frame, "Добро пожаловать в ВАО");
            }
        });

        frame.setVisible(true);
    }

    private static void showDialog(JFrame frame, String message) {
        if (!dialogOpen) {
            dialogOpen = true;
            JOptionPane optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog(frame, "Сообщение");

            dialog.setLocation(frame.getX() + frame.getWidth(), frame.getY());
            dialog.setVisible(true);
            dialogOpen = false;  
        }
    }
}
