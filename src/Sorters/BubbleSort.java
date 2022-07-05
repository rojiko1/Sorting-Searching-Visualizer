package Sorters;

import java.util.Arrays;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2) COME BACK TO THIS; PROBABLY INCORRECT
// bubble sort: inefficient sorting algorithm; highly unscalable
// sort() has significantly faster execution than recursiveSort(), though both finish in less than a millisecond

public class BubbleSort extends Sort {

    public int[] sort(int[] array) {
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < (i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    array = swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public int[] recursiveSort(int[] array, int currentDepth) { //practice writing recursive functions, not meant to be used
        int[] mod_array;
        if (currentDepth != array.length) {
            mod_array = recursiveSort(array, currentDepth + 1);
        } else {
            mod_array = array;
        }
        for (int i = 0; i < (mod_array.length - 1); i++) {
            if (mod_array[i] > mod_array[i + 1]) {
                mod_array = swap(mod_array, i, i + 1);
            }
        }
        array[mod_array.length - 1] = mod_array[mod_array.length - 1];
        if (currentDepth == 1) {
            return array;
        }
        else {
            return Arrays.copyOf(mod_array, mod_array.length - 1);
        }
    }

}