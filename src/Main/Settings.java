package Main;

import Searchers.Search;
import Sorters.Sort;

public class Settings {

    private static boolean slowSpeed;
    private static Boolean sortMode;
    private static Sort sort;
    private static Search search;

    public Settings(boolean slowSpeed, Boolean sortMode, Sort sort, Search search) {
        setSpeed(slowSpeed);
        setMode(sortMode);
        setSort(sort);
        setSearch(search);
    }

    public boolean isSlowSpeed() {return slowSpeed;}

    public boolean isSortMode() {return sortMode;}

    public Sort getSort() {return sort;}

    public Search getSearch() {return search;
    }
    public void setSpeed(boolean choice) {slowSpeed = choice;}

    public void setMode(boolean choice) {sortMode = choice;}

    public void setSort(Sort choice) {sort = choice;}

    public void setSearch(Search choice) {search = choice;}

}
