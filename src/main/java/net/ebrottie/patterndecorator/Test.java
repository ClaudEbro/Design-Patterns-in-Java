package net.ebrottie.patterndecorator;

import net.ebrottie.patterndecorator.composants.Drink;
import net.ebrottie.patterndecorator.composants.Espresso;
import net.ebrottie.patterndecorator.composants.Sumatra;
import net.ebrottie.patterndecorator.decorators.Caramel;
import net.ebrottie.patterndecorator.decorators.Chocolate;
import net.ebrottie.patterndecorator.decorators.Nutty;

public class Test {

    public static void main(String[] args) {

        // At first the user creates only a drink.
        Drink drink;
        drink = new Sumatra();
        System.out.println(drink.getDescription());
        System.out.println(drink.price());

        // Now we can create a drink with other decorators.
        System.out.println("--------------------");
        drink = new Chocolate(drink);
        System.out.println(drink.getDescription());
        System.out.println(drink.price());

        System.out.println("--------------------");
        drink = new Caramel(drink);
        System.out.println(drink.getDescription());
        System.out.println(drink.price());

        System.out.println("--------------------");
        drink = new Nutty(drink);
        System.out.println(drink.getDescription());
        System.out.println(drink.price());

        // Or you can use the instructions below to represent the previews.
        System.out.println("====================");
        Drink b;
        b = new Chocolate(new Caramel(new Nutty(new Chocolate(new Sumatra()))));
        System.out.println(drink.getDescription());
        System.out.println(drink.price());
    }
}
