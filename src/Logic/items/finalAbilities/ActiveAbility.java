package Logic.items.finalAbilities;

import Logic.items.ActiveItemsAndAbilities;

import java.util.ArrayList;

/**
 * Created by moeen on 5/4/16.
 */
public class ActiveAbility extends ActiveItemsAndAbilities implements Ability{
    private int level = 0;
    private ArrayList<ArrayList<String>> casterUpgradeData;
    private ArrayList<ArrayList<String>> targetUpgradeData;
    public ActiveAbility(String name, String description, ArrayList<String> instructionsForCaster, ArrayList<String> instructionsForTarget, int level,ArrayList<ArrayList<String>> casterUpgradeData, ArrayList<ArrayList<String>> targetUpgradeData) {
        super(name, description, instructionsForCaster, instructionsForTarget);
        this.level = level;
        this.casterUpgradeData = casterUpgradeData;
        this.targetUpgradeData = targetUpgradeData;
    }

    @Override
    public boolean upgrade() {
        if(level >= casterUpgradeData.size() && level >= targetUpgradeData.size()){
            return false;
        }
        if(level < casterUpgradeData.size()){
            instructionsForCaster = casterUpgradeData.get(level);
        }
        if( level < targetUpgradeData.size()){
            instructionsForTarget = targetUpgradeData.get(level);
        }
        level++;
        return true;
    }
}
