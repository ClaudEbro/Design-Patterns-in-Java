package net.ebrottie.patternadapter.computer;

public class Screen implements Vga {

    //The Screen is a standard implementation

    @Override
    public void print(String message) {
        System.out.println("=========== Screen ===========");
        System.out.println(message);
        System.out.println("=========== Screen ==========");
    }
}
