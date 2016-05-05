package Logic.items.finalAbilities;

import Logic.items.ActiveItemsAndAbilities;

import java.util.ArrayList;

/**
 * Created by moeen on 5/4/16.
 */
public class ActiveItem extends ActiveItemsAndAbilities{
    int size;

    public ActiveItem(String name, String description, ArrayList<String> instructionsForCaster, ArrayList<String> instructionsForTarget, int size) {
        super(name, description, instructionsForCaster, instructionsForTarget);
        this.size = size;
    }
}
