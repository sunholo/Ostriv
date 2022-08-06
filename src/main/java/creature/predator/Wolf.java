package creature.predator;

import creature.creatureInterface.creatureName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Wolf extends Predator {
    private volatile Integer id;
    private final Double WEIGHT = 50d;
    private final Double AMOUNT_FOOD = 8d;
    private volatile Double food;

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
