package creature.predator;

import creature.Animal;
import creature.Creature;
import creature.creatureInterface.creatureName;

import java.util.HashMap;

public abstract class Predator extends Animal {
    //override саме для хижаків
    @Override
    public void eating(HashMap<creatureName, HashMap<Integer, Creature>> map) {
        System.out.println("хижак їсть");

    }
}
