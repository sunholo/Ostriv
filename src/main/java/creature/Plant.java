package creature;

import creature.creatureInterface.Reproduction;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Plant  extends Creature{
    private  Integer id ;
    private static final Double WEIGHT = 1.0;

    public Double getWeight() {
        return WEIGHT;
    }

    @Override
    public void reproduction() {

    }

    @Override
    public void dying() {

    }

}
