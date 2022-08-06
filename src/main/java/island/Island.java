package island;

import creature.creatureInterface.creatureName;
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
    private volatile Integer boarId = 0;
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
        randomAnimalFill(array, 100, "PLANT");
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
                case BOAR -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getBoarId());
                case RABBIT -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getRabbitId());
                case SHEEP -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getSheepId());
                case BEAR -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getBearId());
                case EAGLE -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getEagleId());
                case SNAKE -> randomLocation.addCreature(randomLocation, creatureName.valueOf(name), getSnakeId());
            }

        }
    }

    private Integer getHorseId() {
        horseId++;
        return horseId;
    }

    private Integer getPlantId() {
        plantId++;
        return plantId;
    }

    private Integer getFoxId() {
        foxId++;
        return foxId;
    }

    private Integer getDuckId() {
        duckId++;
        return duckId;
    }

    private Integer getWolfId() {
        wolfId++;
        return wolfId;
    }
    private Integer getWormId() {
        wormId++;
        return wormId;
    }
    private Integer getCowId() {
        cowId++;
        return cowId;
    }

    private Integer getDeerId() {
        deerId++;
        return deerId;
    }

    private Integer getGoatId() {
        goatId++;
        return goatId;
    }

    private Integer getHamsterId() {
        hamsterId++;
        return hamsterId;
    }

    private Integer getBoarId() {
        boarId++;
        return boarId;
    }

    private Integer getRabbitId() {
        rabbitId++;
        return rabbitId;
    }

    private Integer getSheepId() {
        sheepId++;
        return sheepId;
    }

    private Integer getBearId() {
        bearId++;
        return bearId;
    }

    private Integer getEagleId() {
        eagleId++;
        return eagleId;
    }

    private Integer getSnakeId() {
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
