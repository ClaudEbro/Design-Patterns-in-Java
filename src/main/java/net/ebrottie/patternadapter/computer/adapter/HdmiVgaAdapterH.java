package net.ebrottie.patternadapter.computer.adapter;

import net.ebrottie.patternadapter.computer.TV;
import net.ebrottie.patternadapter.computer.Vga;

//This class is used to connect the central unit to TV by inheritance.
public class HdmiVgaAdapterH extends TV implements Vga {

    @Override
    public void print(String message) {

        System.out.println("======== Adapter =======");
        byte[] data = message.getBytes();
        super.view(data);
        System.out.println("======= / Adapter ======");
    }

}
