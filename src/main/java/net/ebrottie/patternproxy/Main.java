package net.ebrottie.patternproxy;

import net.ebrottie.patternproxy.proxy.*;

public class Main {

    public static void main(String[] args) {
        SecurityContext.authenticate("user1", "1234", "root");
        Context context = new Context();
        context.setService(new SecurityProxy(new CacheProxy(new LoggingProxy(new ServiceImpl())))); //Calling the method of ServiceImpl as Spring Boot...
        context.compute(25);
        context.compute(25);
    }
}
