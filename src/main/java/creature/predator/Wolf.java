package creature.predator;

import creature.Creature;
import creature.creatureInterface.CreatureName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@AllArgsConstructor
@Getter
@ToString
public class Wolf extends Predator {
    private volatile Integer id;
    private final Double WEIGHT = 50d;
    private final Double AMOUNT_FOOD = 8d;
    private volatile Double food;
    private static final Integer[] CHANCE = {0,0,0,0,0,10,15,60,80,60,70,15,10,40,0,0};

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
    public void movement() {

    }




}
