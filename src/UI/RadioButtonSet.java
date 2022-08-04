package UI;

import javax.swing.*;
import java.awt.*;

public class RadioButtonSet extends JPanel {

    private Rectangle bounds;
    private RadioButton[] set;

    public RadioButtonSet(String[] options, int defaultIndex, int x, int y) {
        if (defaultIndex >= options.length) {throw new IllegalArgumentException();}
        set = new RadioButton[options.length];
        for (int i = 0; i < set.length; i++) {
            set[i] = new RadioButton(options[i], x + (90 * i), y);
        }
        set[defaultIndex].setSelected(true);

        bounds = new Rectangle(x, y, 90 * set.length, 30);
        this.setBounds(bounds);
    }

    public void setSelected(int index) {

    }

    public void render(Graphics g) {
        for (int i = 0; i < set.length; i++) {
            set[i].render(g);
        }
    }

}
