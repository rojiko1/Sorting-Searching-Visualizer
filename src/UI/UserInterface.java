package UI;

import ArrayFunctions.Control;
import ArrayFunctions.Element;
import ArrayFunctions.Pointer;
import Main.Settings;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserInterface implements Runnable {

    private static final int FPS = 5;
    private final Display display;
    private Graphics g;
    private final Control control;
    private final Pointer pointer1;
    private final Pointer pointer2;
    private final Taskbar taskbar;
    private final Button startButton;
    private final Button generateArrayButton;
    private final Button shuffleArrayButton;

    public UserInterface(Display display, Control control) {
        this.display = display;
        this.control = control;
        pointer1 = new Pointer(0);
        pointer2 = new Pointer(0);
        pointer2.setVisible(false);

        this.taskbar = new Taskbar(display.getPanel().getWidth());
        display.getPanel().add(this.taskbar);

        startButton = new Button("Start", Color.orange, 1070, 80, 35);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
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

        generateArrayButton = new Button("Generate Array", Color.orange, 1070, 140, 10);
        generateArrayButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (generateArrayButton.isEnabled()) {
                    control.generateArray(Control.array_size);
                }
            }
        });
        display.getPanel().add(generateArrayButton);

        shuffleArrayButton = new Button("Shuffle Array", Color.orange, 1070, 200, 10);
        shuffleArrayButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (shuffleArrayButton.isEnabled()) {
                    control.shuffleArray();
                }
            }
        });
        display.getPanel().add(shuffleArrayButton);

        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (display.running()) {
            try {
                Thread.sleep((long) 1000 / FPS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            render();
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
        generateArrayButton.setEnabled(choice);
        shuffleArrayButton.setEnabled(choice);
    }

    private void render() {
        g = display.getPanel().getGraphics();

        g.clearRect(0, 0, display.getPanel().getWidth(), display.getPanel().getHeight());

        drawRectangles();
        pointer1.render(g);
        pointer2.render(g);
        taskbar.render(g);
        startButton.render(g);
        generateArrayButton.render(g);
        shuffleArrayButton.render(g);
    }

    private void drawRectangles() {
        g.setColor(Color.blue);
        for (Element element : control.getArray()) {
            int width = 9;
            int height = 5 * element.getValue();
            int x = 20 + (13 * element.getIndex());
            int y = display.getPanel().getHeight() - height - 10;
            g.fillRect(x, y, width, height);
        }
    }

}
