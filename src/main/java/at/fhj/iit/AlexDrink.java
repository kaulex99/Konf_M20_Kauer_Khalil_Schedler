package at.fhj.iit;

/**
 * @author Alexander Kauer
 * @version 1.0
 */
public class AlexDrink extends FabiDrink {

    /**
     * Initialize an AlexDrink
     * @param name Name of the drink
     * @param mainLiquid Main type of liquid
     */
    public AlexDrink(String name, Liquid mainLiquid) {
        super(name, mainLiquid);
    }

    /**
     * @return the current amount of alcohol in % (min. 40%)
     */
    @Override
    public double getAlcoholPercent() {
        return Math.max(40, super.getAlcoholPercent());
    }

    /**
     * @return as the drink has always min 40% of alcohol - it is alcoholic
     */
    @Override
    public boolean isAlcoholic() {
        return true;
    }

    /**
     * @return formatted String with all necessary information
     */
    @Override
    public String toString() {
        return name + " has " + getAlcoholPercent() + "%";
    }

    /**
     * @return the price of this drink (depending on number of liquids)
     */
    @Override
    public double getPrice() {
        return 5.3;
    }
}
