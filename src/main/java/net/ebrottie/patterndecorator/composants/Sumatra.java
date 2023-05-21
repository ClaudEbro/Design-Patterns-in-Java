package net.ebrottie.patterndecorator.composants;

public class Sumatra extends Drink {

    public Sumatra(){
        description = "Sumatra";
    }

    @Override
    public double price() {
        return 6;
    }
}
