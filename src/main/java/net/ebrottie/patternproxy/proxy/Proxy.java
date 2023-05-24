package net.ebrottie.patternproxy.proxy;

public class Proxy implements IService {

    private IService service;

    public Proxy(IService service){
        this.service=service;
    }

    @Override
    public double compute(int parameter) {
        double res = service.compute(parameter);
        return res;
    }

}
