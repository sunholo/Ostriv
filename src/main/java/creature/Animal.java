package creature;


import creature.creatureInterface.Eating;
import creature.creatureInterface.Movement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal extends Creature implements  Movement, Eating {
//private volatile Double weight;
//private volatile Double amountFood;
//private volatile Integer amountPerCell;

}
