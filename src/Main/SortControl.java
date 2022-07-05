package Main;

import Sorters.*;

public class SortControl {

    private static BubbleSort bubbleSort = new BubbleSort();
    private static HeapSort heapSort = new HeapSort();
    private static InsertionSort insertionSort = new InsertionSort();
    private static MergeSort mergeSort = new MergeSort();
    private static QuickSort quickSort = new QuickSort();
    private static RadixSort radixSort = new RadixSort();
    private static SelectionSort selectionSort = new SelectionSort();

    public int[] executeOptimalSort(int[] array) {
        String optimal_sort = findOptimalSort(array.length);
        int[] sorted_array = selectionSort.sort(array);
        return sorted_array;
    }

    public String findOptimalSort(int arrayLength) {
        return String.valueOf(arrayLength);
    }

}
