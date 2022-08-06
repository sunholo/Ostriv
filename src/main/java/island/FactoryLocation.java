package island;

import creature.Creature;
import creature.creatureInterface.creatureName;

import java.util.HashMap;

public class FactoryLocation {
    public Location createLocation(){
        Location newLocation = new Location();
        newLocation.map.put(creatureName.WOLF,new HashMap<Integer, Creature>());
        newLocation.map.put(creatureName.DUCK,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.FOX,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.HORSE,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.PLANT,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.WORM,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.COW,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.GOAT,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.HAMSTER,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.BOAR,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.RABBIT,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.SHEEP,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.BEAR,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.EAGLE,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.SNAKE,new HashMap<Integer,Creature>());
        newLocation.map.put(creatureName.DEER,new HashMap<Integer,Creature>());

        return newLocation;
    }

}
