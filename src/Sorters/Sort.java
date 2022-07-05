package Sorters;

// time complexity: best: ; average: ; worst:
// sort name: (in)efficient sorting algorithm; highly (un)scalable
// additional comments

public abstract class Sort {

    protected static final int fastMilliseconds = 2;
    protected static final int slowMilliseconds = 5;

    public abstract int[] sort(int[] array);

    protected int[] swap(int[] array, int firstIndex, int secondIndex) {
        int first = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = first;
        return array;
    }

}
