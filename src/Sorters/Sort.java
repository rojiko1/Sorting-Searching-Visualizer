package Sorters;

// time complexity: best: ; average: ; worst:
// sort name: commentary on efficiency

import ArrayFunctions.Pointer;
import ArrayFunctions.Swapper;
import UI.Element;
import java.util.ArrayList;

public abstract class Sort {

    protected static final int fastMilliseconds = 100;
    protected static final int slowMilliseconds = 300;
    protected int speed = fastMilliseconds;
    protected static final Swapper swapper = new Swapper();

    public abstract ArrayList<Element> sort(ArrayList<Element> array, Pointer pointer) throws InterruptedException;

    public abstract String getSortName();

    public void changeSpeed(String choice) {
        if (choice == "slow") {
            speed = slowMilliseconds;
        }
        else if (choice == "fast") {
            speed = fastMilliseconds;
        }
    }

    protected void swap(ArrayList<Element> array, int firstIndex, int secondIndex) {
        swapper.swap(array, firstIndex, secondIndex);
        array.get(firstIndex).setIndex(firstIndex);
        array.get(secondIndex).setIndex(secondIndex);
    }

    protected void updateIndices(ArrayList<Element> array) {
        for (int i = 0; i < array.size(); i++) {
            array.get(i).setIndex(i);
        }
    }

}
