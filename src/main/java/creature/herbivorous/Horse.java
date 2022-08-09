package creature.herbivorous;

import creature.Creature;
import creature.creatureInterface.CreatureName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;

@AllArgsConstructor
@ToString
@Getter
public class Horse extends Herbivorous {
    private Integer id;
    private final Double WEIGHT = 400d;
    private final Double AMOUNT_FOOD = 60d;
    private volatile Double food;

    @Override
    public void hunger() {
        super.hunger();
//        System.out.println(this.getClass().getSimpleName());
        if (food - 1 < 0) {
            food = 0d;
        } else {
            food--;
        }
    }

    @Override
    public void eating(HashMap<CreatureName, HashMap<Integer, Creature>> map) {
        super.eating(map);
        food = super.herbivorousEating(map, food, AMOUNT_FOOD);
    }

    @Override
    public boolean dying() {
        if (food > 0) {
            return false;
        } else {
//            System.out.println(this.getClass().getSimpleName() + " вмер");
            return true;
        }
    }

    @Override
    public Integer movement() {
 //       System.out.println(this.getClass().getSimpleName() + " намагається переміститись");
        return 4;
    }


}
