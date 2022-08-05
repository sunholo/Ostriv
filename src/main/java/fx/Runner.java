package fx;

import creature.creatureInterface.creatureName;
import creature.herbivorous.Duck;
import creature.predator.Wolf;
import island.FactoryLocation;
import island.Island;
import island.Location;

public class Runner {
    public static void main(String[] args) {
        Island island = new Island();
        island.fillIsland(island.getIslandArray());
        System.out.println(island);

    }
}
