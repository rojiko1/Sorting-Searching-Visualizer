package UI;

import java.awt.*;

public class Switch {

    private int x;
    private int y;
    private String option1;
    private String option2;
    private boolean option1Selected;

    public Switch(int x, int y, String option1, String option2) {
        this.x = x;
        this.y = y;
        this.option1 = option1;
        this.option2 = option2;
        this.option1Selected = true;
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawString(option1, x, y + 18);
        g.drawString(option2, x + 97, y + 18);
        g.setColor(Color.lightGray);
        g.fillRect(x + 30, y, 60, 30);
        g.setColor(Color.darkGray);
        if (option1Selected) {g.fillRect(x + 30, y - 3, 30, 36);}
        else {g.fillRect(x + 80, y - 3, 30, 36);}
    }

}
