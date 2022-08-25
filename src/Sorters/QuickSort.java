package Sorters;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

// time complexity: best: O(lg(n)); average: O(nlg(n)); worst: O(n^2)
// space complexity: O(1)
// quick sort: efficient sorting algorithm; highly scalable

public class QuickSort extends Sort {

    public void sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        pointer2.setVisible(true);
        sortSection(array, pointer1, pointer2, 0, array.size() - 1);
        pointer2.setVisible(false);
    }

    private void sortSection(ArrayList<Element> array, Pointer pointer1, Pointer pointer2, int first, int last) throws InterruptedException {
        if (first < last) {
            int i = first + 1;
            int j = last;
            pointer1.setCurrentIndex(i);
            pointer2.setCurrentIndex(j);
            while (true) {
                while (array.get(i).getValue() <= array.get(first).getValue()) {
                    i++;
                    pointer1.incrementCurrentIndex();
                    Thread.sleep(Settings.getSortTime());
                    if (i > last) {
                        break;
                    }
                }
                while (array.get(j).getValue() >= array.get(first).getValue()) {
                    j--;
                    pointer2.setCurrentIndex(j);
                    Thread.sleep(Settings.getSortTime());
                    if (j < (first + 1)) {
                        break;
                    }
                }
                if (j <= i) {
                    break;
                }
                swap(array, i, j);
            }
            swap(array, first, j);
            sortSection(array, pointer1, pointer2, first, j - 1);
            sortSection(array, pointer1, pointer2, j + 1, last);
        }
    }

    public String getSortName() {
        return "Quick";
    }

}
