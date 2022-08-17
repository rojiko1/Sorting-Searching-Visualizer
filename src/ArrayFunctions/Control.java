package ArrayFunctions;

import Main.Settings;
import Searchers.BinarySearch;
import Searchers.Search;
import Searchers.SequentialSearch;
import Sorters.*;
import UI.Display;
import UI.UserInterface;

import java.util.ArrayList;
import java.util.Random;

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

    private final Random random = new Random();
    private ArrayList<Element> array;
    private Display display;
    private UserInterface userInterface;

    public Control() throws InterruptedException {
        sortNames = new String[sorts.length];
        for (int i = 0; i < sorts.length; i++) {
            sortNames[i] = sorts[i].getSortName();
        }
        searchNames = new String[searches.length];
        for (int i = 0; i < searches.length; i++) {
            searchNames[i] = searches[i].getSearchName();
        }
        generateArray(20);
        display = new Display();
        userInterface = new UserInterface(display, array, this);

        ArrayList<Element> sorted_array = Control.getQuickSort().sort(array, userInterface.getPointer1(), userInterface.getPointer2());
        System.out.println(search(7));
    }

    public void generateArray(int len) {
        array = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            array.add(new Element(random.nextInt(30) + 1, i));
        }
        // sorted = false;
    }

    public ArrayList<Element> sort() throws InterruptedException {
        ArrayList<Element> sorted_array;
        userInterface.setAllElementsEnabled(false);
        sorted_array = Settings.getSort().sort(array, userInterface.getPointer1(), userInterface.getPointer2());
        userInterface.setAllElementsEnabled(true);
        return sorted_array;
    }

    public int search(int searchItem) throws InterruptedException {
        int index;
        if (Settings.getSearch() instanceof BinarySearch) {
            //check that array is presorted
        }
        userInterface.setAllElementsEnabled(false);
        index = Settings.getSearch().search(array, userInterface.getPointer1(), searchItem);
        userInterface.setAllElementsEnabled(true);
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
