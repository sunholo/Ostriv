package animal;

public abstract class Animal implements Reproduction, Movement, Dying{
    public volatile Integer amountPerCell;
    public volatile Double weight;
    public volatile Double amountFood;

}
