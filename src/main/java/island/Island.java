package island;

import creature.creatureInterface.CreatureName;
import lombok.Getter;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


//Острів котрий буде створенний зі масиву комірок в котрих будуть існувати тварини

public class Island {
    private static volatile Integer creatureId = 0;
    private static final Integer LENGTH = 3;
    private static final Integer HEIGHT = 3;
    @Getter
    Location[][] islandArray = new Location[LENGTH][HEIGHT];


    //початкове заповнення острова локаціями
    public void fillIsland(Location[][] array) {
        FactoryLocation factoryLocation = new FactoryLocation();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = factoryLocation.createLocation();
            }
        }


        //початкове , випадкове  заповнення локацій тваринами
        randomAnimalFill(array, 2, "WOLF");
        randomAnimalFill(array, 2, "DUCK");
        randomAnimalFill(array, 2, "HORSE");
        randomAnimalFill(array, 2, "FOX");
        randomAnimalFill(array, 22, "PLANT");
        randomAnimalFill(array, 2, "COW");
        randomAnimalFill(array, 2, "DEER");
        randomAnimalFill(array, 2, "GOAT");
        randomAnimalFill(array, 2, "HAMSTER");
        randomAnimalFill(array, 2, "BOAR");
        randomAnimalFill(array, 2, "RABBIT");
        randomAnimalFill(array, 2, "SHEEP");
        randomAnimalFill(array, 2, "BEAR");
        randomAnimalFill(array, 2, "EAGLE");
        randomAnimalFill(array, 2, "SNAKE");
        randomAnimalFill(array, 2, "WORM");
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
                '}';
    }
}
