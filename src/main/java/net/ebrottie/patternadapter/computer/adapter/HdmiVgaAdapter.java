package net.ebrottie.patternadapter.computer.adapter;

import net.ebrottie.patternadapter.computer.Hdmi;
import net.ebrottie.patternadapter.computer.Vga;

//This class is used to connect the central unit to TV by composition.
public class HdmiVgaAdapter implements Vga {

    private Hdmi hdmi;

    @Override
    public void print(String message) {

        System.out.println("======== Adapter =======");
        byte[] data = message.getBytes();
        hdmi.view(data);
        System.out.println("======= /Adapter =======");
    }

    public void setHdmi(Hdmi hdmi) {
        this.hdmi = hdmi;
    }
}
