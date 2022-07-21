package UI;

import java.awt.*;
import javax.swing.*;

public class UI {

    private static final Dimension dimension = new Dimension(800, 600);

    public UI() {
        JFrame frame = setupWindow();
        setText(frame);
    }

    public JFrame setupWindow() {
        JFrame frame = createWindow();
        frame.setPreferredSize(dimension);
        frame.setLocationRelativeTo(null);
        frame.setLocation(0, 0);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private JFrame createWindow() {
        JFrame frame = new JFrame("Sorting Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private void setText(JFrame frame) {
        JLabel text = new JLabel("This is the label.", SwingConstants.CENTER);
        frame.getContentPane().add(text, BorderLayout.CENTER);
    }

}
