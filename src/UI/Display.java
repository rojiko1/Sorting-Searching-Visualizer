package UI;

import Main.Settings;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Display {

    private final Dimension dimension = new Dimension(1200, 600);
    private JFrame frame;
    private Canvas canvas;

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

        canvas = new Canvas();
        canvas.setPreferredSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setMaximumSize(dimension);
        frame.add(canvas);

        frame.pack();
        frame.setVisible(true);
    }

    public boolean running() {return frame.isVisible();}

    public Canvas getCanvas() {return canvas;}

}
