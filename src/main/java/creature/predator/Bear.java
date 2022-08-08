package creature.predator;

import creature.Creature;
import creature.creatureInterface.CreatureName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@AllArgsConstructor
@ToString
@Getter
public class Bear extends Predator {
    private volatile Integer id;
    private final Double WEIGHT = 500d;
    private final Double AMOUNT_FOOD = 80d;
    private volatile Double food;
    private static final Integer[] CHANCE = {0, 80, 0, 0, 0, 40, 80, 80, 90, 70, 70, 50, 20, 10, 0, 0};

    @Override
    public void hunger() {
        super.hunger();
        System.out.println(this.getClass().getSimpleName());
        if (food - 1 < 0){
            food = 0d;
        }
        else {
            food --;
        }
    }

    @Override
    public void eating(HashMap<CreatureName, HashMap<Integer, Creature>> map) {
        super.eating(map);
        food = super.predatorEating(map, food, AMOUNT_FOOD, CHANCE);
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
    public Integer movement() {
        System.out.println(this.getClass().getSimpleName() + " намагається переміститись");
        return 2;
    }


}
