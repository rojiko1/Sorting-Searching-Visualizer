package UI;

import java.awt.*;

public class Taskbar {

    private Switch mode;
    private Switch speed;
    private int windowWidth;

    public Taskbar(int width) {
        mode = new Switch(10, 10, "Sort", "Search");
        speed = new Switch(1000, 10, "Fast", "Slow");
        windowWidth = width;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, windowWidth, 50);
        mode.render(g);
        speed.render(g);
    }

}
