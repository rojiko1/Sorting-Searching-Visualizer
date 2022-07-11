package Sorters;

// time complexity: best: O(n); average: O(n^2); worst: O(n^2)
// sort name: inefficient sorting algorithm; highly unscalable

import UI.Element;

import java.util.ArrayList;

public class InsertionSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array) {
        ArrayList<Element> new_array = new ArrayList<Element>(array);
        for (int i = 1; i < new_array.size(); i++) {
            // insert into correct position
            int itemIndex = i;
            while (itemIndex > 0) {
                if (new_array.get(itemIndex).getValue() < new_array.get(itemIndex - 1).getValue()) {
                    new_array = swap(new_array, itemIndex - 1, itemIndex);
                    itemIndex--;
                }
                else {
                    break;
                }
            }
        }
        return new_array;
    }

    public String getSortName() {
        return "Insertion Sort";
    }

}
