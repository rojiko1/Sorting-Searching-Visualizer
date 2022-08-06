package Main;

import ArrayFunctions.Control;
import Searchers.Search;
import Sorters.Sort;

public class Settings {

    private static boolean slowSpeed = true;
    private static boolean sortMode = true;
    private static Sort sort = Control.getSelectionSort();
    private static Search search = Control.getSequentialSearch();

    public static boolean isSlowSpeed() {return slowSpeed;}

    public static boolean isSortMode() {return sortMode;}

    public static Sort getSort() {return sort;}

    public static Search getSearch() {return search;}

    public static int getSortTime() {
        if (slowSpeed) {return 300;}
        else {return 100;}
    }

    public static int getSearchTime() {
        if (slowSpeed) {return 700;}
        else {return 300;}
    }

    public static void setSpeed(boolean choice) {slowSpeed = choice;}

    public static void setMode(boolean choice) {sortMode = choice;}

    public static void setSort(Sort choice) {sort = choice;}

    public static void setSearch(Search choice) {search = choice;}

}
