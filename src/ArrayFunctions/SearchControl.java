package ArrayFunctions;

import Searchers.BinarySearch;
import Searchers.Search;
import Searchers.SequentialSearch;
import UI.Element;

import java.util.ArrayList;

public class SearchControl {

    private Pointer pointer;
    private static BinarySearch binarySearch = new BinarySearch();
    private static SequentialSearch sequentialSearch = new SequentialSearch();

    public SearchControl(Pointer pointer) {
        this.pointer = pointer;
    }

    public int executeOptimalSearch(ArrayList<Element> array, int searchItem, boolean presorted) throws InterruptedException {
        int index;
        if (presorted) {
            index = binarySearch.search(array, pointer, searchItem);
        }
        else {
            index = sequentialSearch.search(array, pointer, searchItem);
        }
        pointer.setCurrentIndex(0);
        return index;
    }

    public Search getDefaultSearch() {return sequentialSearch;}

}
