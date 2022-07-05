package Main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // UI ui = new UI();
        SortControl sortControl = new SortControl();
        SearchControl searchControl = new SearchControl();

        int[] array = {3, 4, 1, 7, 2, 9, 4, 0, 1, 8};
        int[] sorted_array = sortControl.executeOptimalSort(array);

        System.out.println(Arrays.toString(sorted_array));
        System.out.println(searchControl.executeOptimalSearch(array, 7, false));
        System.out.println(searchControl.executeOptimalSearch(sorted_array, 7, true));
    }

}
