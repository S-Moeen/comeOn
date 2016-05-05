package Logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by moeen on 5/2/16.
 */
public class MyMap<T, T1> extends HashMap{
    private static MyMap<String,Integer> map = new MyMap<String,Integer>();
    private static ArrayList<String> attributes;
    private MyMap(){
        attributes = new ArrayList<String>();
        attributes.addAll(Arrays.asList(new String[]{"magic" , "ep", "hp", "attackPower", "maxMagic", "maxEp", "maxHp", "maxAttackPower", "cooldown", "duration"}));
        for (int i = 0; i < attributes.size(); i++) {
            this.put(attributes.get(i), new Integer(i));
        }
    }
    public static MyMap getInstance() {
        return map;
    }
    public static int mapSize(){
        return attributes.size();
    }
    public int getIntValue(String key){
        Integer i = (Integer) super.get(key);
        return i.intValue();
    }
}