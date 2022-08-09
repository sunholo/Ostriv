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
public class Boar extends Herbivorous {
    private volatile Integer id;
    private final Double WEIGHT = 400d;
    private final Double AMOUNT_FOOD = 50d;
    private Double food;

    @Override
    public void hunger() {
        super.hunger();
        System.out.println(this.getClass().getSimpleName());
        if (food - 1 < 0) {
            food = 0d;
        } else {
            food--;
        }
    }

    @Override
    public void eating(HashMap<CreatureName, HashMap<Integer, Creature>> map) {
        super.eating(map);
        int random = ThreadLocalRandom.current().nextInt(1, 100);
        //кнур їсть рослину
        if (!map.get(CreatureName.PLANT).isEmpty()) {
            System.out.println("рослини є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(CreatureName.PLANT).containsKey(i)) {
                    System.out.println("кнур їсть рослину");
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
        //кнур їсть хробака
        else if (!map.get(CreatureName.WORM).isEmpty() && random <= 90) {
            System.out.println("хробаки є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(CreatureName.WORM).containsKey(i)) {
                    System.out.println("кнур їсть хробака");
                    key = i;
                    if (food + 0.01 >= AMOUNT_FOOD) {
                        food = getAMOUNT_FOOD();
                    } else {
                        food += 0.01;
                    }
                    map.get(CreatureName.WORM).remove(key);
                    break;
                }
            }
        } else if (!map.get(CreatureName.HAMSTER).isEmpty() && random <= 50) {
            System.out.println(CreatureName.HAMSTER + " є");
            Integer key;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (map.get(CreatureName.HAMSTER).containsKey(i)) {
                    System.out.println("кнур їсть " + CreatureName.HAMSTER);
                    key = i;
                    if (food + 0.05 >= AMOUNT_FOOD) {
                        food = getAMOUNT_FOOD();
                    } else {
                        food += 0.05;
                    }
                    map.get(CreatureName.HAMSTER).remove(key);
                    break;
                }
            }
        } else {
            System.out.println("Нема їжі");
        }
    }

    @Override
    public boolean dying() {
        if (food > 0) {
            return false;
        } else {
            System.out.println(this.getClass().getSimpleName() + " вмер");
            return true;
        }
    }

    @Override
    public Integer movement() {
        System.out.println(this.getClass().getSimpleName() + " намагається переміститись");
        return 2;
    }


}
