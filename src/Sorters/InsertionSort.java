package Sorters;

// time complexity: best: O(n); average: O(n^2); worst: O(n^2)
// sort name: inefficient sorting algorithm; highly unscalable

import UI.Element;

import java.util.ArrayList;

public class InsertionSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array) {
        for (int i = 1; i < array.size(); i++) {
            // insert into correct position
            int itemIndex = i;
            while (itemIndex > 0) {
                if (array.get(itemIndex).getValue() < array.get(itemIndex - 1).getValue()) {
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
