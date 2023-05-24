package net.ebrottie.patternproxy.proxy;

public class ServiceImpl implements IService {
    @Override
    public double compute(int parameter) {
        double value = 30;

        //To evaluate time duration of LoggingProxy method
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return value*parameter;
    }
}
