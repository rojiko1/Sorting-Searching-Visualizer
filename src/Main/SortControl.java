package Main;

import Sorters.BubbleSort;

public class SortControl {

    private static BubbleSort bubbleSort = new BubbleSort();

    public int[] executeOptimalSort(int[] array) {
        String optimal_sort = findOptimalSort(array.length);
        int[] sorted_array = bubbleSort.sort(array);
        return sorted_array;
    }

    public String findOptimalSort(int arrayLength) {
        return String.valueOf(arrayLength);
    }

}
