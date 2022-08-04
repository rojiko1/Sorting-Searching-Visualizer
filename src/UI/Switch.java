package UI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Switch extends Component {

    private Rectangle bounds;
    private boolean enabled;
    private String option1;
    private String option2;
    private boolean option1Selected;

    public Switch(int x, int y, String option1, String option2) {
        bounds = new Rectangle(x + 30, y - 3, 60, 36);
        this.setBounds(bounds);

        this.enabled = true;
        this.option1 = option1;
        this.option2 = option2;
        this.option1Selected = true;
    }

    public void setOption1Selected(boolean option1Selected) {
        this.option1Selected = option1Selected;
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawString(option1, bounds.x - 30, bounds.y + 21);
        g.drawString(option2, bounds.x + 67, bounds.y + 21);
        g.setColor(Color.lightGray);
        g.fillRect(bounds.x, bounds.y + 3, 60, 30);
        g.setColor(Color.darkGray);
        if (option1Selected) {g.fillRect(bounds.x, bounds.y, 30, 36);}
        else {g.fillRect(bounds.x + 30, bounds.y, 30, 36);}
    }
}
