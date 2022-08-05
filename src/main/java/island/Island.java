package island;

import creature.creatureInterface.creatureName;
import creature.herbivorous.*;
import creature.predator.Bear;
import creature.predator.Eagle;
import creature.predator.Snake;
import lombok.Getter;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


//Острів котрий буде створенний зі масиву комірок в котрих будуть існувати тварини

public class Island {
    private volatile Integer wolfId = 0;
    private volatile Integer duckId = 0;
    private volatile Integer foxId = 0;
    private volatile Integer horseId = 0;
    private volatile Integer plantId = 0;
    private volatile Integer cowId = 0;
    private volatile Integer deerId = 0;
    private volatile Integer goatId = 0;
    private volatile Integer hamsterId = 0;
    private volatile Integer kangarooId = 0;
    private volatile Integer rabbitId = 0;
    private volatile Integer sheepId = 0;
    private volatile Integer bearId = 0;
    private volatile Integer eagleId = 0;
    private volatile Integer wormId = 0;
    private volatile Integer snakeId = 0;

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
        randomAnimalFill(array, 2, "PLANT");
        randomAnimalFill(array, 2, "COW");
        randomAnimalFill(array, 2, "DEER");
        randomAnimalFill(array, 2, "GOAT");
        randomAnimalFill(array, 2, "HAMSTER");
        randomAnimalFill(array, 2, "KANGAROO");
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

            switch (creatureName.valueOf(name)) {
                case WOLF -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getWolfId());
                case DUCK -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getDuckId());
                case FOX -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getFoxId());
                case HORSE -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getHorseId());
                case PLANT -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getPlantId());
                case WORM -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getWormId());
                case COW -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getCowId());
                case DEER -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getDeerId());
                case GOAT -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getGoatId());
                case HAMSTER -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getHamsterId());
                case KANGAROO -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getKangarooId());
                case RABBIT -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getRabbitId());
                case SHEEP -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getSheepId());
                case BEAR -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getBearId());
                case EAGLE -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getEagleId());
                case SNAKE -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getSnakeId());
            }

        }
    }

    public Integer getHorseId() {
        horseId++;
        return horseId;
    }

    public Integer getPlantId() {
        plantId++;
        return plantId;
    }

    public Integer getFoxId() {
        foxId++;
        return foxId;
    }

    public Integer getDuckId() {
        duckId++;
        return duckId;
    }

    public Integer getWolfId() {
        wolfId++;
        return wolfId;
    }
    public Integer getWormId() {
        wormId++;
        return wormId;
    }
    public Integer getCowId() {
        cowId++;
        return cowId;
    }

    public Integer getDeerId() {
        deerId++;
        return deerId;
    }

    public Integer getGoatId() {
        goatId++;
        return goatId;
    }

    public Integer getHamsterId() {
        hamsterId++;
        return hamsterId;
    }

    public Integer getKangarooId() {
        kangarooId++;
        return kangarooId;
    }

    public Integer getRabbitId() {
        rabbitId++;
        return rabbitId;
    }

    public Integer getSheepId() {
        sheepId++;
        return sheepId;
    }

    public Integer getBearId() {
        bearId++;
        return bearId;
    }

    public Integer getEagleId() {
        eagleId++;
        return eagleId;
    }

    public Integer getSnakeId() {
        snakeId++;
        return snakeId;
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
