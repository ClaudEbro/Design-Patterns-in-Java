package net.ebrottie.patterndecorator.composants;

public abstract class Drink {

    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract double price();
}
