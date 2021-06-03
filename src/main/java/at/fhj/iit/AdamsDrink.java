package at.fhj.iit;

/**
 * AdamsDrink is an extension of AlexDrink and changes some values
 *
 * @author Adam Khalil
 * @version 1.0
 */
public class AdamsDrink extends AlexDrink {

    public AdamsDrink(String name, Liquid mainLiquid) {
        super(name, mainLiquid);
    }

    /**
     * Gives the volume of a drink and adds 1
     * @return the volume of a drink
     */
    @Override
    public double getVolume() {
        return super.getVolume() + 1;
    }

    /**
     * Gets you the alcohol percentage and divides it with 10
     * @return alcohol percentage
     */
    @Override
    public double getAlcoholPercent() {
        return super.getAlcoholPercent() / 10;
    }

    /**
     * Checks if the alcohol percentage is over 0%
     * @return if it is alcoholic or not
     */
    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0;
    }

    /**
     * returns value of the price for each drink which is 8.4
     * @return the price of this drink
     */
    @Override
    public double getPrice() {
        return 8.4;
    }

    /**
     * returns the name of the drink
     * @return name of the drink
     */
    @Override
    public String toString() {
        return name;
    }
}
