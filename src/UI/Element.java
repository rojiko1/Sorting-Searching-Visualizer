package UI;

public class Element {

    private int value;
    private int index;
    private Rectangle rectangle;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
        this.rectangle = new Rectangle(this);
    }

    public int getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String toString() {
        return "(" + "value: " + value + ", index: " + index + ")";
    }

}
