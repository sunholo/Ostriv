package creature.predator;

import creature.creatureInterface.creatureName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Wolf extends Predator {
    private final static Integer WEIGHT = Integer.valueOf(50);
    private volatile Integer id ;
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
