package Main;

import Searchers.SequentialSearch;

public class SearchControl {

    private static SequentialSearch sequentialSearch = new SequentialSearch();

    public int executeOptimalSearch(int[] array, int searchItem) {
        int index = sequentialSearch.search(array, searchItem);
        return index;
    }

}
