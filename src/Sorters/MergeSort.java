package Sorters;

import UI.Element;

import java.util.ArrayList;
import java.util.Arrays;

// time complexity: best: O(nlog(n)); average: O(nlog(n)); worst: O(nlog(n)) COME BACK TO THIS; PROBABLY INCORRECT
// merge sort: efficient sorting algorithm; highly scalable

public class MergeSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array) {
        if (array.size() > 1) {
            ArrayList<Element> left_half = new ArrayList<Element>(array.subList(0, array.size() / 2));
            ArrayList<Element> right_half = new ArrayList<Element>(array.subList(array.size() / 2, array.size()));

            ArrayList<Element> sorted_left_half = sort(left_half);
            ArrayList<Element> sorted_right_half = sort(right_half);

            array = merge(sorted_left_half, sorted_right_half);
        }
        array = updateIndices(array);
        return array;
    }

    private ArrayList<Element> merge(ArrayList<Element> firstArray, ArrayList<Element> secondArray) {
        ArrayList<Element> merged_array = new ArrayList<>();

        while ((firstArray.size() > 0) || (secondArray.size() > 0)) {
            if (secondArray.size() == 0) {
                merged_array.add(firstArray.get(0));
                firstArray.remove(0);

            }
            else if (firstArray.size() == 0) {
                merged_array.add(secondArray.get(0));
                secondArray.remove(0);
            }
            else if (firstArray.get(0).getValue() < secondArray.get(0).getValue()) {
                merged_array.add(firstArray.get(0));
                firstArray.remove(0);
            }
            else {
                merged_array.add(secondArray.get(0));
                secondArray.remove(0);
            }
        }
        return merged_array;
    }

}
