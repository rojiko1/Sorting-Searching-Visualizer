package Searchers;

// time complexity: worst case is O n; average is O (n / 2)
// sequential/linear search: efficient for unstructured/unsorted data; inefficient for structured/sorted data

public class SequentialSearch extends Search {

    public int search(int[] array, int searchItem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchItem) {
                return i;
            }
        }
        return -1;
    }

}
