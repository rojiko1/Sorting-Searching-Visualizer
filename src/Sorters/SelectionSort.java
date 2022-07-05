package Sorters;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2)
// sort name: inefficient sorting algorithm; highly unscalable

public class SelectionSort extends Sort {

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // select smallest element in unsorted part of array
            int minVal = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minVal) {
                    minVal = array[j];
                    minIndex = j;
                }
            }
            array = swap(array, i, minIndex);
        }
        return array;
    }

}
