package ArrayFunctions;

import java.util.ArrayList;

public class Swapper<Item> {

    public void swap(ArrayList<Item> array, int firstIndex, int secondIndex) {
        Item first = array.get(firstIndex);
        array.set(firstIndex, array.get(secondIndex));
        array.set(secondIndex, first);
    }

}
