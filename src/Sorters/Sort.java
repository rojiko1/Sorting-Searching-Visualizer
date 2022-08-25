package Sorters;

// time complexity: best: ; average: ; worst:
// space complexity:
// sort name: commentary on efficiency

import ArrayFunctions.Pointer;
import ArrayFunctions.Swapper;
import ArrayFunctions.Element;
import java.util.ArrayList;

public abstract class Sort {

    protected static final Swapper swapper = new Swapper();

    public abstract void sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException;

    public abstract String getSortName();

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
