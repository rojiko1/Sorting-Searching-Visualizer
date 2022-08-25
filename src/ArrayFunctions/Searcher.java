package ArrayFunctions;

import Main.Settings;
import Searchers.BinarySearch;
import UI.UserInterface;

public class Searcher implements Runnable {

    private final Control control;
    private final UserInterface userInterface;
    private int searchItem;

    public Searcher(Control control, UserInterface userInterface) {
        this.control = control;
        this.userInterface = userInterface;
    }

    public void setSearchItem(int searchItem) {
        this.searchItem = searchItem;
    }

    public void run() {
        int index;
        if (Settings.getSearch() instanceof BinarySearch) {
            //check that array is presorted
        }
        userInterface.setAllElementsEnabled(false);
        try {
            index = Settings.getSearch().search(control.getArray(), userInterface.getPointer1(), searchItem);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        userInterface.setAllElementsEnabled(true);
        if (index == -1) {System.out.println("Search item not found.");}
        else {System.out.println("Search item found at index " + index + ".");}
    }

}
