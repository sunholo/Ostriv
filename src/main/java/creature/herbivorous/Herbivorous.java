package creature.herbivorous;

import creature.Animal;

public abstract class Herbivorous extends Animal  {
    //override саме для травоїдних
    @Override
    public void eating() {

        System.out.println("травоїдний їсть");

    }
}
