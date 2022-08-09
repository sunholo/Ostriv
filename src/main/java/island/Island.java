package island;

import creature.Animal;
import creature.Creature;
import creature.creatureInterface.CreatureName;
import creature.herbivorous.*;
import creature.predator.*;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;


//Острів котрий буде створенний зі масиву комірок в котрих будуть існувати тварини
public class Island {
    private static volatile Integer creatureId = 0;
    private static final Integer LENGTH = 5;
    private static final Integer HEIGHT = 5;
    @Getter
    Location[][] islandArray = new Location[LENGTH][HEIGHT];

    //тут треба створити метод переміщення тварин в переданій локації
    public void moveAnimal(Location location, int i, int j) {
        //проходимося по локації
        for (var x : islandArray[i][j].getMap().entrySet()) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (var y : x.getValue().entrySet()) {

                //перевіряємо чи це тварина
                if (y.getValue() instanceof Animal) {
                    //перевірка що тварина вміє рухатись
                    if (((Animal) y.getValue()).movement() > 0) {
                        //копіюємо тварину
                        int length = i;
                        int height = j;
                        int keyCopy = y.getKey();

                        for (int k = 0; k < ((Animal) y.getValue()).movement(); k++) {
                            //обирається шлях тварини
                            int randomWay = ThreadLocalRandom.current().nextInt(1, 4);
                            switch (randomWay) {
                                case 1 -> {
                                    length++;
                                    height++;
                                }
                                case 2 -> {
                                    length--;
                                    height--;
                                }

                                case 3 -> {
                                    length++;
                                    height--;
                                }
                                case 4 -> {
                                    length--;
                                    height++;
                                }
                            }
                            //перевіряємо не виходить шлях за межі острова
                            if (length < 0) {
                                length = 0;
                            }
                            if (length >= LENGTH) {
                                length = LENGTH - 1;
                            }
                            if (height < 0) {
                                height = 0;
                            }
                            if (height >= HEIGHT) {
                                height = HEIGHT - 1;
                            }
                        }

                        //перевірити кінцеву локацю на максимальну кількість тварин
                        int count = 0;
                        for (var q : islandArray[length][height].getMap().entrySet()) {
                            for (var e : q.getValue().entrySet()) {
                                if (e.getValue().getClass().equals(y.getValue().getClass())) {
                                    count++;
                                }
                            }
                        }
                        // після перевірок на співрадіння класу
                        // і чи не перевищує максимальної кількості тварин цього виду
                        // чи немає тварини зі таким ключем
                        // вставляю в кінцеву комірку тварину
                        if (y.getValue().getClass().equals(Wolf.class)) {
                            if (count < Location.MAX_WOLF && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.WOLF)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.WOLF)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.WOLF)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Bear.class)) {
                            if (count < Location.MAX_BEAR && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.BEAR)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.BEAR)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.BEAR)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Eagle.class)) {
                            if (count < Location.MAX_EAGLE && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.EAGLE)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.EAGLE)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.EAGLE)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Fox.class)) {
                            if (count < Location.MAX_FOX && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.FOX)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.FOX)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.FOX)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Snake.class)) {
                            if (count < Location.MAX_SNAKE && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.SNAKE)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.SNAKE)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.SNAKE)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Boar.class)) {
                            if (count < Location.MAX_BOAR && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.BOAR)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.BOAR)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.BOAR)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Cow.class)) {
                            if (count < Location.MAX_COW && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.COW)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.COW)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.COW)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Deer.class)) {
                            if (count < Location.MAX_DEER && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.DEER)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.DEER)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.DEER)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Duck.class)) {
                            if (count < Location.MAX_DUCK && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.DUCK)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.DUCK)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.DUCK)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Goat.class)) {
                            if (count < Location.MAX_GOAT && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.GOAT)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.GOAT)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.GOAT)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Hamster.class)) {
                            if (count < Location.MAX_HAMSTER && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.HAMSTER)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.HAMSTER)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.HAMSTER)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Horse.class)) {
                            if (count < Location.MAX_HORSE && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.HORSE)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.HORSE)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.HORSE)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Rabbit.class)) {
                            if (count < Location.MAX_RABBIT && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.RABBIT)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.RABBIT)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.RABBIT)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        } else if (y.getValue().getClass().equals(Sheep.class)) {
                            if (count < Location.MAX_SHEEP && !islandArray[length][height]
                                    .getMap()
                                    .get(CreatureName.SHEEP)
                                    .containsKey(keyCopy)) {
                                islandArray[length][height]
                                        .getMap()
                                        .get(CreatureName.SHEEP)
                                        .put(keyCopy, islandArray[i][j]
                                                .getMap()
                                                .get(CreatureName.SHEEP)
                                                .get(keyCopy));
                                arrayList.add(keyCopy);
                            }
                        }
                    }
                }
            }
            //  видаляю в початковій комірці ключи тварин ща перемістив
            for (Integer integer : arrayList) {
                x.getValue().remove(integer);
            }
            arrayList.clear();
        }
    }

    //початкове заповнення острова локаціями
    public void fillIsland(Location[][] array) {
        FactoryLocation factoryLocation = new FactoryLocation();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = factoryLocation.createLocation();
            }
        }

        //початкове , випадкове  заповнення локацій тваринами
        randomAnimalFill(array, 30, "WOLF");
        randomAnimalFill(array, 200, "DUCK");
        randomAnimalFill(array, 20, "HORSE");
        randomAnimalFill(array, 30, "FOX");
        randomAnimalFill(array, 200, "PLANT");
        randomAnimalFill(array, 10, "COW");
        randomAnimalFill(array, 20, "DEER");
        randomAnimalFill(array, 140, "GOAT");
        randomAnimalFill(array, 500, "HAMSTER");
        randomAnimalFill(array, 50, "BOAR");
        randomAnimalFill(array, 150, "RABBIT");
        randomAnimalFill(array, 140, "SHEEP");
        randomAnimalFill(array, 5, "BEAR");
        randomAnimalFill(array, 20, "EAGLE");
        randomAnimalFill(array, 30, "SNAKE");
        randomAnimalFill(array, 1000, "WORM");
    }


    //випадкове заповнення переданої локації заданною кількісттю обраної тварини
    private void randomAnimalFill(Location[][] array, Integer amountCreature, String name) {

        for (int i = 0; i < amountCreature; i++) {
            Integer random1 = ThreadLocalRandom.current().nextInt(0, LENGTH);
            Integer random2 = ThreadLocalRandom.current().nextInt(0, HEIGHT);

            Location randomLocation = array[random1][random2];

            switch (CreatureName.valueOf(name)) {
                case WOLF -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case DUCK -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case FOX -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case HORSE -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case PLANT -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case WORM -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case COW -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case DEER -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case GOAT -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case HAMSTER -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case BOAR -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case RABBIT -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case SHEEP -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case BEAR -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case EAGLE -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
                case SNAKE -> randomLocation.addCreature(randomLocation, CreatureName.valueOf(name), getCreatureId());
            }

        }
    }

    public static Integer getCreatureId() {
        creatureId++;
        return creatureId;
    }


    @Override
    public String toString() {
        return "Island{" + "\n" +
                Arrays.toString(islandArray[0]) + "\n" +
                Arrays.toString(islandArray[1]) + "\n" +
                Arrays.toString(islandArray[2]) + "\n" +
                Arrays.toString(islandArray[3]) + "\n" +
                Arrays.toString(islandArray[4]) + "\n" +
                '}';
    }
}
