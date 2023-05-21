package net.ebrottie.patterndecorator.decorators;

import net.ebrottie.patterndecorator.composants.Drink;

public abstract class Decorator extends Drink {

    protected Drink drink;

    public Decorator(Drink drink){
        this.drink = drink;
    }
}
