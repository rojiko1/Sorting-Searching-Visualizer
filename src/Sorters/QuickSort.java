package Sorters;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.awt.*;
import java.util.ArrayList;

public class QuickSort extends Sort {

    public ArrayList<Element> sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        pointer2.setVisible(true);
        sortSection(array, pointer1, pointer2, 0, array.size() - 1);
        pointer2.setVisible(false);
        return array;
    }

    /*private void sortSection(ArrayList<Element> array, Pointer pointer1, Pointer pointer2, int first, int last) throws InterruptedException {
        if (first >= last) {
            return;
        }
        else {
            int i = first + 1;
            int j = last;
            pointer1.setCurrentIndex(i);
            pointer2.setCurrentIndex(j);
            while ((j - 1) > i) {
                while ((array.get(i).getValue() < array.get(first).getValue()) && (i < (j - 1))) {
                    i++;
                    pointer1.incrementCurrentIndex();
                    Thread.sleep(Settings.getSortTime());
                }
                while ((array.get(j).getValue() > array.get(first).getValue()) && ((j - 1) > i)) {
                    j--;
                    pointer2.setCurrentIndex(j);
                    Thread.sleep(Settings.getSortTime());
                }
                if (array.get(i).getValue() > array.get(j).getValue()) {
                    swap(array, i, j);
                    Thread.sleep(Settings.getSortTime());
                }
            }
            if (array.get(i).getValue() > array.get(j).getValue()) {
                swap(array, i, j);
                Thread.sleep(Settings.getSortTime());
            }
            if (array.get(first).getValue() <= array.get(i).getValue()) {
                sortSection(array, pointer1, pointer2, first, i - 1);
                sortSection(array, pointer1, pointer2, i, last);
            }
            else if (array.get(first).getValue() > array.get(j).getValue()) {
                swap(array, first, j);
                Thread.sleep(Settings.getSortTime());
                sortSection(array, pointer1, pointer2, first, i);
                sortSection(array, pointer1, pointer2, j + 1, last);
            }
            else {
                swap(array, first, i);
                Thread.sleep(Settings.getSortTime());
                sortSection(array, pointer1, pointer2, first, i - 1);
                sortSection(array, pointer1, pointer2, j, last);
            }
        }
    }*/

    private void sortSection(ArrayList<Element> array, Pointer pointer1, Pointer pointer2, int first, int last) throws InterruptedException {
        if (first >= last) {
            return;
        }
        else {
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
