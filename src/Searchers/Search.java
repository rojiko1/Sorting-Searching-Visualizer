package Searchers;

// time complexity: best: ; average: ; worst:
// sort name: commentary on efficiency

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;

import java.util.ArrayList;

public abstract class Search {

    public abstract int search(ArrayList<Element> array, Pointer pointer, int searchItem) throws InterruptedException;

    public abstract String getSearchName();

}
