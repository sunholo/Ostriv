package creature.predator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Eagle extends Predator{
    private volatile Integer id ;
    private final Double WEIGHT = 6d;
    private final Double AMOUNT_FOOD = 1d;
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
