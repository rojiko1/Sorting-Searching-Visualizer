package Main;

import ArrayFunctions.Pointer;
import ArrayFunctions.SearchControl;
import ArrayFunctions.SortControl;
import UI.*;
import java.util.ArrayList;
import java.util.Random;

public class Simulator {

    private SortControl sortControl;
    private SearchControl searchControl;
    private Settings settings;
    private Display display;
    private UserInterface userInterface;
    private ArrayList<Element> array;
    private boolean sorted;
    private Pointer pointer;
    private Random random = new Random();

    public Simulator() throws InterruptedException {
        generateArray(25);
        pointer = new Pointer(0);
        sortControl = new SortControl(pointer);
        searchControl = new SearchControl(pointer);
        settings = new Settings("slow", "sort", sortControl.getDefaultSort(), searchControl.getDefaultSearch());
        display = new Display();
        userInterface = new UserInterface(display, array, pointer);

        ArrayList<Element> sorted_array = sortControl.executeOptimalSort(array);
        System.out.println(searchControl.executeOptimalSearch(array, 7, false));
        System.out.println(searchControl.executeOptimalSearch(array, 7, true));
    }

    public void generateArray(int len) {
        array = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            array.add(new Element(random.nextInt(30) + 1, i));
        }
        sorted = false;
    }

}
