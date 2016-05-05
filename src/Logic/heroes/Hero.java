package Logic.heroes;

import Logic.MyMap;

/**
 * Created by moeen on 5/1/16.
 */
public class Hero {
    private MyMap map = MyMap.getInstance();
    private int attributes [] = new int [MyMap.mapSize()];
    public Hero(int[] attributes) {
        //TODO throw exception if sizeof this.attributes and attributes doesnt match
        this.attributes = attributes;
    }
    public int getAttribute(String attributeName){
        int index = map.getIntValue(attributeName);
        return attributes[index];
    }

    public void  setAttribute(String attributeName, int value){
        int index = map.getIntValue(attributeName);
        attributes[index] = value;
    }
}