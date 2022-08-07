package creature.herbivorous;

import creature.Creature;
import creature.creatureInterface.CreatureName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@ToString
@Getter
public class Hamster extends Herbivorous {
    private volatile Integer id;
    private final Double WEIGHT = 0.05d;
    private final Double AMOUNT_FOOD = 0.01d;
    private volatile Double food;

    @Override
    public void eating(HashMap<CreatureName, HashMap<Integer, Creature>> map) {
        super.eating(map);
        int random = ThreadLocalRandom.current().nextInt(1, 100);
        //Хом'як їсть рослину
        if (!map.get(CreatureName.PLANT).isEmpty()) {
            System.out.println("рослини є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(CreatureName.PLANT).containsKey(i)) {
                    System.out.println("Хом'як їсть рослину");
                    key = i;
                    if (food + 1 >= AMOUNT_FOOD) {
                        food = getAMOUNT_FOOD();
                    } else {
                        food += 1;
                    }
                    map.get(CreatureName.PLANT).remove(key);
                    break;
                }
            }
        }

        //Хом'як їсть хробака
        else if (!map.get(CreatureName.WORM).isEmpty() && random <= 90) {
            System.out.println(CreatureName.WORM + " є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(CreatureName.WORM).containsKey(i)) {
                    System.out.println("Хом'як їсть " + CreatureName.WORM);
                    key = i;
                    if (food + 0.01 > AMOUNT_FOOD) {
                        food = getAMOUNT_FOOD();
                    } else {
                        food += 0.01;
                    }
                    map.get(CreatureName.WORM).remove(key);
                    break;
                }
            }
        }
        else {
            System.out.println("Нема їжі");
        }
    }


    @Override
    public boolean dying() {
        if (food > 0){
            return false;
        }
        else {
            System.out.println(this.getClass().getSimpleName() + " вмер");
            return true;
        }
    }

    @Override
    public void movement() {

    }


}
