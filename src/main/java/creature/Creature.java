package creature;

import creature.creatureInterface.Dying;
import creature.creatureInterface.CreatureName;
import creature.creatureInterface.Hunger;
import creature.herbivorous.*;
import creature.predator.*;
import island.Island;

import java.util.HashMap;


public abstract class Creature implements Dying, Hunger {
    @Override
    public void hunger() {
        System.out.print("Переварюється їжа у ");
    }

    //при розмноженні додається одна тварина цього виду в ту саму комірку
    public static void reproduction(HashMap<CreatureName, HashMap<Integer, Creature>> map, CreatureName creatureName) {
        int id = Island.getCreatureId();
        switch (creatureName) {
            case WOLF -> map.get(creatureName).put(id, new Wolf(id, 8d));
            case DUCK -> map.get(creatureName).put(id, new Duck(id, 0.15d));
            case HORSE -> map.get(creatureName).put(id, new Horse(id, 60d));
            case PLANT -> map.get(creatureName).put(id, new Plant(id));
            case FOX -> map.get(creatureName).put(id, new Fox(id, 2d));
            case WORM -> map.get(creatureName).put(id, new Worm(id, 0.1d));
            case COW -> map.get(creatureName).put(id, new Cow(id, 100d));
            case DEER -> map.get(creatureName).put(id, new Deer(id, 50d));
            case GOAT -> map.get(creatureName).put(id, new Goat(id, 10d));
            case HAMSTER -> map.get(creatureName).put(id, new Hamster(id, 0.01d));
            case BOAR -> map.get(creatureName).put(id, new Boar(id, 50d));
            case RABBIT -> map.get(creatureName).put(id, new Rabbit(id, 0.45d));
            case SHEEP -> map.get(creatureName).put(id, new Sheep(id, 15d));
            case BEAR -> map.get(creatureName).put(id, new Bear(id, 80d));
            case EAGLE -> map.get(creatureName).put(id, new Eagle(id, 1d));
            case SNAKE -> map.get(creatureName).put(id, new Snake(id, 3d));


        }

    }
}
