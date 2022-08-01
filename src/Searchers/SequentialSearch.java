package Searchers;

// time complexity: worst case is O n; average is O (n / 2)
// sequential/linear search: efficient for unstructured/unsorted data; inefficient for structured/sorted data

import ArrayFunctions.Pointer;
import UI.Element;

import java.util.ArrayList;

public class SequentialSearch extends Search {

    public int search(ArrayList<Element> array, Pointer pointer, int searchItem) throws InterruptedException {
        pointer.setCurrentIndex(0);
        for (int i = 0; i < array.size(); i++) {
            pointer.incrementCurrentIndex();
            Thread.sleep(speed);
            if (array.get(i).getValue() == searchItem) {
                return i;
            }
        }
        return -1;
    }

    /* public int threaded_search(ArrayList<Element> array, int searchItem, int numThreads) throws Exception {
        if (numThreads < 2) {
            throw new Exception("Minimum number of threads is 2 for use of threaded_search.");
        }
        else if (array.size() < (numThreads * 4)) {
            throw new Exception("Minimum length of array for use of threaded_search is 4 times the number of threads");
        }
        else {
            for (int i = 0; i < numThreads; i++) {
                new Thread.start();
            }
        }
    } */

}
