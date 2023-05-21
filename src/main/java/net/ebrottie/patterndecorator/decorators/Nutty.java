package net.ebrottie.patterndecorator.decorators;

import net.ebrottie.patterndecorator.composants.Drink;

public class Nutty extends Decorator{

    public Nutty(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription()+" with Nutty";
    }

    @Override
    public double price() {
        return 0.8+ drink.price();
    }
}
