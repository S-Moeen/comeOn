package Logic;

/**
 * Created by moeen on 5/2/16.
 */
public class AttackWrapperClass {
    private int effects [] = new int [MyMap.mapSize()];
    private MyMap<String,Integer> map = MyMap.getInstance();

    public int[] getEffects(){
        return effects;
    }

    public void setEffects(int[] effects) {
        this.effects = effects;
    }

    public int getEffect(String attribute){
        int index = map.getIntValue(attribute);
        return effects[index];
    }
    public int getEffect(int index){
        return effects[index];
    }
    public int setEffect(int index, int val){
        return effects[index] = val;
    }
    public void setEffect(String attribute, int number){
        int index = map.getIntValue(attribute);
        effects[index] = number;
    }
}
