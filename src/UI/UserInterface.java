package UI;

import ArrayFunctions.Element;
import ArrayFunctions.Pointer;
import Main.Settings;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class UserInterface implements Runnable {

    private static final int FPS = 5;
    private Display display;
    private BufferStrategy bs;
    private Graphics g;
    private ArrayList<Element> array;
    private Pointer pointer;
    private Taskbar taskbar;
    private final String[] sorts = {"Bubble", "Heap", "Insertion", "Merge", "Quick", "Radix", "Selection", "Shell"};
    private final String[] searches = {"Binary", "Sequential"};
    private Settings settings;

    public UserInterface(Display display, ArrayList<Element> array, Pointer pointer, Settings settings) {
        this.display = display;
        this.array = array;
        this.pointer = pointer;
        this.settings = settings;
        this.taskbar = new Taskbar(display.getPanel().getWidth(), settings.isSortMode());
        display.getPanel().add(this.taskbar);
        taskbar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("taskbar clicked");
            }
        });

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
        /*bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }*/
        g = display.getPanel().getGraphics();

        g.clearRect(0, 0, display.getPanel().getWidth(), display.getPanel().getHeight());

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
            int y = display.getPanel().getHeight() - height - 10;
            g.fillRect(x, y, width, height);
        }
    }

}
