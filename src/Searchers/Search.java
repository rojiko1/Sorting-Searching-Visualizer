package Searchers;

// time complexity: best: ; average: ; worst:
// sort name: commentary on efficiency

import ArrayFunctions.Pointer;
import UI.Element;

import java.util.ArrayList;

public abstract class Search {

    protected static final int fastMilliseconds = 400;
    protected static final int slowMilliseconds = 1000;
    protected int speed = fastMilliseconds;

    public abstract int search(ArrayList<Element> array, Pointer pointer, int searchItem) throws InterruptedException;

    public void changeSpeed(String choice) {
        if (choice == "slow") {
            speed = slowMilliseconds;
        }
        else if (choice == "fast") {
            speed = fastMilliseconds;
        }
    }

}
