package net.ebrottie.strategy;

public class StrategyImpl1 implements Strategy{
    @Override
    public void transactionStrategy() {
        System.out.println("+++++++++ Strategy 1 ++++++++++");
    }
}
