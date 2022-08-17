package UI;

import ArrayFunctions.Control;
import ArrayFunctions.Element;
import ArrayFunctions.Pointer;
import Main.Settings;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UserInterface implements Runnable {

    private static final int FPS = 10;
    private final Display display;
    private Graphics g;
    private ArrayList<Element> array;
    private final Pointer pointer1;
    private final Pointer pointer2;
    private final Taskbar taskbar;
    private final Button startButton;

    public UserInterface(Display display, ArrayList<Element> array, Control control) {
        this.display = display;
        this.array = array;
        pointer1 = new Pointer(0);
        pointer2 = new Pointer(0);
        pointer2.setVisible(false);
        this.taskbar = new Taskbar(display.getPanel().getWidth());
        display.getPanel().add(this.taskbar);
        startButton = new Button("Start", Color.orange, 900, 200);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (startButton.isEnabled()) {
                    if (Settings.isSortMode()) {
                        try {
                            control.sort();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else {
                        try {
                            control.search(7);
                            // change the search item field input
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
        display.getPanel().add(startButton);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (display.running()) {
            render();
            try {
                Thread.sleep((long) 1000 / FPS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Pointer getPointer1() {
        return pointer1;
    }

    public Pointer getPointer2() {
        return pointer2;
    }

    public void setAllElementsEnabled(boolean choice) {
        taskbar.setEnabled(choice);
        startButton.setEnabled(choice);
    }

    private void render() {
        g = display.getPanel().getGraphics();

        g.clearRect(0, 0, display.getPanel().getWidth(), display.getPanel().getHeight());

        drawRectangles();
        pointer1.render(g);
        pointer2.render(g);
        taskbar.render(g);
        startButton.render(g);

        g.setColor(Color.black);
        g.drawString("Sort mode: " + Settings.isSortMode(), 800, 200);
        g.drawString("Slow mode: " + Settings.isSlowSpeed(), 800, 250);
        g.drawString("Sort Choice: " + Settings.getSort(), 800, 300);
        g.drawString("Search Choice: " + Settings.getSearch(), 800, 350);
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
