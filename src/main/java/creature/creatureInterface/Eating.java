package creature.creatureInterface;

import creature.Creature;

import java.util.HashMap;

public interface Eating {
    void eating(HashMap<CreatureName, HashMap<Integer, Creature>> map);
}
