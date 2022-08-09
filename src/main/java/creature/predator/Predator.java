package creature.predator;

import creature.Animal;
import creature.Creature;
import creature.creatureInterface.CreatureName;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    @Override
    public void eating(HashMap<CreatureName, HashMap<Integer, Creature>> map) {
        System.out.println("хижак щукає їжу");

    }

    //в методі в заложності від шансів хижаки можуть з'їсти їнших тварин
    public Double predatorEating(HashMap<CreatureName, HashMap<Integer, Creature>> map, Double food,
                                 Double AMOUNT_FOOD, Integer[] arr) {
        if (!map.get(CreatureName.WOLF).isEmpty() && arr[0] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.WOLF, arr[0], 50d);
        } else if (!map.get(CreatureName.SNAKE).isEmpty() && arr[1] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.SNAKE, arr[1], 15d);
        } else if (!map.get(CreatureName.FOX).isEmpty() && arr[2] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.FOX, arr[2], 8d);
        } else if (!map.get(CreatureName.BEAR).isEmpty() && arr[3] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.BEAR, arr[3], 500d);
        } else if (!map.get(CreatureName.EAGLE).isEmpty() && arr[4] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.EAGLE, arr[4], 6d);
        } else if (!map.get(CreatureName.HORSE).isEmpty() && arr[5] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.HORSE, arr[5], 400d);
        } else if (!map.get(CreatureName.DEER).isEmpty() && arr[6] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.DEER, arr[6], 300d);
        } else if (!map.get(CreatureName.RABBIT).isEmpty() && arr[7] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.RABBIT, arr[7], 2d);
        } else if (!map.get(CreatureName.HAMSTER).isEmpty() && arr[8] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.HAMSTER, arr[8], 0.05);
        } else if (!map.get(CreatureName.GOAT).isEmpty() && arr[9] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.GOAT, arr[9], 60d);
        } else if (!map.get(CreatureName.SHEEP).isEmpty() && arr[10] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.SHEEP, arr[10], 70d);
        } else if (!map.get(CreatureName.BOAR).isEmpty() && arr[11] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.BOAR, arr[11], 400d);
        } else if (!map.get(CreatureName.COW).isEmpty() && arr[12] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.COW, arr[12], 700d);
        } else if (!map.get(CreatureName.DUCK).isEmpty() && arr[13] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.DUCK, arr[13], 1d);
        } else if (!map.get(CreatureName.WORM).isEmpty() && arr[14] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.WORM, arr[14], 0.01);
        } else if (!map.get(CreatureName.PLANT).isEmpty() && arr[15] > 0) {
            return eat(map, food, AMOUNT_FOOD, CreatureName.PLANT, arr[15], 1d);
        } else {
            System.out.println("Нема їжі");
        }

        return food;
    }

    //метод для скорочення коду методу predatorEating
    public Double eat(HashMap<CreatureName, HashMap<Integer, Creature>> map, Double food,
                      Double AMOUNT_FOOD, CreatureName name, Integer chance, Double weight) {
        if (chance != 0) {
            int random = ThreadLocalRandom.current().nextInt(1, 100);
            System.out.println("шанс зїдення = " + chance);
            if (random <= chance) {
                System.out.println(name + " є");
                Integer key;
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    if (map.get(name).containsKey(i)) {
                        System.out.println("хижак їсть " + name);
                        key = i;
                        if (food + weight >= AMOUNT_FOOD) {
                            food = AMOUNT_FOOD;
                        } else {
                            food += weight;
                        }
                        map.get(name).remove(key);
                        break;
                    }
                }
            } else {
                System.out.println("Не вдалося з'їсти");
            }
        }
        return food;
    }

}
