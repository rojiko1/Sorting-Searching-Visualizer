package UI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Switch extends Component {

    private final Rectangle bounds;
    private final String option1;
    private final String option2;
    private boolean option1Selected;

    public Switch(int x, int y, String option1, String option2, SwitchAction leftAction, SwitchAction rightAction) {
        bounds = new Rectangle(x + 30, y - 3, 60, 36);
        this.setBounds(bounds);

        this.option1 = option1;
        this.option2 = option2;
        this.option1Selected = true;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isEnabled()) {
                    if (e.getX() < (getBounds().width / 2)) {
                        setOption1Selected(true);
                        leftAction.act();
                    }
                    else {
                        setOption1Selected(false);
                        rightAction.act();
                    }
                }
            }
        });
    }

    public void setOption1Selected(boolean option1Selected) {
        this.option1Selected = option1Selected;
    }

    public void render(Graphics g) {
        if (isEnabled()) {
            g.setColor(Color.black);
            g.drawString(option1, bounds.x - 30, bounds.y + 21);
            g.drawString(option2, bounds.x + 67, bounds.y + 21);
            g.setColor(Color.lightGray);
            g.fillRect(bounds.x, bounds.y + 3, 60, 30);
            g.setColor(Color.darkGray);
            if (option1Selected) {
                g.fillRect(bounds.x, bounds.y, 30, 36);
            } else {
                g.fillRect(bounds.x + 30, bounds.y, 30, 36);
            }
        }
    }
}
