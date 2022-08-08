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
public class Worm extends Herbivorous {
    private Integer id;
    private final Double WEIGHT = 0.01d;
    private final Double AMOUNT_FOOD = 0d;
    private volatile Double food;

    @Override
    public void hunger() {
        super.hunger();
        System.out.println(Worm.class.getSimpleName() + " не голодають");
    }

    @Override
    public boolean dying() {
        System.out.println(this.getClass().getSimpleName() + " не вмирають");
        return false;
    }

    @Override
    public Integer movement() {
        System.out.println(this.getClass().getSimpleName() + " не переміщується");
        return 0;
    }


    @Override
    public void eating(HashMap<CreatureName, HashMap<Integer, Creature>> map) {
        super.eating(map);
    }
}
