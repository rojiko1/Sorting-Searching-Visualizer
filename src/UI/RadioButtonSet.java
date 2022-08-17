package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RadioButtonSet extends JPanel {

    private final Rectangle bounds;
    private final RadioButton[] set;
    private int indexSelected;

    public RadioButtonSet(String[] options, RadioButtonAction[] actions, int defaultIndex, int x, int y) {
        if ((defaultIndex >= options.length) || (options.length != actions.length)) {throw new IllegalArgumentException();}
        set = new RadioButton[options.length];

        bounds = new Rectangle(x, y, 90 * set.length, 30);
        this.setBounds(bounds);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("radio button set clicked");
            }
        });

        for (int i = 0; i < set.length; i++) {
            set[i] = new RadioButton(options[i], bounds.x, bounds.y, 90 * i);
            this.add(set[i]);
            RadioButtonAction action = actions[i];
            int finalI = i;
            set[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (set[finalI].isEnabled()) {
                        setSelected(finalI);
                        action.act();
                    }
                }
            });
        }
        set[defaultIndex].setSelected(true);
        indexSelected = defaultIndex;
    }

    public void setSelected(int index) {
        set[indexSelected].setSelected(false);
        set[index].setSelected(true);
        indexSelected = index;
    }

    @Override
    public void setEnabled(boolean choice) {
        for (RadioButton radioButton : set) {
            radioButton.setEnabled(choice);
        }
    }

    public void render(Graphics g) {
        for (RadioButton radioButton : set) {
            radioButton.render(g);
        }
    }

}
