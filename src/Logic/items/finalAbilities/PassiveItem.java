package Logic.items.finalAbilities;

import Logic.items.PassiveItemsAndAbilities;

import java.util.ArrayList;

/**
 * Created by moeen on 5/4/16.
 */
public class PassiveItem extends PassiveItemsAndAbilities{
    int size;
    public PassiveItem(String name, String description, ArrayList<String> instructionsForCaster, int size) {
        super(name, description, instructionsForCaster);
        this.size = size;
    }
}
