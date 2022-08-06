package creature.predator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Bear extends Predator{
    private volatile Integer id ;
    private final Double WEIGHT = 500d;
    private final Double AMOUNT_FOOD = 80d;
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
