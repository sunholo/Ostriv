package creature.predator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Fox extends Predator{
    private  Integer id ;
    private final Double WEIGHT = 8d;
    private final Double AMOUNT_FOOD = 2d;
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
