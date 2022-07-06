package Searchers;

import UI.Element;

import java.util.ArrayList;

public abstract class Search {

    protected static final int fastMilliseconds = 4;
    protected static final int slowMilliseconds = 10;

    public abstract int search(ArrayList<Element> array, int searchItem);

}
