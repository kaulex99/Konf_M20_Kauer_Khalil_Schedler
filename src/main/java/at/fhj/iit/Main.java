package at.fhj.iit;

public class Main {

    public static void main(String[] args){

        Liquid l = new Liquid("Wein", 0.125, 13);
        System.out.println(l.getName());
        System.out.println(l.getVolume());

        Drink d = new SimpleDrink("Rotwein",l);
        System.out.println(d);

        Liquid anotherLiquid = new Liquid("Reiner Alkohol", 0.125, 99.9);
        Drink myDrink = new AlexDrink("Wonderful name", anotherLiquid);
        System.out.println(myDrink);

        FabiDrink cocktail = new FabiDrink("Long Island Ice Tea", new Liquid("Cola", 0.05, 0));
        cocktail.addLiquid(new Liquid("White Rum", 0.02, 39.9));
        cocktail.addLiquid(new Liquid("Vodka", 0.02, 39.9));
        cocktail.addLiquid(new Liquid("White Tequila", 0.02, 39.9));
        cocktail.addLiquid(new Liquid("Gin", 0.02, 39.9));
        cocktail.addLiquid(new Liquid("Triple Sec", 0.02, 37.9));
        cocktail.addLiquid(new Liquid("Lime juice", 0.01, 0));
        System.out.println(cocktail);

        Liquid beverage1 = new Liquid("Puntigamer",0.5,4.9);
        AdamsDrink beverage = new AdamsDrink("Puntigamer",beverage1);
        System.out.printf("%s has %s percent and the size is %s liter and is alcoholic is %b",beverage.toString(),beverage1.getAlcoholPercent(), beverage.getVolume(),beverage.isAlcoholic());

    }
}
