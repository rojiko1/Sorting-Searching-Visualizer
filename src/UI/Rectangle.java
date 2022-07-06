package UI;

public class Rectangle {

    private Element elementReference;
    private int height;
    private int width;
    private int position;

    public Rectangle(Element element) {
        elementReference = element;
        height = elementReference.getValue();
        width = 20;
        position = elementReference.getIndex();
    }

    public void updateRectangle() {
        height = elementReference.getValue();
        position = elementReference.getIndex();
    }

}
