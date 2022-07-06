package Searchers;

// time complexity: worst case is O n; average is O (n / 2)
// sequential/linear search: efficient for unstructured/unsorted data; inefficient for structured/sorted data

import UI.Element;

import java.util.ArrayList;

public class SequentialSearch extends Search {

    public int search(ArrayList<Element> array, int searchItem) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getValue() == searchItem) {
                return i;
            }
        }
        return -1;
    }

}
