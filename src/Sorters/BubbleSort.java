package Sorters;

import UI.Element;

import java.util.ArrayList;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2) COME BACK TO THIS; PROBABLY INCORRECT
// bubble sort: inefficient sorting algorithm; highly unscalable

public class BubbleSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array) {
        ArrayList<Element> new_array = new ArrayList<Element>(array);
        for (int i = new_array.size(); i > 0; i--) {
            for (int j = 0; j < (i - 1); j++) {
                if (new_array.get(j).getValue() > new_array.get(j + 1).getValue()) {
                    swapper.swap(new_array, j, j + 1);
                }
            }
        }
        updateIndices(new_array);
        return new_array;
    }

    public ArrayList<Element> recursiveSort(ArrayList<Element> array, int currentDepth) {
        ArrayList<Element> new_array = new ArrayList<Element>(array);
        if (currentDepth != new_array.size()) {
            new_array = recursiveSort(array, currentDepth + 1);
        }
        for (int i = 0; i < (currentDepth - 1); i++) {
            if (new_array.get(i).getValue() > new_array.get(i + 1).getValue()) {
                swapper.swap(new_array, i, i + 1);
            }
        }
        updateIndices(new_array);
        return new_array;
    }

    public String getSortName() {
        return "Bubble Sort";
    }

}