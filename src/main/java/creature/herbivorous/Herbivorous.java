package creature.herbivorous;

import creature.Animal;
import creature.Creature;
import creature.creatureInterface.CreatureName;

import java.util.HashMap;

public abstract class Herbivorous extends Animal {

    @Override
    public void eating(HashMap<CreatureName, HashMap<Integer, Creature>> map) {
        System.out.println("трвоїдний шукає їжу");
    }

    //в цьому методі рослиноїдні ідять виключно рослини
    public Double herbivorousEating(HashMap<CreatureName, HashMap<Integer,
            Creature>> map, Double food, Double AMOUNT_FOOD) {
        if (!map.get(CreatureName.PLANT).isEmpty()) {
            System.out.println(CreatureName.PLANT + " є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(CreatureName.PLANT).containsKey(i)) {
                    System.out.println("Травоїдний їсть " + CreatureName.PLANT);
                    key = i;
                    if (food + 1 >= AMOUNT_FOOD) {
                        food = AMOUNT_FOOD;
                    } else {
                        food += 1;
                    }
                    map.get(CreatureName.PLANT).remove(key);
                    break;
                }
            }
        } else {
            System.out.println("Нема їжі");
        }
        return food;
    }


}
