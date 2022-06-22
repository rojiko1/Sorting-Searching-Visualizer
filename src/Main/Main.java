package Main;

import Sorters.BubbleSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BubbleSort bbs = new BubbleSort();
        int[] array = {3, 4, 1, 7, 2, 9, 4, 0, 1, 8};

        long start = System.nanoTime();
        int[] sortedArray = bbs.sort(array);
        long end = System.nanoTime();
        System.out.println(end - start);

        start = System.nanoTime();
        int[] recursivelySortedArray = bbs.recursiveSort(array, 1);
        end = System.nanoTime();
        System.out.println(end - start);

        System.out.println(Arrays.toString(sortedArray));
        System.out.println(Arrays.toString(recursivelySortedArray));
    }

}
