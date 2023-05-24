package net.ebrottie.patternproxy.proxy;

/*
 * This class is implemented to calculate duration of logging.
 * */
public class LoggingProxy implements  IService{

    private IService service;

    public LoggingProxy(IService service){
        this.service=service;
    }

    @Override
    public double compute(int parameter) {
        //Time before calling method
        long t1 = System.currentTimeMillis();
        double res = service.compute(parameter);

        //Time after calling method
        long t2  = System.currentTimeMillis();

        System.out.println("Duration of method => "+(t2-t1));
        return res;
    }
}
