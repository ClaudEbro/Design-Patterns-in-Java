package net.ebrottie.patterndecorator.decorators;

import net.ebrottie.patterndecorator.composants.Drink;

public class Caramel extends Decorator{

    public Caramel(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription()+" with Caramel";
    }

    @Override
    public double price() {
        return 0.8+ drink.price();
    }
}
