package Sorters;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2)
// sort name: inefficient sorting algorithm; highly unscalable

import UI.Element;

import java.util.ArrayList;

public class SelectionSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array) {
        ArrayList<Element> new_array = new ArrayList<Element>(array);
        for (int i = 0; i < new_array.size() - 1; i++) {
            // select smallest element in unsorted part of array
            int minVal = new_array.get(i).getValue();
            int minIndex = i;
            for (int j = i + 1; j < new_array.size(); j++) {
                if (new_array.get(j).getValue() < minVal) {
                    minVal = new_array.get(j).getValue();
                    minIndex = j;
                }
            }
            swapper.swap(new_array, i, minIndex);
        }
        updateIndices(new_array);
        return new_array;
    }

    public String getSortName() {
        return "Selection Sort";
    }

}
