package creature.herbivorous;

import creature.Creature;
import creature.creatureInterface.creatureName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@AllArgsConstructor
@ToString
@Getter
public class Boar extends Herbivorous {
    private volatile Integer id;
    private final Double WEIGHT = 400d;
    private final Double AMOUNT_FOOD = 50d;
    private volatile Double food;

    @Override
    public void eating(HashMap<creatureName, HashMap<Integer, Creature>> map) {
        super.eating(map);
        //кнур їсть рослину
        if (!map.get(creatureName.PLANT).isEmpty()) {
            System.out.println("рослини є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(creatureName.PLANT).containsKey(i)) {
                    System.out.println("кнур їсть рослину");
                    key = i;
                    if (food + 1 >= AMOUNT_FOOD) {
                        food = getAMOUNT_FOOD();
                    } else {
                        food += 1;
                    }
                    map.get(creatureName.PLANT).remove(key);
                    break;
                }
            }
        }
        //кнур їсть хробака
        else if (!map.get(creatureName.WORM).isEmpty()) {
            System.out.println("хробаки є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(creatureName.WORM).containsKey(i)) {
                    System.out.println("кнур їсть хробака");
                    key = i;
                    if (food + 0.01 >= AMOUNT_FOOD) {
                        food = getAMOUNT_FOOD();
                    } else {
                        food += 0.01;
                    }
                    map.get(creatureName.WORM).remove(key);
                    break;
                }
            }
        }
        else {
            System.out.println("Нема їжі");
        }
    }

    @Override
    public void dying() {

    }

    @Override
    public void movement() {

    }

    @Override
    public void reproduction() {

    }
}
