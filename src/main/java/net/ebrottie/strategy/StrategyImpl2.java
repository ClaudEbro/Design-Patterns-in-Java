package net.ebrottie.strategy;

public class StrategyImpl2 implements Strategy{
    @Override
    public void transactionStrategy() {
        System.out.println(".............................");
        System.out.println("........ Strategy 2 .........");
        System.out.println(":::::::::::::::::::::::::::::");
    }
}