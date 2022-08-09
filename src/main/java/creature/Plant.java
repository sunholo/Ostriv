package creature;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Plant extends Creature {
    private Integer id;
    private final Double WEIGHT = 1.0;


    @Override
    public void hunger() {
        super.hunger();
        System.out.println(Plant.class.getSimpleName() + " не голодають");
    }

    @Override
    public boolean dying() {

        System.out.println(this.getClass().getSimpleName() + " не вмирають");
        return false;

    }

}
