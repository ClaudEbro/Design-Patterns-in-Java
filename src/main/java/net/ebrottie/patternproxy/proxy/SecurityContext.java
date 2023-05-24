package net.ebrottie.patternproxy.proxy;

public class SecurityContext {

    public static String username =" ";
    public static String password = " ";
    public static String role = " ";

    public static void authenticate(String un, String pwd, String r){
        username = un;
        password = pwd;
        role = r;
    }
}
