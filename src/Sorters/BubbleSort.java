package Sorters;

import java.util.Arrays;

// time complexity: O n^2
// comments: sort() has significantly faster execution than recursiveSort(), though both finish in less than a millisecond

public class BubbleSort {

    public int[] sort(int[] array) {
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < (i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    // swap elements
                    int first = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = first;
                }
            }
        }
        return array;
    }

    public int[] recursiveSort(int[] array, int currentDepth) {
        int[] mod_array;
        if (currentDepth != array.length) {
            mod_array = recursiveSort(array, currentDepth + 1);
        } else {
            mod_array = array;
        }
        for (int i = 0; i < (mod_array.length - 1); i++) {
            if (mod_array[i] > mod_array[i + 1]) {
                // swap elements
                int first = mod_array[i + 1];
                mod_array[i + 1] = mod_array[i];
                mod_array[i] = first;
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