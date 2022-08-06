package island;

//Комірка котра містить в собі мапу з тваринами
import creature.Creature;
import creature.Plant;
import creature.creatureInterface.creatureName;
import creature.herbivorous.*;
import creature.predator.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.HashMap;
//локація це одна комірка острова
@ToString
@Getter
public  class Location extends Thread{
    private static volatile Integer count = 0;
    private static final Integer MAX_WOLF = 30;
    private static final Integer MAX_COW = 10;
    HashMap<creatureName, HashMap<Integer, Creature>> map = new HashMap<>();

    //додавання створінь в локацію
    public Creature addCreature(Location location, creatureName creatureName, Integer id){
        return switch (creatureName){
            case WOLF -> location.getMap().get(creatureName).put(id,new Wolf(id,0d));
            case DUCK ->  location.getMap().get(creatureName).put(id,new Duck(id, 0d));
            case HORSE ->  location.getMap().get(creatureName).put(id,new Horse(id,0d));
            case PLANT -> location.getMap().get(creatureName).put(id,new Plant(id));
            case FOX ->  location.getMap().get(creatureName).put(id,new Fox(id,0d));
            case WORM -> location.getMap().get(creatureName).put(id,new Worm(id,0.1d));
            case COW -> location.getMap().get(creatureName).put(id,new Cow(id, 0d));
            case DEER -> location.getMap().get(creatureName).put(id,new Deer(id,0d));
            case GOAT -> location.getMap().get(creatureName).put(id,new Goat(id,0d));
            case HAMSTER -> location.getMap().get(creatureName).put(id,new Hamster(id,0d));
            case BOAR -> location.getMap().get(creatureName).put(id,new Boar(id,0d));
            case RABBIT -> location.getMap().get(creatureName).put(id,new Rabbit(id,0d));
            case SHEEP -> location.getMap().get(creatureName).put(id,new Sheep(id,0d));
            case BEAR -> location.getMap().get(creatureName).put(id,new Bear(id,0d));
            case EAGLE -> location.getMap().get(creatureName).put(id,new Eagle(id,0d));
            case SNAKE -> location.getMap().get(creatureName).put(id,new Snake(id,0d));


        };

    }

    @Override
    public void run() {

        //проходими по локації і викликаїмо у всіх тварин метод їсти
        for (var x :map.entrySet()){

            HashMap<Integer, Creature> creatureHashMap = x.getValue();

            for (var y : creatureHashMap.entrySet()){
                System.out.println(y);
               if (y.getValue() instanceof Herbivorous){
                    ((Herbivorous) y.getValue()).eating(map);
                }
                else if (y.getValue() instanceof Predator){
                    ((Predator) y.getValue()).eating(map);
                }
            }
        }
    }

}
