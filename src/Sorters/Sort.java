package Sorters;

// time complexity: best: ; average: ; worst:
// sort name: (in)efficient sorting algorithm; highly (un)scalable
// additional comments

import Main.Swapper;
import UI.Element;
import java.util.ArrayList;

public abstract class Sort {

    protected static final int fastMilliseconds = 2;
    protected static final int slowMilliseconds = 5;
    protected static final Swapper swapper = new Swapper();

    public abstract ArrayList<Element> sort(ArrayList<Element> array);

    public abstract String getSortName();

    protected void updateIndices(ArrayList<Element> array) {
        for (int i = 0; i < array.size(); i++) {
            array.get(i).setIndex(i);
        }
    }

}
