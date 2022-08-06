package creature.herbivorous;

import creature.Animal;
import creature.Creature;
import creature.creatureInterface.creatureName;

import java.util.HashMap;

public abstract class Herbivorous extends Animal   {

    @Override
    public void eating(HashMap<creatureName, HashMap<Integer, Creature>> map) {
        System.out.println("рослиноїдний їсть");
    }
    public Double herbivorousEating(HashMap<creatureName, HashMap<Integer, Creature>> map,Double food ,Double AMOUNT_FOOD){
        if (!map.get(creatureName.PLANT).isEmpty()) {
            System.out.println("рослини є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(creatureName.PLANT).containsKey(i)) {
                    System.out.println("Рослиноїдний їсть рослину");
                    key = i;
                    if (food + 1 >= AMOUNT_FOOD) {
                        food = AMOUNT_FOOD;
                    } else {
                        food += 1;
                    }
                    map.get(creatureName.PLANT).remove(key);
                    break;
                }
            }
        }
        else {
            System.out.println("Нема їжі");
        }
        return food;
    }


}
