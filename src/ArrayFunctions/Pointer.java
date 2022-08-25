package ArrayFunctions;

import java.awt.*;

public class Pointer {

    private int currentIndex;
    private boolean visible;

    public Pointer(int index) {
        currentIndex = index;
        visible = true;
    }

    public int getCurrentIndex() {return currentIndex;}

    public void setCurrentIndex(int index) {currentIndex = index;}

    public void setVisible(boolean isVisible) {visible = isVisible;}

    public void incrementCurrentIndex() {
        currentIndex++;
    }

    public void render(Graphics g) {
        if (visible) {
            g.setColor(Color.red);
            g.fillRect(17 + (13 * getCurrentIndex()), 60, 2, 500);
        }
    }

}
