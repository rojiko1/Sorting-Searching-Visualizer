package UI;

import java.awt.*;

public class RadioButton extends Component {

    private Rectangle bounds;
    private String text;
    private boolean selected = false;

    public RadioButton(String text, int x, int y) {
        this.text = text;
        bounds = new Rectangle(x, y, 90, 30);
        this.setBounds(bounds);
    }

    public void setSelected(boolean selected) {this.selected = selected;}

    public void render(Graphics g) {
        if (selected) {
            g.setColor(Color.darkGray);
            g.fillOval(bounds.x, bounds.y + 10, 10, 10);
        }
        else {g.drawOval(bounds.x, bounds.y + 10, 10, 10);}
        g.drawString(text, bounds.x + 15, bounds.y + 20);
    }

}
