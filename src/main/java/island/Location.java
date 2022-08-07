package island;

//Комірка котра містить в собі мапу з тваринами

import creature.Creature;
import creature.Plant;
import creature.creatureInterface.CreatureName;
import creature.herbivorous.*;
import creature.predator.*;
import lombok.Getter;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//локація це одна комірка острова
@ToString
@Getter
public class Location extends Thread {
    private static final Integer MAX_WOLF = 30;
    private static final Integer MAX_SNAKE = 30;
    private static final Integer MAX_FOX = 30;
    private static final Integer MAX_BEAR = 5;
    private static final Integer MAX_EAGLE = 20;
    private static final Integer MAX_HORSE = 20;
    private static final Integer MAX_RABBIT = 150;
    private static final Integer MAX_HAMSTER = 500;
    private static final Integer MAX_GOAT = 140;
    private static final Integer MAX_SHEEP = 140;
    private static final Integer MAX_BOAR = 50;
    private static final Integer MAX_COW = 10;
    private static final Integer MAX_DUCK = 200;
    private static final Integer MAX_WORM = 1000;
    private static final Integer MAX_PLANT = 200;
    private static final Integer MAX_DEER = 20;
    HashMap<CreatureName, HashMap<Integer, Creature>> map = new HashMap<>();

    //додавання створінь в локацію
    public Creature addCreature(Location location, CreatureName creatureName, Integer id) {
        return switch (creatureName) {
            case WOLF -> location.getMap().get(creatureName).put(id, new Wolf(id, 8d));
            case DUCK -> location.getMap().get(creatureName).put(id, new Duck(id, 0.15d));
            case HORSE -> location.getMap().get(creatureName).put(id, new Horse(id, 60d));
            case PLANT -> location.getMap().get(creatureName).put(id, new Plant(id));
            case FOX -> location.getMap().get(creatureName).put(id, new Fox(id, 2d));
            case WORM -> location.getMap().get(creatureName).put(id, new Worm(id, 0.1d));
            case COW -> location.getMap().get(creatureName).put(id, new Cow(id, 100d));
            case DEER -> location.getMap().get(creatureName).put(id, new Deer(id, 50d));
            case GOAT -> location.getMap().get(creatureName).put(id, new Goat(id, 10d));
            case HAMSTER -> location.getMap().get(creatureName).put(id, new Hamster(id, 0.01d));
            case BOAR -> location.getMap().get(creatureName).put(id, new Boar(id, 50d));
            case RABBIT -> location.getMap().get(creatureName).put(id, new Rabbit(id, 0.45d));
            case SHEEP -> location.getMap().get(creatureName).put(id, new Sheep(id, 15d));
            case BEAR -> location.getMap().get(creatureName).put(id, new Bear(id, 80d));
            case EAGLE -> location.getMap().get(creatureName).put(id, new Eagle(id, 1d));
            case SNAKE -> location.getMap().get(creatureName).put(id, new Snake(id, 3d));


        };

    }

    @Override
    public void run() {

        //проходими по локації і викликаїмо у всіх тварин метод їсти
        for (var x : map.entrySet()) {

            HashMap<Integer, Creature> creatureHashMap = x.getValue();

            for (var y : creatureHashMap.entrySet()) {
                System.out.println(y);
                if (y.getValue() instanceof Herbivorous) {
                    ((Herbivorous) y.getValue()).eating(map);
                } else if (y.getValue() instanceof Predator) {
                    ((Predator) y.getValue()).eating(map);
                }
            }
        }

        //проходимо по локації і викликаємо у всіх створінь метод розмножуватись
        HashMap<CreatureName, HashMap<Integer, Creature>> copyMap = new HashMap<>(map);
        for (var x : copyMap.entrySet()) {
            HashMap<Integer, Creature> creatureHashMap = x.getValue();
            int count = 0;
            for (Map.Entry<Integer, Creature> y : creatureHashMap.entrySet()) {
                count++;
                System.out.println(y + " " + count);
            }
            if (count >= 2) {
                int amountReproduction = (int) count / 2;
                switch (x.getKey()) {
                    case PLANT -> {
                        if ((count + amountReproduction) > MAX_PLANT) {
                            amountReproduction = MAX_PLANT - count;
                        }
                    }
                    case WORM -> {
                        if ((count + amountReproduction) > MAX_WORM) {
                            amountReproduction = MAX_WORM - count;
                        }
                    }
                    case WOLF -> {
                        if ((count + amountReproduction) > MAX_WOLF) {
                            amountReproduction = MAX_WOLF - count;
                        }
                    }
                    case COW -> {
                        if ((count + amountReproduction) > MAX_COW) {
                            amountReproduction = MAX_COW - count;
                        }
                    }
                    case FOX -> {
                        if ((count + amountReproduction) > MAX_FOX) {
                            amountReproduction = MAX_FOX - count;
                        }
                    }
                    case DEER -> {
                        if ((count + amountReproduction) > MAX_DEER) {
                            amountReproduction = MAX_DEER - count;
                        }
                    }
                    case DUCK -> {
                        if ((count + amountReproduction) > MAX_DUCK) {
                            amountReproduction = MAX_DUCK - count;
                        }
                    }
                    case SHEEP -> {
                        if ((count + amountReproduction) > MAX_SHEEP) {
                            amountReproduction = MAX_SHEEP - count;
                        }
                    }
                    case HORSE -> {
                        if ((count + amountReproduction) > MAX_HORSE) {
                            amountReproduction = MAX_HORSE - count;
                        }
                    }
                    case HAMSTER -> {
                        if ((count + amountReproduction) > MAX_HAMSTER) {
                            amountReproduction = MAX_HAMSTER - count;
                        }
                    }
                    case SNAKE -> {
                        if ((count + amountReproduction) > MAX_SNAKE) {
                            amountReproduction = MAX_SNAKE - count;
                        }
                    }
                    case BEAR -> {
                        if ((count + amountReproduction) > MAX_BEAR) {
                            amountReproduction = MAX_BEAR - count;
                        }
                    }
                    case BOAR -> {
                        if ((count + amountReproduction) > MAX_BOAR) {
                            amountReproduction = MAX_BOAR - count;
                        }
                    }
                    case EAGLE -> {
                        if ((count + amountReproduction) > MAX_EAGLE) {
                            amountReproduction = MAX_EAGLE - count;
                        }
                    }
                    case RABBIT -> {
                        if ((count + amountReproduction) > MAX_RABBIT) {
                            amountReproduction = MAX_RABBIT - count;
                        }
                    }
                    case GOAT -> {
                        if ((count + amountReproduction) > MAX_GOAT) {
                            amountReproduction = MAX_GOAT - count;
                        }
                    }

                }
                System.out.println("народжується " + amountReproduction);
                for (int i = 0; i < amountReproduction; i++) {
                    Creature.reproduction(map, x.getKey());
                }
            }

        }


        //проходимо по локації і вбиваємо усіх тварин в котрих їжі 0
        for (var x : map.entrySet()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            HashMap<Integer, Creature> creatureHashMap = x.getValue();

            for (var y : creatureHashMap.entrySet()) {
                System.out.println(y);
                if (y.getValue().dying()) {
                    arrayList.add(y.getKey());
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                creatureHashMap.remove(arrayList.get(i));
            }
            arrayList.clear();
        }


    }

}
