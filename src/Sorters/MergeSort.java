package Sorters;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;
import java.util.List;

// time complexity: best: O(lg(n)); average: O(nlg(n)); worst: O(nlg(n))
// space complexity: O(n)
// merge sort: efficient sorting algorithm; highly scalable if memory not a concern

public class MergeSort extends Sort {

    @Override
    public void sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        pointer2.setVisible(true);
        sortPartition(array, 0, array.size() - 1, pointer1, pointer2);
        pointer2.setVisible(false);
    }

    private void sortPartition(ArrayList<Element> array, int first, int last, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        if (last > first) {
            pointer1.setCurrentIndex(first);
            pointer2.setCurrentIndex(last + 1);
            Thread.sleep(Settings.getSortTime());
            sortPartition(array, first, (first + last) / 2, pointer1, pointer2);
            sortPartition(array, ((first + last) / 2) + 1, last, pointer1, pointer2);

            merge(array, first, ((first + last) / 2) + 1, last, pointer1);
        }
    }

    private void merge(ArrayList<Element> array, int first, int mid, int last, Pointer pointer) throws InterruptedException {
        ArrayList<Element> firstArray = new ArrayList<>(array.subList(first, mid));
        ArrayList<Element> secondArray = new ArrayList<>(array.subList(mid, last + 1));
        int index = first;
        pointer.setCurrentIndex(index);
        if (firstArray.get(firstArray.size() - 1).getValue() <= secondArray.get(0).getValue()) {
            return;
        }
        else if (firstArray.get(0).getValue() >= secondArray.get(secondArray.size() - 1).getValue()) {
            for (Element element : secondArray) {
                array.set(index, element);
                index++;
            }
            for (Element element : firstArray) {
                array.set(index, element);
                index++;
            }
            return;
        }
        while ((firstArray.size() > 0) || (secondArray.size() > 0)) {
            if (secondArray.size() == 0) {
                array.set(index, firstArray.get(0));
                array.get(index).setIndex(index);
                index++;
                firstArray.remove(0);
            }
            else if (firstArray.size() == 0) {
                array.set(index, secondArray.get(0));
                array.get(index).setIndex(index);
                index++;
                secondArray.remove(0);
            }
            else if (firstArray.get(0).getValue() < secondArray.get(0).getValue()) {
                array.set(index, firstArray.get(0));
                array.get(index).setIndex(index);
                index++;
                firstArray.remove(0);
            }
            else {
                array.set(index, secondArray.get(0));
                array.get(index).setIndex(index);
                index++;
                secondArray.remove(0);
            }
            pointer.incrementCurrentIndex();
            Thread.sleep(Settings.getSortTime());
        }
    }

    public String getSortName() {
        return "Merge";
    }

}
