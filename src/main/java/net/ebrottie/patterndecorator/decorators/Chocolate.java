package net.ebrottie.patterndecorator.decorators;

import net.ebrottie.patterndecorator.composants.Drink;

public class Chocolate extends Decorator{

    public Chocolate(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription()+" with chocolate";
    }

    @Override
    public double price() {
        return 1.2+ drink.price();
    }
}
