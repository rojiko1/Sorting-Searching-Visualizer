package Main;

import Searchers.BinarySearch;
import Searchers.SequentialSearch;
import UI.Element;

import java.util.ArrayList;

public class SearchControl {

    private static BinarySearch binarySearch = new BinarySearch();
    private static SequentialSearch sequentialSearch = new SequentialSearch();

    public int executeOptimalSearch(ArrayList<Element> array, int searchItem, boolean presorted) {
        int index;
        if (presorted) {
            index = binarySearch.search(array, searchItem);
        }
        else {
            index = sequentialSearch.search(array, searchItem);
        }
        return index;
    }

}
