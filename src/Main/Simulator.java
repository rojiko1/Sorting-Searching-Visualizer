package Main;

import ArrayFunctions.Control;
import ArrayFunctions.Element;
import ArrayFunctions.Pointer;
import UI.*;
import java.util.ArrayList;
import java.util.Random;

public class Simulator {

    private final Control control;
    private final Display display;
    private final UserInterface userInterface;
    private ArrayList<Element> array;
    private boolean sorted;
    private final Pointer pointer;
    private final Random random = new Random();

    public Simulator() throws InterruptedException {
        generateArray(25);
        pointer = new Pointer(0);
        control = new Control(pointer);
        display = new Display();
        userInterface = new UserInterface(display, array, pointer);

        ArrayList<Element> sorted_array = control.sort(array);
        System.out.println(control.search(array, 7));
    }

    public void generateArray(int len) {
        array = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            array.add(new Element(random.nextInt(30) + 1, i));
        }
        sorted = false;
    }

}
