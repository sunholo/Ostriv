package island;

//Комірка котра містить в собі мапу з тваринами
import creature.Animal;
import creature.Creature;
import creature.Plant;
import creature.creatureInterface.creatureName;
import creature.herbivorous.*;
import creature.predator.*;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
//локація це одна комірка острова
@ToString
@Getter
public  class Location {
    private static volatile Integer count = 0;
    HashMap<creatureName, HashMap<Integer, Creature>> map = new HashMap<>();

    //додавання створінь в локацію
    public Creature addCreature(Location location, creatureName creatureName, Integer id){
        return switch (creatureName){
            case WOLF -> location.getMap().get(creatureName).put(id,new Wolf(id));
            case DUCK ->  location.getMap().get(creatureName).put(id,new Duck(id));
            case HORSE ->  location.getMap().get(creatureName).put(id,new Horse(id));
            case PLANT -> location.getMap().get(creatureName).put(id,new Plant(id));
            case FOX ->  location.getMap().get(creatureName).put(id,new Fox(id));
            case WORM -> location.getMap().get(creatureName).put(id,new Worm(id));
            case COW -> location.getMap().get(creatureName).put(id,new Cow(id));
            case DEER -> location.getMap().get(creatureName).put(id,new Deer(id));
            case GOAT -> location.getMap().get(creatureName).put(id,new Goat(id));
            case HAMSTER -> location.getMap().get(creatureName).put(id,new Hamster(id));
            case KANGAROO -> location.getMap().get(creatureName).put(id,new Kangaroo(id));
            case RABBIT -> location.getMap().get(creatureName).put(id,new Rabbit(id));
            case SHEEP -> location.getMap().get(creatureName).put(id,new Sheep(id));
            case BEAR -> location.getMap().get(creatureName).put(id,new Bear(id));
            case EAGLE -> location.getMap().get(creatureName).put(id,new Eagle(id));
            case SNAKE -> location.getMap().get(creatureName).put(id,new Snake(id));


        };

    }

}
