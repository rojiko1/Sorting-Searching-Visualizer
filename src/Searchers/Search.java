package Searchers;

public abstract class Search {

    protected static final int fastMilliseconds = 4;
    protected static final int slowMilliseconds = 10;

    public abstract int search(int[] array, int searchItem);

}
