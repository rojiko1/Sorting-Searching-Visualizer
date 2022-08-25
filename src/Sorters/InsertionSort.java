package Sorters;

// time complexity: best: O(n); average: O(n^2); worst: O(n^2)
// space complexity: O(1)
// sort name: inefficient sorting algorithm; highly unscalable

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

public class InsertionSort extends Sort {

    public void sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        pointer1.setCurrentIndex(0);
        pointer2.setVisible(true);
        for (int i = 1; i < array.size(); i++) {
            pointer1.incrementCurrentIndex();
            // insert into correct position
            int itemIndex = i;
            while (itemIndex > 0) {
                pointer2.setCurrentIndex(itemIndex);
                if (array.get(itemIndex).getValue() < array.get(itemIndex - 1).getValue()) {
                    swap(array, itemIndex - 1, itemIndex);
                    itemIndex--;
                    Thread.sleep(Settings.getSortTime());
                }
                else {
                    break;
                }
            }
        }
        pointer2.setVisible(false);
    }

    public String getSortName() {
        return "Insertion";
    }

}
