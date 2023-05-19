package net.ebrottie.patternadapter;

import net.ebrottie.patternadapter.computer.*;
import net.ebrottie.patternadapter.computer.adapter.HdmiVgaAdapter;
import net.ebrottie.patternadapter.computer.adapter.HdmiVgaAdapterH;

public class Test {
    public static void main(String[] args) {

        CentralUnit centralUnit = new CentralUnit();

        //To link the screen
        centralUnit.setVga(new Screen());
        centralUnit.print("Hello !");

        //To link the video projector
        centralUnit.setVga(new VideoProjector());
        centralUnit.print("Hello !");

        //You can now link the central unit to TV by the class HdmiVgaAdapter based on composition
        HdmiVgaAdapter hdmiVgaAdapter = new HdmiVgaAdapter();
        hdmiVgaAdapter.setHdmi(new TV());
        centralUnit.setVga(hdmiVgaAdapter);
        hdmiVgaAdapter.print("Hi TV");

        //You can now link the central unit to TV by the class HdmiVgaAdapter based on inheritance
        HdmiVgaAdapterH hdmiVgaAdapterH = new HdmiVgaAdapterH();
        centralUnit.setVga(hdmiVgaAdapterH);
        hdmiVgaAdapter.print("Hi TV on H");

        //Connect the central unit to super video projector
        centralUnit.setVga(new SuperVideoProjector());
        centralUnit.print("Hi All");

        //Connect the central unit to super video projector by Hdmi
        HdmiVgaAdapter hdmiVgaAdapter1 = new HdmiVgaAdapter();
        hdmiVgaAdapter1.setHdmi(new SuperVideoProjector());
        centralUnit.setVga(hdmiVgaAdapter1);
        centralUnit.print("Hi HDMI");
    }
}
