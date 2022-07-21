package Main;

import UI.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        SortControl sortControl = new SortControl();
        SearchControl searchControl = new SearchControl();

        int[] intArray = {3, 4, 1, 7, 2, 9, 4, 0, 1, 8};

        // initialize arraylist of elements
        ArrayList<Element> array = new ArrayList<Element>();
        for (int i = 0; i < intArray.length; i++) {
            array.add(new Element(intArray[i], i));
        }

        ArrayList<Element> sorted_array = sortControl.executeOptimalSort(array);
        System.out.println(searchControl.executeOptimalSearch(array, 7, false));
        System.out.println(searchControl.executeOptimalSearch(sorted_array, 7, true));
    }

}
