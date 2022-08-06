package creature.creatureInterface;

import creature.Animal;
import creature.Creature;

import java.util.HashMap;

public interface Eating {
    void eating(HashMap<creatureName, HashMap<Integer, Creature>> map);
}
