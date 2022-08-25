package Sorters;

import ArrayFunctions.Pointer;
import ArrayFunctions.Element;
import Main.Settings;

import java.util.ArrayList;

public class RadixSort extends Sort {

    public void sort(ArrayList<Element> array, Pointer pointer1, Pointer pointer2) throws InterruptedException {
        // find max power
        int pow = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getValue() >= Math.pow(10, pow + 1)) {
                pow++;
                i--;
            }
        }
        sortPower(array, 0, array.size() - 1, pow, pointer1);
    }

    private void sortPower(ArrayList<Element> array, int first, int last, int power, Pointer pointer) throws InterruptedException {
        if ((power >= 0) && (last > first)) {
            pointer.setCurrentIndex(first);
            int[] indexes = new int[10];
            ArrayList<Element> unsorted = new ArrayList<>(array.subList(first, last + 1));
            for (Element element : unsorted) {
                indexes[(int) (element.getValue() / Math.pow(10, power)) % 10]++;
                pointer.incrementCurrentIndex();
                Thread.sleep(Settings.getSortTime());
            }
            for (int i = 1; i < 10; i++) {
                indexes[i] += indexes[i - 1];
            }
            for (int j = unsorted.size() - 1; j >= 0; j--) {
                int digit = (int) (unsorted.get(j).getValue() / Math.pow(10, power)) % 10;
                unsorted.get(j).setIndex(first + indexes[digit] - 1);
                array.set(first + indexes[digit] - 1, unsorted.get(j));
                pointer.setCurrentIndex(first + indexes[digit] - 1);
                Thread.sleep(Settings.getSortTime());
                indexes[digit]--;
            }
            for (int k = 0; k < 9; k++) {
                sortPower(array, first + indexes[k], indexes[k + 1] - 1, power - 1, pointer);
            }
            sortPower(array, indexes[9], last, power - 1, pointer);
        }
    }

    public String getSortName() {
        return "Radix";
    }

}
