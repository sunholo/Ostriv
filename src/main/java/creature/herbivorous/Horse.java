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
public class Horse extends Herbivorous{
    private  Integer id ;
    private final Double WEIGHT = 400d;
    private final Double AMOUNT_FOOD = 60d;
    private volatile Double food;
    @Override
    public void eating(HashMap<creatureName, HashMap<Integer, Creature>> map) {
        super.eating(map);
        food = super.herbivorousEating(map,food,AMOUNT_FOOD);
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
