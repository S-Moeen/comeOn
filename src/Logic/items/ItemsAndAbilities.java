package Logic.items;

import Logic.MyMap;

import java.util.ArrayList;

/**
 * Created by moeen on 5/1/16.
 */
//
public abstract class ItemsAndAbilities {
    final protected String name;
    final protected String description;
    protected Instruction instructionsForCaster;
    MyMap map = MyMap.getInstance();
    ItemsAndAbilities(String name, String description, ArrayList<String> instructionsForCaster){
        this.name = name;
        this.instructionsForCaster = new Instruction(instructionsForCaster);
        this.description = description;
    }
}
