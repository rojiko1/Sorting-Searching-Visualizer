package ArrayFunctions;

import Main.Settings;
import Searchers.BinarySearch;
import Searchers.Search;
import Searchers.SequentialSearch;
import Sorters.*;

import java.util.ArrayList;

public class Control {

    private static final BubbleSort bubbleSort = new BubbleSort();
    private static final HeapSort heapSort = new HeapSort();
    private static final InsertionSort insertionSort = new InsertionSort();
    private static final MergeSort mergeSort = new MergeSort();
    private static final QuickSort quickSort = new QuickSort();
    private static final RadixSort radixSort = new RadixSort();
    private static final SelectionSort selectionSort = new SelectionSort();
    private static final ShellSort shellSort = new ShellSort();
    private static final Sort[] sorts = {bubbleSort, heapSort, insertionSort, mergeSort, quickSort, radixSort, selectionSort, shellSort};
    private static String[] sortNames = null;

    private static final BinarySearch binarySearch = new BinarySearch();
    private static final SequentialSearch sequentialSearch = new SequentialSearch();
    private static final Search[] searches = {binarySearch, sequentialSearch};
    private static String[] searchNames = null;
    private final Pointer pointer;

    public Control(Pointer pointer) {
        this.pointer = pointer;
        sortNames = new String[sorts.length];
        for (int i = 0; i < sorts.length; i++) {
            sortNames[i] = sorts[i].getSortName();
        }
        searchNames = new String[searches.length];
        for (int i = 0; i < searches.length; i++) {
            searchNames[i] = searches[i].getSearchName();
        }
    }
    public ArrayList<Element> sort(ArrayList<Element> array) throws InterruptedException {
        ArrayList<Element> sorted_array;
        sorted_array = Settings.getSort().sort(array, pointer);
        return sorted_array;
    }

    public int search(ArrayList<Element> array, int searchItem) throws InterruptedException {
        int index;
        if (Settings.getSearch() instanceof BinarySearch) {
            //check that array is presorted
        }
        index = Settings.getSearch().search(array, pointer, searchItem);
        return index;
    }

    public static BubbleSort getBubbleSort() {
        return bubbleSort;
    }

    public static HeapSort getHeapSort() {
        return heapSort;
    }

    public static InsertionSort getInsertionSort() {
        return insertionSort;
    }

    public static MergeSort getMergeSort() {
        return mergeSort;
    }

    public static QuickSort getQuickSort() {
        return quickSort;
    }

    public static RadixSort getRadixSort() {
        return radixSort;
    }

    public static SelectionSort getSelectionSort() {
        return selectionSort;
    }

    public static ShellSort getShellSort() {
        return shellSort;
    }

    public static BinarySearch getBinarySearch() {
        return binarySearch;
    }

    public static SequentialSearch getSequentialSearch() {
        return sequentialSearch;
    }

    public static Sort[] getSorts() {
        return sorts;
    }

    public static Search[] getSearches() {
        return searches;
    }

    public static String[] getSortNames() {
        return sortNames;
    }

    public static String[] getSearchNames() {
        return searchNames;
    }
}
