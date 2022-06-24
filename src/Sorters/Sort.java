package Sorters;

public abstract class Sort {

    protected static final int fastMilliseconds = 2;
    protected static final int slowMilliseconds = 5;

    public abstract int[] sort(int[] array);

}
