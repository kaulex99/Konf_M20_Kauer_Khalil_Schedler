package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        Liquid l = new Liquid("Wein", 0.125, 13);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Liquid anotherLiquid = new Liquid("Reiner Alkohol", 0.125, 99.9);

        Drink d = new SimpleDrink("Rotwein",l);

        List<Liquid> liquids = new ArrayList<>();
        liquids.add(l);
        liquids.add(anotherLiquid);

        Drink myDrink = new AlexDrink("Wonderful name", anotherLiquid);

        System.out.println(myDrink);
    }
}
