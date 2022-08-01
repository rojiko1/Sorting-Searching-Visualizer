package ArrayFunctions;

import ArrayFunctions.Swapper;

import java.util.ArrayList;
import java.util.Random;

public class Shuffler<Item> {

    private static final Swapper swapper = new Swapper();
    private static final Random random = new Random();

    public void shuffle(ArrayList<Item> array) {
        for (int i = 0; i < array.size(); i++) {
            int random_index = random.nextInt(i + 1);
            swapper.swap(array, i, random_index);
        }
    }

}
