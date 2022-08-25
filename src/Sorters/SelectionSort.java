package Sorters;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2)
// space complexity: O(1)
// selection sort: inefficient sorting algorithm; highly unscalable

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

public class SelectionSort extends Sort {

    public void sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        pointer1.setCurrentIndex(-1);
        pointer2.setVisible(true);
        for (int i = 0; i < array.size() - 1; i++) {
            pointer1.incrementCurrentIndex();
            // select smallest element in unsorted part of array
            int minVal = array.get(i).getValue();
            int minIndex = i;
            for (int j = i + 1; j < array.size(); j++) {
                pointer2.setCurrentIndex(j);
                Thread.sleep(Settings.getSortTime());
                if (array.get(j).getValue() < minVal) {
                    minVal = array.get(j).getValue();
                    minIndex = j;
                }
            }
            pointer2.setCurrentIndex(minIndex);
            Thread.sleep(Settings.getSortTime());
            swap(array, i, minIndex);
        }
        pointer2.setVisible(false);
    }

    public String getSortName() {
        return "Selection";
    }

}
