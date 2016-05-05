package Logic.items;

import Logic.AttackWrapperClass;
import Logic.BiAttackWrapperClass;
import Logic.MyMap;
import Logic.heroes.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by moeen on 5/1/16.
 */
public class ActiveItemsAndAbilities extends ItemsAndAbilities {
    protected Instruction instructionsForTarget;
    protected ActiveItemsAndAbilities(String name, String description, ArrayList<String> instructionsForCaster, ArrayList<String> instructionsForTarget){
        super(name, description, instructionsForCaster);
        this.instructionsForTarget = new Instruction(instructionsForTarget);
    }
    public BiAttackWrapperClass use(Hero caster , Hero target){
        BiAttackWrapperClass allEffects =  new BiAttackWrapperClass();
        useOnSomeOne(caster, target, instructionsForTarget, allEffects.getEffectsOnTarget());
        useOnSomeOne(caster, target, instructionsForCaster, allEffects.getEffectsOnCaster());
        return  allEffects;
    }
    private AttackWrapperClass useOnSomeOne(Hero caster , Hero target, Instruction howTo, AttackWrapperClass effects){
        int howMuch;
        for (int i = 0; i < MyMap.mapSize(); i++) {
            howMuch = 0;
            String temp1 = howTo.get(i);
            String temp2 [] = temp1.split(",");
            ArrayList<String> recepies = new ArrayList<String>(Arrays.asList(temp2));
            for (int j = 0; j < MyMap.mapSize(); j++) {
                howMuch += process(recepies.get(j), caster, target);
            }
            effects.setEffect(i, howMuch);
        }
        return effects;
    }
    //TODO make expression reader understand mathmathical priorities
    //Todo clean this rubbish
    private int process(String recepie, Hero caster, Hero target) {
        String particles[] = recepie.split("_");
        int probability = Integer.parseInt(particles[0]);
        String expression = particles[1];
        particles = expression.split("[+-/*]");
        String coefficents = expression.replaceAll("[^+-/*]", "");
        ArrayList<String> orders = new ArrayList<String>(Arrays.asList(particles));
        int numbers [] = new int [orders.size()];
        int i = 0;
        for (String order : orders ) {
            String subOrders [] = order.split("&");
            Hero said = null;
            int coefficent;
            if(subOrders[0].contains("|")){
                String stringIntegers[] = subOrders[0].split("|");
                int first = Integer.parseInt(stringIntegers[0]);
                int second = Integer.parseInt(stringIntegers[1]);
                Random temp = new Random();
                coefficent =temp.nextInt(second - first +1) + first;
            }
            else {
                coefficent = Integer.parseInt(subOrders[0]);
            }
            //TODO throw exeption if said is non of target caster or one
            if ( subOrders[1].equals("target") ){
                said = target;
            }
            if ( subOrders[1].equals("caster") ){
                said = caster;
            }
            if(subOrders[1].equals("one")){
                numbers[i++] = coefficent;
            }
            else {
                numbers[i++] = coefficent * said.getAttribute(subOrders[2]);
            }
        }
        int returnValue = numbers[0];
        for (int j = 0; j < coefficents.length(); j++) {
            switch (coefficents.charAt(j)){
                case '+':
                    returnValue = returnValue + numbers[j+1];
                    break;
                case '-':
                    returnValue = returnValue - numbers[j+1];
                    break;
                case '*':
                    returnValue = returnValue * numbers[j+1];
                    break;
                case '/':
                    returnValue = returnValue / numbers[j+1];
                    break;
            }
        }
        int chance = (int)(100*Math.random() + 1);
        if (chance <= probability){
            return returnValue;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> attrib = new ArrayList<String>();
        ArrayList<String> instruct1 = new ArrayList<String>();
        ArrayList<String> instruct2 = new ArrayList<String>();
        instruct1.add("100_5&target&hp+4&caster&hp,0_1&target&hp/1&caster&hp");
        instruct2.add("100_5&target&hp+4&caster&hp,50_1&target&hp/1&caster&hp");
        attrib.add("hp");
        ActiveItemsAndAbilities item = new ActiveItemsAndAbilities("magic", "My own Item", instruct1, instruct2);
        Hero caster = new Hero(new int[] {2});
        Hero target = new Hero(new int[] {3});
        BiAttackWrapperClass temp = item.use(caster,target);
        int b;

    }
}
