package UI;

import java.awt.*;

public class RadioButton extends Component {

    private final Rectangle bounds;
    private final int initX;
    private final int initY;
    private final String text;
    private boolean selected = false;

    public RadioButton(String text, int initX, int initY, int x) {
        this.text = text;
        this.initX = initX;
        this.initY = initY;

        bounds = new Rectangle(x, 0, 90, 30);
        this.setBounds(bounds);
    }

    public void setSelected(boolean selected) {this.selected = selected;}

    public void render(Graphics g) {
        if (selected) {
            g.setColor(Color.darkGray);
            g.fillOval(bounds.x + initX, bounds.y + initY + 10, 10, 10);
        }
        else {g.drawOval(bounds.x + initX, bounds.y + initY + 10, 10, 10);}
        g.drawString(text, bounds.x + initX + 15, bounds.y + initY + 20);
    }

}
