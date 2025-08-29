package pr16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor {

    private JFrame frame;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu colorMenu, fontMenu;
    private JMenuItem blueItem, redItem, blackItem;
    private JMenuItem timesItem, msSansItem, courierItem;

    public TextEditor() {
        frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        textArea = new JTextArea();
        textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        textArea.setForeground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        menuBar = new JMenuBar();

        colorMenu = new JMenu("Цвет");
        blueItem = new JMenuItem("Синий");
        redItem = new JMenuItem("Красный");
        blackItem = new JMenuItem("Черный");

        blueItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.BLUE);
            }
        });
        redItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.RED);
            }
        });
        blackItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(Color.BLACK);
            }
        });

        colorMenu.add(blueItem);
        colorMenu.add(redItem);
        colorMenu.add(blackItem);

        // Меню выбора шрифта
        fontMenu = new JMenu("Шрифт");
        timesItem = new JMenuItem("Times New Roman");
        msSansItem = new JMenuItem("MS Sans Serif");
        courierItem = new JMenuItem("Courier New");

        // Добавляем обработчики событий для выбора шрифта
        timesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            }
        });
        msSansItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
            }
        });
        courierItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
            }
        });

        fontMenu.add(timesItem);
        fontMenu.add(msSansItem);
        fontMenu.add(courierItem);

        menuBar.add(colorMenu);
        menuBar.add(fontMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
