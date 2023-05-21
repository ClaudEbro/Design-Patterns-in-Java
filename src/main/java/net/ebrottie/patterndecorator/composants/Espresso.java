package net.ebrottie.patterndecorator.composants;

public class Espresso extends Drink {

    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double price() {
        return 12;
    }
}
