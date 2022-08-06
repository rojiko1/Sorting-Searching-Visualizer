package Sorters;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

// time complexity: best: O(lg(n)); average: O(nlg(n)); worst: O(nlg(n))
// merge sort: efficient sorting algorithm; highly scalable if memory not a concern

public class MergeSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array, Pointer pointer) throws InterruptedException {
        if (array.size() > 1) {
            ArrayList<Element> left_half = new ArrayList<>(array.subList(0, array.size() / 2));
            ArrayList<Element> right_half = new ArrayList<>(array.subList(array.size() / 2, array.size()));

            ArrayList<Element> sorted_left_half = sort(left_half, pointer);
            ArrayList<Element> sorted_right_half = sort(right_half, pointer);

            array = merge(sorted_left_half, sorted_right_half);
            updateIndices(array);
        }
        return array;
    }

    private ArrayList<Element> merge(ArrayList<Element> firstArray, ArrayList<Element> secondArray) throws InterruptedException {
        ArrayList<Element> merged_array = new ArrayList<>();
        if (firstArray.get(firstArray.size() - 1).getValue() <= secondArray.get(0).getValue()) {
            merged_array.addAll(firstArray);
            merged_array.addAll(secondArray);
            return merged_array;
        }
        else if (firstArray.get(0).getValue() >= secondArray.get(secondArray.size() - 1).getValue()) {
            merged_array.addAll(secondArray);
            merged_array.addAll(firstArray);
            return merged_array;
        }
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
            Thread.sleep(Settings.getSortTime());
        }
        return merged_array;
    }

    public String getSortName() {
        return "Merge";
    }

}
