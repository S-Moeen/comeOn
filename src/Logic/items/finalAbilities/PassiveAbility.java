package Logic.items.finalAbilities;

import Logic.items.PassiveItemsAndAbilities;

import java.util.ArrayList;

/**
 * Created by moeen on 5/4/16.
 */
public class PassiveAbility extends PassiveItemsAndAbilities implements Ability{
    int level;
    ArrayList<ArrayList<String>> casterUpgradeData;
    public PassiveAbility(String name, String description, ArrayList<String> instructionsForCaster , int level,ArrayList<ArrayList<String >> casterUpgradeData) {
        super(name, description, instructionsForCaster);
        this.level = level;
        this.casterUpgradeData= casterUpgradeData;
    }
    @Override
    public boolean upgrade() {
        if(level >= casterUpgradeData.size()){
            return false;
        }
        instructionsForCaster = casterUpgradeData.get(level);
        level++;
        return true;
    }
}
