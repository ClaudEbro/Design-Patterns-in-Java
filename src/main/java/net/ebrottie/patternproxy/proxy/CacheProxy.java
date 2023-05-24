package net.ebrottie.patternproxy.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements IService{

    private Map<Integer, Double> cache = new HashMap<>();

    private IService service;

    public CacheProxy(IService service){
        this.service=service;
    }

    @Override
    public double compute(int parameter) {
        Double cacheValue = cache.get(parameter);
        if(cacheValue != null) {
            System.out.println("----------- Cache Result ----------");
            return cacheValue;
        }
        else{
            double res = service.compute(parameter);
            cache.put(parameter,res);
            System.out.println("******** New Computing Result *********");
            return res;
        }
    }
}
