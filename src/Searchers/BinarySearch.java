package Searchers;

import UI.Element;
import java.util.ArrayList;

public class BinarySearch extends Search {

    public int search(ArrayList<Element> array, int searchItem) {
        if (array.size() > 0) {
            int middle_index = array.size() / 2;
            int returned_index;
            if (array.get(middle_index).getValue() == searchItem) {
                return middle_index;
            }
            else if (array.get(middle_index).getValue() < searchItem) {
                if (middle_index + 1 != array.size()) {
                    returned_index = search(new ArrayList<Element>(array.subList(middle_index + 1, array.size())), searchItem);
                    if (returned_index != -1) {
                        return middle_index + returned_index + 1;
                    }
                    else {return -1;}
                }
                else {return -1;}
            }
            else {
                returned_index = search(new ArrayList<Element>(array.subList(0, middle_index)), searchItem);
                return returned_index;
            }
        }
        else {return -1;}
    }

}
