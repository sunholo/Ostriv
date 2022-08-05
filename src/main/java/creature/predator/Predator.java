package creature.predator;

import creature.Animal;

public abstract class Predator extends Animal {
    //override саме для хижаків
    @Override
    public void eating() {
        System.out.println("хижак їсть");

    }
}
