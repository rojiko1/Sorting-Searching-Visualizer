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
    public static final int array_size = 80;
    private final UserInterface userInterface;
    private final Shuffler shuffler = new Shuffler();
    private final Sorter sorter;
    private final Searcher searcher;

    public Control() throws InterruptedException {
        generateArray(array_size);
        sortNames = new String[sorts.length];
        for (int i = 0; i < sorts.length; i++) {
            sortNames[i] = sorts[i].getSortName();
        }
        searchNames = new String[searches.length];
        for (int i = 0; i < searches.length; i++) {
            searchNames[i] = searches[i].getSearchName();
        }
        userInterface = new UserInterface(new Display(), this);
        sorter = new Sorter(this, userInterface);
        searcher = new Searcher(this, userInterface);
        Settings.setSort(radixSort);
        sort();
    }

    public void generateArray(int len) {
        array = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            array.add(new Element(random.nextInt(99) + 1, i));
        }
        // sorted = false;
    }

    public void shuffleArray() {
        shuffler.shuffle(array);
    }

    public void sort() throws InterruptedException {
        Thread thread = new Thread(sorter);
        thread.start();
    }

    public void search(int searchItem) throws InterruptedException {
        searcher.setSearchItem(searchItem);
        Thread thread = new Thread(searcher);
        thread.start();
    }

    public ArrayList<Element> getArray() {
        return array;
    }

    public static Sort getDefaultSort() {
        return selectionSort;
    }

    public static Search getDefaultSearch() {
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
