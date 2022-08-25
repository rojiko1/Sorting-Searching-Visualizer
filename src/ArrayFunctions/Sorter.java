package ArrayFunctions;

import Main.Settings;
import UI.UserInterface;

public class Sorter implements Runnable {

    private final Control control;
    private final UserInterface userInterface;

    public Sorter(Control control, UserInterface userInterface) {
        this.control = control;
        this.userInterface = userInterface;
    }

    public void run() {
        userInterface.setAllElementsEnabled(false);
        try {
            Settings.getSort().sort(control.getArray(), userInterface.getPointer1(), userInterface.getPointer2());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        userInterface.setAllElementsEnabled(true);
    }

}
