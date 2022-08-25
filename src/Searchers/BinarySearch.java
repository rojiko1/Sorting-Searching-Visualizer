package Searchers;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

// time complexity: best: O(1); average: O(lg(n)); worst: O(lg(n))
// bubble sort: efficient searching algorithm; only works for presorted arrays

public class BinarySearch extends Search {

    public int search(ArrayList<Element> array, Pointer pointer, int searchItem) throws InterruptedException {
        return searchSection(array, 0, array.size() - 1, pointer, searchItem);
    }

    private int searchSection(ArrayList<Element> array, int first, int last, Pointer pointer, int searchItem) throws InterruptedException {
        if (first <= last) {
            int middle_index = (first + last) / 2;
            pointer.setCurrentIndex(middle_index);
            Thread.sleep(Settings.getSearchTime());
            if (array.get(middle_index).getValue() == searchItem) {
                return middle_index;
            }
            else if (array.get(middle_index).getValue() < searchItem) {
                return searchSection(array, middle_index + 1, last, pointer, searchItem);
            }
            else {
                return searchSection(array, first, middle_index - 1, pointer, searchItem);
            }
        }
        else {return -1;}
    }

    public String getSearchName() {
        return "Binary";
    }

}
