package fx;

import animal.Animal;
import animal.herbivorous.Duck;

import java.util.HashMap;
import java.util.Map;

public  class Runner {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.reproduction();
        duck.movement();
        duck.dying();
        HashMap<Integer,Animal> map = new HashMap<>();


    }
}
