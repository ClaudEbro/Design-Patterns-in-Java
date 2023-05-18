package net.ebrottie.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Context context = new Context();
        Scanner scanner = new Scanner(System.in);

        // If the object is not in memory cache
        Map<String,Strategy> strategyMap = new HashMap<>();
        Strategy strategy;

        while(true){
            System.out.println("What strategy ?");
            String str = scanner.nextLine();
            strategy = strategyMap.get(str);

            if (strategy == null){
                System.out.println("Creation of a new object of StrategyImpl "+str);
                        strategy = (Strategy) Class
                                .forName("net.ebrottie.strategy.StrategyImpl" +str)
                                .getConstructor().newInstance();

                        // If the object is not in memory cache, you put it in.
                        strategyMap.put(str,strategy);
            }

            // Injection of dependence
            context.setStrategy(strategy);

            context.conductTransaction();
        }
    }
}
