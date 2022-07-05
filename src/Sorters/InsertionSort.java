package Sorters;

// time complexity: best: O(n); average: O(n^2); worst: O(n^2)
// sort name: inefficient sorting algorithm; highly unscalable

public class InsertionSort extends Sort {

    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // insert into correct position
            int itemIndex = i;
            while (itemIndex > 0) {
                if (array[itemIndex] < array[itemIndex - 1]) {
                    array = swap(array, itemIndex - 1, itemIndex);
                    itemIndex--;
                }
                else {
                    break;
                }
            }
        }
        return array;
    }

}
