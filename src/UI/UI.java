package UI;

import java.awt.*;
import javax.swing.*;

public class UI {

    public UI() {
        JFrame frame = setupWindow();
    }

    public JFrame setupWindow() {
        JFrame frame = createWindow();
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private JFrame createWindow() {
        JFrame frame = new JFrame("Sorting Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private void setText() {
        // JLabel
    }

}
