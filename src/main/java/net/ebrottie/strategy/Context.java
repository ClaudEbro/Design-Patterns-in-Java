package net.ebrottie.strategy;

public class Context {

    /* If you have an algo like that, you notice that only the second instruction or method changes.
    // So, you can create an interface to implement it.


    public void conductTransaction(int type) {

        if (type == 1) {
            System.out.println("*********************");
            System.out.println("---------Strategy 1------------");
            System.out.println("=====================");
        }
        else if (type == 2) {
            System.out.println("*********************");
            System.out.println("---------Strategy 2------------");
            System.out.println("=====================");
        }
        else if (type == 3) {
            System.out.println("*********************");
            System.out.println("---------Strategy 3------------");
            System.out.println("=====================");
        }
        else {
            System.out.println("*********************");
            System.out.println("---------Default Strategy------------");
            System.out.println("=====================");
        }*/

        //So you can write this class like that
        private Strategy strategy = new DefaultStrategyImpl(); //Initialize the Strategy

        public void conductTransaction(){
            System.out.println("*********************");
            strategy.transactionStrategy();
            System.out.println("**********************");
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }
}
