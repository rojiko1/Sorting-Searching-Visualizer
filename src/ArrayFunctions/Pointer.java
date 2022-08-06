package ArrayFunctions;

import java.awt.*;

public class Pointer {

    private int currentIndex;

    public Pointer(int index) {
        currentIndex = index;
    }

    public int getCurrentIndex() {return currentIndex;}

    public void setCurrentIndex(int index) {currentIndex = index;}

    public void incrementCurrentIndex() {
        currentIndex++;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(14 + (26 * getCurrentIndex()), 60, 4, 500);
    }

}
