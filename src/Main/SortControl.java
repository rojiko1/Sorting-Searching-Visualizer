package Main;

import Sorters.*;
import UI.Element;

import java.util.ArrayList;

public class SortControl {

    private static BubbleSort bubbleSort = new BubbleSort();
    private static HeapSort heapSort = new HeapSort();
    private static InsertionSort insertionSort = new InsertionSort();
    private static MergeSort mergeSort = new MergeSort();
    private static QuickSort quickSort = new QuickSort();
    private static RadixSort radixSort = new RadixSort();
    private static SelectionSort selectionSort = new SelectionSort();

    public ArrayList<Element> executeOptimalSort(ArrayList<Element> array) {
        String optimal_sort = findOptimalSort(array.size());
        ArrayList<Element> sorted_array = mergeSort.sort(array);
        return sorted_array;
    }

    public String findOptimalSort(int arrayLength) {
        return String.valueOf(arrayLength);
    }

}
