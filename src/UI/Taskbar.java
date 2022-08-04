package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Taskbar extends JPanel {

    private Rectangle bounds;
    private Switch mode;
    private Switch speed;
    private RadioButtonSet sortChoices;
    private RadioButtonSet searchChoices;
    private final String[] sorts = {"Bubble", "Heap", "Insertion", "Merge", "Quick", "Radix", "Selection", "Shell"};
    private final String[] searches = {"Binary", "Sequential"};
    private Boolean sortMode;

    public Taskbar(int width, Boolean sortMode) {
        bounds = new Rectangle(0, 0, width, 50);
        this.setBounds(0, 0, width, 50);

        mode = new Switch(30, 10, "Sort", "Search");
        this.add(mode);
        mode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (mode.isEnabled()) {
                    if (e.getX() < (mode.getBounds().width / 2)) {mode.setOption1Selected(true);}
                    else {mode.setOption1Selected(false);}
                }
            }
        });

        speed = new Switch(1000, 10, "Slow", "Fast");
        this.add(speed);
        speed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (speed.isEnabled()) {
                    if (e.getX() < (speed.getBounds().width / 2)) {speed.setOption1Selected(true);}
                    else {speed.setOption1Selected(false);}
                }
            }
        });

        sortChoices = new RadioButtonSet(sorts, 6, 240, 10);
        this.add(sortChoices);
        searchChoices = new RadioButtonSet(searches, 1, 240, 10);
        this.add(searchChoices);
        this.sortMode = sortMode;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        mode.render(g);
        speed.render(g);
        if (sortMode) {sortChoices.render(g);}
        else {searchChoices.render(g);}
    }

}
