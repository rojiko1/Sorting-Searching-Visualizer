package Sorters;

import UI.Element;

import java.util.ArrayList;

// time complexity: best: O(n^2); average: O(n^2); worst: O(n^2) COME BACK TO THIS; PROBABLY INCORRECT
// shell sort: efficient sorting algorithm for partially sorted inputs

public class ShellSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array) {
        ArrayList<Element> new_array = new ArrayList<Element>(array);
        int blockSize = ((new_array.size() / 9) * 3) + 1;
        for (int j = blockSize; j > 0; j -= 3) {
            // performing insertion sort w/ greater shifts of elements (shift size decreases on 3x + 1)
            for (int i = j; i < new_array.size(); i++) {
                // insert into correct position
                int itemIndex = i;
                while (itemIndex > j - 1) {
                    if (new_array.get(itemIndex).getValue() < new_array.get(itemIndex - j).getValue()) {
                        swapper.swap(new_array, itemIndex - j, itemIndex);
                        itemIndex -= j;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        updateIndices(new_array);
        return new_array;
    }

    public String getSortName() {
        return "Shell Sort";
    }

}
