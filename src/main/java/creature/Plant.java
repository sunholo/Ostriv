package creature;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Plant  extends Creature{
    private  Integer id ;
    private  final Double WEIGHT = 1.0;

    public Double getWeight() {
        return WEIGHT;
    }

    public Double getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public void reproduction() {

    }

    @Override
    public void dying() {

    }

}
