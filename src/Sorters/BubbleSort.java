package Sorters;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2)
// space complexity: O(1)
// bubble sort: inefficient sorting algorithm; highly unscalable

public class BubbleSort extends Sort {

    public void sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        for (int i = array.size(); i > 0; i--) {
            pointer1.setCurrentIndex(0);
            for (int j = 0; j < (i - 1); j++) {
                pointer1.incrementCurrentIndex();
                if (array.get(j).getValue() > array.get(j + 1).getValue()) {
                    swap(array, j, j + 1);
                    Thread.sleep(Settings.getSortTime());
                }
            }
        }
    }

    public ArrayList<Element> recursiveSort(ArrayList<Element> array, int currentDepth) {
        if (currentDepth != array.size()) {
            array = recursiveSort(array, currentDepth + 1);
        }
        for (int i = 0; i < (currentDepth - 1); i++) {
            if (array.get(i).getValue() > array.get(i + 1).getValue()) {
                swap(array, i, i + 1);
            }
        }
        return array;
    }

    public String getSortName() {
        return "Bubble";
    }

}