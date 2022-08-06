package UI;

import ArrayFunctions.Element;
import ArrayFunctions.Pointer;
import Main.Settings;

import java.awt.*;
import java.util.ArrayList;

public class UserInterface implements Runnable {

    private static final int FPS = 10;
    private final Display display;
    private Graphics g;
    private ArrayList<Element> array;
    private final Pointer pointer;
    private final Taskbar taskbar;

    public UserInterface(Display display, ArrayList<Element> array, Pointer pointer) {
        this.display = display;
        this.array = array;
        this.pointer = pointer;
        this.taskbar = new Taskbar(display.getPanel().getWidth());
        display.getPanel().add(this.taskbar);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (display.running()) {
            //tick
            render();
            try {
                Thread.sleep((long) 1000 / FPS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void render() {
        g = display.getPanel().getGraphics();

        g.clearRect(0, 0, display.getPanel().getWidth(), display.getPanel().getHeight());

        drawRectangles();
        pointer.render(g);
        taskbar.render(g);

        g.setColor(Color.black);
        g.drawString("Sort mode: " + Settings.isSortMode(), 700, 200);
        g.drawString("Slow mode: " + Settings.isSlowSpeed(), 700, 250);
        g.drawString("Sort Choice: " + Settings.getSort(), 700, 300);
        g.drawString("Search Choice: " + Settings.getSearch(), 700, 350);
    }

    private void drawRectangles() {
        g.setColor(Color.blue);
        for (Element element : array) {
            int width = 18;
            int height = 15 * element.getValue();
            int x = 20 + (26 * element.getIndex());
            int y = display.getPanel().getHeight() - height - 10;
            g.fillRect(x, y, width, height);
        }
    }

}
