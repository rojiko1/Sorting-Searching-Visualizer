package UI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Display {

    private final Dimension dimension = new Dimension(1200, 600);
    private JFrame frame;
    private JPanel panel;

    public Display() {
        initializeWindow();
    }

    public void initializeWindow() {
        frame = new JFrame("Sorting/Searching Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(dimension);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLocation(0, 0);

        panel = new JPanel();
        panel.setPreferredSize(dimension);
        panel.setMinimumSize(dimension);
        panel.setMaximumSize(dimension);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        frame.addMouseListener(new MouseAdapter() {});
        panel.addMouseListener(new MouseAdapter() {});

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public boolean running() {return frame.isVisible();}

    public JPanel getPanel() {return panel;}

}
