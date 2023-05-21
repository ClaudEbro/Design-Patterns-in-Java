package net.ebrottie.patterndecorator.composants;

public class Deca extends Drink {

    public Deca(){
        description = "Deca";
    }

    @Override
    public double price() {
        return 8;
    }
}
