package at.fhj.iit;

public class AlexDrink extends FabiDrink {
    AlexDrink(String name, Liquid mainLiquid) {
        super(name, mainLiquid);
    }

    @Override
    public String toString() {
        return name + " has " + getAlcoholPercent() + "%";
    }
}
