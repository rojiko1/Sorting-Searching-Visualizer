package Sorters;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2)
// sort name: inefficient sorting algorithm; highly unscalable

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;

import java.util.ArrayList;

public class SelectionSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array, Pointer pointer) throws InterruptedException {
        for (int i = 0; i < array.size() - 1; i++) {
            // select smallest element in unsorted part of array
            int minVal = array.get(i).getValue();
            int minIndex = i;
            for (int j = i + 1; j < array.size(); j++) {
                pointer.setCurrentIndex(j);
                Thread.sleep(speed);
                if (array.get(j).getValue() < minVal) {
                    minVal = array.get(j).getValue();
                    minIndex = j;
                }
            }
            pointer.setCurrentIndex(minIndex);
            Thread.sleep(speed);
            pointer.setCurrentIndex(i);
            Thread.sleep(speed);
            swap(array, i, minIndex);
        }
        return array;
    }

    public String getSortName() {
        return "Selection Sort";
    }

}
