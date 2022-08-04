package Main;

import ArrayFunctions.Control;
import ArrayFunctions.Element;
import ArrayFunctions.Pointer;
import Searchers.BinarySearch;
import Searchers.SequentialSearch;
import Sorters.*;
import UI.*;
import java.util.ArrayList;
import java.util.Random;

public class Simulator {

    private Control control;
    private Settings settings;
    private Display display;
    private UserInterface userInterface;
    private ArrayList<Element> array;
    private boolean sorted;
    private Pointer pointer;
    private Random random = new Random();

    private static BubbleSort bubbleSort = new BubbleSort();
    private static HeapSort heapSort = new HeapSort();
    private static InsertionSort insertionSort = new InsertionSort();
    private static MergeSort mergeSort = new MergeSort();
    private static QuickSort quickSort = new QuickSort();
    private static RadixSort radixSort = new RadixSort();
    private static SelectionSort selectionSort = new SelectionSort();
    private static ShellSort shellSort = new ShellSort();
    private static Sort[] sorts = {bubbleSort, heapSort, insertionSort, mergeSort, quickSort, radixSort, selectionSort, shellSort};

    private static BinarySearch binarySearch = new BinarySearch();
    private static SequentialSearch sequentialSearch = new SequentialSearch();

    public Simulator() throws InterruptedException {
        generateArray(25);
        pointer = new Pointer(0);
        settings = new Settings(true, true, selectionSort, sequentialSearch);
        display = new Display();
        userInterface = new UserInterface(display, array, pointer, settings);
        control = new Control(pointer, settings.getSort(), settings.getSearch());

        ArrayList<Element> sorted_array = control.sort(array);
        System.out.println(control.search(array, 7));
    }

    public void generateArray(int len) {
        array = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            array.add(new Element(random.nextInt(30) + 1, i));
        }
        sorted = false;
    }

}
