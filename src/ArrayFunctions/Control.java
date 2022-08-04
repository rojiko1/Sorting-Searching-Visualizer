package ArrayFunctions;

import Searchers.BinarySearch;
import Searchers.Search;
import Sorters.*;

import java.util.ArrayList;

public class Control {

    private Pointer pointer;
    private Sort chosenSort;
    private Search chosenSearch;

    public Control(Pointer pointer, Sort sort, Search search) {
        this.pointer = pointer;
        this.chosenSort = sort;
        this.chosenSearch = search;
    }
    public ArrayList<Element> sort(ArrayList<Element> array) throws InterruptedException {
        ArrayList<Element> sorted_array;
        sorted_array = chosenSort.sort(array, pointer);
        return sorted_array;
    }

    public int search(ArrayList<Element> array, int searchItem) throws InterruptedException {
        int index;
        if (chosenSearch instanceof BinarySearch) {
            //check that array is presorted
        }
        index = chosenSearch.search(array, pointer, searchItem);
        return index;
    }

}
