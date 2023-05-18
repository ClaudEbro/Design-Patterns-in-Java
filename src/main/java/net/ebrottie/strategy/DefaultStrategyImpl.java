package net.ebrottie.strategy;

public class DefaultStrategyImpl implements Strategy {
    @Override
    public void transactionStrategy() {
        System.out.println("===================================");
        System.out.println("======== Default Strategy =========");
        System.out.println(":::::::::::::::::::::::::::::::::::");
    }
}
