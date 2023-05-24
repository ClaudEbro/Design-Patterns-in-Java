package net.ebrottie.patternproxy.proxy;

public class Context {

    public IService service; //Object Context is linked to service interface.

    public void compute(int parameter){ // Calling method compute of IService.
        System.out.println("===============");
        double result = service.compute(parameter);
        System.out.println("Result => "+result);
        System.out.println("===============");
    }

    public void setService(IService service) {
        this.service = service;
    }
}
