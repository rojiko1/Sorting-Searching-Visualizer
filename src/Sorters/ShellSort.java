package Sorters;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

// time complexity: best: O(nlog(n)); average: O(nlog(n)); worst: O(n^2)
// space complexity: O(1)
// shell sort: efficient sorting algorithm for partially sorted inputs

public class ShellSort extends Sort {

    public void sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        pointer2.setVisible(true);
        int blockSize = ((array.size() / 9) * 3) + 1;
        for (int j = blockSize; j > 0; j -= 3) {
            // performing insertion sort w/ greater shifts of elements (shift size decreases on 3x + 1)
            pointer1.setCurrentIndex(j - 1);
            for (int i = j; i < array.size(); i++) {
                pointer1.incrementCurrentIndex();
                // insert into correct position
                int itemIndex = i;
                while (itemIndex > j - 1) {
                    pointer2.setCurrentIndex(itemIndex);
                    if (array.get(itemIndex).getValue() < array.get(itemIndex - j).getValue()) {
                        swap(array, itemIndex - j, itemIndex);
                        itemIndex -= j;
                        Thread.sleep(Settings.getSortTime());
                    }
                    else {
                        break;
                    }
                }
            }
        }
        pointer2.setVisible(false);
    }

    public String getSortName() {
        return "Shell";
    }

}
