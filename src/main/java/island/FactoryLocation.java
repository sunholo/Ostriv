package island;

import creature.Creature;
import creature.creatureInterface.CreatureName;

import java.util.HashMap;

public class FactoryLocation {
    public Location createLocation() {
        Location newLocation = new Location();
        newLocation.map.put(CreatureName.WOLF, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.DUCK, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.FOX, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.HORSE, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.PLANT, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.WORM, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.COW, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.GOAT, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.HAMSTER, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.BOAR, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.RABBIT, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.SHEEP, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.BEAR, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.EAGLE, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.SNAKE, new HashMap<Integer, Creature>());
        newLocation.map.put(CreatureName.DEER, new HashMap<Integer, Creature>());

        return newLocation;
    }

}
