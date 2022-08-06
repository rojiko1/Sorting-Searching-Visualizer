package UI;

import ArrayFunctions.Control;
import Main.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Taskbar extends JPanel {

    private final Taskbar self = this;
    private final Rectangle bounds;
    private final Switch mode;
    private final Switch speed;
    private final RadioButtonSet sortChoices;
    private final RadioButtonSet searchChoices;

    public Taskbar(int width) {
        bounds = new Rectangle(0, 0, width, 50);
        this.setBounds(0, 0, width, 50);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("taskbar clicked");
            }
        });
        mode = new Switch(30, 10, "Sort", "Search", new SwitchAction() {
            @Override
            public void act() {
                Settings.setMode(true);
                self.remove(searchChoices);
                self.add(searchChoices);
            }
        }, new SwitchAction() {
            @Override
            public void act() {
                Settings.setMode(false);
                self.remove(sortChoices);
                self.add(sortChoices);
            }
        });
        this.add(mode);

        speed = new Switch(1000, 10, "Slow", "Fast", () -> Settings.setSpeed(true), () -> Settings.setSpeed(false));
        this.add(speed);

        RadioButtonAction[] sortActions = new RadioButtonAction[Control.getSorts().length];
        for (int i = 0; i < sortActions.length; i++) {
            int finalI = i;
            sortActions[i] = () -> Settings.setSort(Control.getSorts()[finalI]);
        }

        RadioButtonAction[] searchActions = new RadioButtonAction[Control.getSearches().length];
        for (int i = 0; i < searchActions.length; i++) {
            int finalI = i;
            searchActions[i] = () -> Settings.setSearch(Control.getSearches()[finalI]);
        }

        sortChoices = new RadioButtonSet(Control.getSortNames(), sortActions, 6, 240, 10);
        this.add(sortChoices);
        searchChoices = new RadioButtonSet(Control.getSearchNames(), searchActions, 1, 240, 10);
        this.add(searchChoices);
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        mode.render(g);
        speed.render(g);
        if (Settings.isSortMode()) {sortChoices.render(g);}
        else {searchChoices.render(g);}
    }

}
