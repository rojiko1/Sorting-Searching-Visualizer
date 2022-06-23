package Searchers;

public class SequentialSearch {

    public int search(int[] array, int searchItem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchItem) {
                return i;
            }
        }
        return -1;
    }

}
