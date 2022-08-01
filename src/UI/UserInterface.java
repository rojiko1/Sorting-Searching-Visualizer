package UI;

import ArrayFunctions.Pointer;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class UserInterface implements Runnable {

    private static final int FPS = 10;
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    private ArrayList<Element> array;
    private Pointer pointer;
    private Taskbar taskbar;

    public UserInterface(Display display, ArrayList<Element> array, Pointer pointer) {
        this.display = display;
        this.array = array;
        this.pointer = pointer;
        this.taskbar = new Taskbar(display.getCanvas().getWidth());
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
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = display.getCanvas().getGraphics();

        g.clearRect(0, 0, display.getCanvas().getWidth(), display.getCanvas().getHeight());

        drawRectangles();
        pointer.render(g);
        taskbar.render(g);
    }

    private void drawRectangles() {
        g.setColor(Color.blue);
        for (int i = 0; i < array.size(); i++) {
            Element element = array.get(i);
            int width = 18;
            int height = 15 * element.getValue();
            int x = 20 + (26 * element.getIndex());
            int y = display.getCanvas().getHeight() - height - 10;
            g.fillRect(x, y, width, height);
        }
    }

}
