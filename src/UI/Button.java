package UI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends Component {

    private final Rectangle bounds;
    private String label;
    private Color color;

    public Button(String label, Color color, int x, int y) {
        bounds = new Rectangle(x, y, 100, 40);
        this.setBounds(bounds);

        this.label = label;
        this.color = color;
    }

    public void render(Graphics g) {
        if (isEnabled()) {
            g.setColor(color);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            g.setColor(Color.black);
            g.drawString(label, bounds.x + 35, bounds.y + 25);
        }
    }

}
