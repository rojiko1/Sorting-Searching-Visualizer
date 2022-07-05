package Sorters;

import java.util.Arrays;

// time complexity: best: O(nlog(n)); average: O(nlog(n)); worst: O(nlog(n)) COME BACK TO THIS; PROBABLY INCORRECT
// merge sort: efficient sorting algorithm; highly scalable

public class MergeSort extends Sort {

    public int[] sort(int[] array) {
        if (array.length > 1) {
            int[] left_half = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] right_half = Arrays.copyOfRange(array, array.length / 2, array.length);

            int[] sorted_left_half = sort(left_half);
            int[] sorted_right_half = sort(right_half);

            array = merge(sorted_left_half, sorted_right_half);
        }
        return array;
    }

    private int[] merge(int[] firstArray, int[] secondArray) {
        int[] merged_array = {};

        while ((firstArray.length > 0) || (secondArray.length > 0)) {
            if (secondArray.length == 0) {
                merged_array = Arrays.copyOf(merged_array, merged_array.length + 1);
                merged_array[merged_array.length - 1] = firstArray[0];
                firstArray = Arrays.copyOfRange(firstArray, 1, firstArray.length);

            }
            else if (firstArray.length == 0) {
                merged_array = Arrays.copyOf(merged_array, merged_array.length + 1);
                merged_array[merged_array.length - 1] = secondArray[0];
                secondArray = Arrays.copyOfRange(secondArray, 1, secondArray.length);
            }
            else if (firstArray[0] < secondArray[0]) {
                merged_array = Arrays.copyOf(merged_array, merged_array.length + 1);
                merged_array[merged_array.length - 1] = firstArray[0];
                firstArray = Arrays.copyOfRange(firstArray, 1, firstArray.length);
            }
            else {
                merged_array = Arrays.copyOf(merged_array, merged_array.length + 1);
                merged_array[merged_array.length - 1] = secondArray[0];
                secondArray = Arrays.copyOfRange(secondArray, 1, secondArray.length);
            }
        }

        return merged_array;
    }

}
