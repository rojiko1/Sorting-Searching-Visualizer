package UI;

import java.awt.*;

public class Button extends Component {

    private final Rectangle bounds;
    private final int textX;
    private final String label;
    private final Color color;

    public Button(String label, Color color, int x, int y, int textX) {
        bounds = new Rectangle(x, y, 100, 40);
        this.setBounds(bounds);

        this.textX = textX;
        this.label = label;
        this.color = color;
    }

    public void render(Graphics g) {
        if (isEnabled()) {
            g.setColor(color);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
            g.setColor(Color.black);
            g.drawString(label, bounds.x + textX, bounds.y + 25);
        }
    }

}
