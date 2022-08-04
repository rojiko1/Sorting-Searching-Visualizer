package Sorters;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;

import java.util.ArrayList;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2) COME BACK TO THIS; PROBABLY INCORRECT
// shell sort: efficient sorting algorithm for partially sorted inputs

public class ShellSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array, Pointer pointer) throws InterruptedException {
        int blockSize = ((array.size() / 9) * 3) + 1;
        for (int j = blockSize; j > 0; j -= 3) {
            // performing insertion sort w/ greater shifts of elements (shift size decreases on 3x + 1)
            for (int i = j; i < array.size(); i++) {
                // insert into correct position
                int itemIndex = i;
                while (itemIndex > j - 1) {
                    if (array.get(itemIndex).getValue() < array.get(itemIndex - j).getValue()) {
                        swap(array, itemIndex - j, itemIndex);
                        itemIndex -= j;
                        Thread.sleep(speed);
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return array;
    }

    public String getSortName() {
        return "Shell Sort";
    }

}
