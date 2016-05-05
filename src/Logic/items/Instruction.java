package Logic.items;

import Logic.MyMap;

import java.util.ArrayList;

/**
 * Created by moeen on 5/1/16.
 */
public class Instruction {
    private String instructions [] = new String [MyMap.mapSize()];
    private MyMap<String,Integer> map = MyMap.getInstance();
    //array must have MyMap.mapSize() members
    Instruction(ArrayList<String> instructions){
        //TODO throw exeption if the array is shorter than MyMap.mapSize()
        this.instructions =  instructions.toArray(this.instructions);
    }
    public String[] getInstructions() {
        return instructions;
    }
    public String get(String attribute){
        int index = map.getIntValue(attribute);
        return instructions[index];
    }
    public String get(int index){
        return instructions[index];
    }
}