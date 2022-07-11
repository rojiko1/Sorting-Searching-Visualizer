package Sorters;

// time complexity: best: ; average: ; worst:
// sort name: (in)efficient sorting algorithm; highly (un)scalable
// additional comments

import UI.Element;
import java.util.ArrayList;

public abstract class Sort {

    protected static final int fastMilliseconds = 2;
    protected static final int slowMilliseconds = 5;

    public abstract ArrayList<Element> sort(ArrayList<Element> array);

    public abstract String getSortName();

    protected ArrayList<Element> swap(ArrayList<Element> array, int firstIndex, int secondIndex) {
        // switch positions
        Element first = array.get(firstIndex);
        array.set(firstIndex, array.get(secondIndex));
        array.set(secondIndex, first);
        // update indexes of Elements
        array.get(firstIndex).setIndex(firstIndex);
        array.get(secondIndex).setIndex(secondIndex);
        return array;
    }

    protected ArrayList<Element> updateIndices(ArrayList<Element> array) {
        for (int i = 0; i < array.size(); i++) {
            array.get(i).setIndex(i);
        }
        return array;
    }

}
