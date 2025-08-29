package pr12;

import javax.swing.*;

public class RandomShapesTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        RandomShapes panel = new RandomShapes();

        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
