package net.ebrottie.strategy;

public class StrategyImpl3 implements Strategy{
    @Override
    public void transactionStrategy() {
        System.out.println("=============================");
        System.out.println("======== Strategy 3 =========");
        System.out.println(":::::::::::::::::::::::::::::");
    }
}
