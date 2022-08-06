package Searchers;

// time complexity: worst case is O n; average is O (n / 2)
// sequential/linear search: efficient for unstructured/unsorted data; inefficient for structured/sorted data

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

public class SequentialSearch extends Search {

    public int search(ArrayList<Element> array, Pointer pointer, int searchItem) throws InterruptedException {
        pointer.setCurrentIndex(0);
        for (int i = 0; i < array.size(); i++) {
            pointer.incrementCurrentIndex();
            Thread.sleep(Settings.getSearchTime());
            if (array.get(i).getValue() == searchItem) {
                return i;
            }
        }
        return -1;
    }

    public String getSearchName() {
        return "Sequential";
    }

}
