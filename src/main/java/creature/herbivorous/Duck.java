package creature.herbivorous;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Duck  extends Herbivorous{
    private  Integer id ;

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
