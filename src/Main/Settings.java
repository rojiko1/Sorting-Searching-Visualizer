package Main;

import Searchers.Search;
import Sorters.Sort;

public class Settings {

    private static String speed;
    private static String mode;
    private static Sort sort;
    private static Search search;

    public Settings(String speed, String mode, Sort sort, Search search) {
        setSpeed(speed);
        setMode(mode);
        setSort(sort);
        setSearch(search);
    }

    public void setSpeed(String choice) {speed = choice;}

    public void setMode(String choice) {mode = choice;}

    public void setSort(Sort choice) {sort = choice;}

    public void setSearch(Search choice) {search = choice;}

}
