package ArrayFunctions;

public class Element {

    private int value;
    private int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
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
