/**
 * Author: Adam Khalil
 * Class that extends SimpleDrink
 * Date: 11.03.2021
 */

package at.fhj.iit;
/**
 * AdamsDrink is an extension of a simple drink and tastes better
 *
 */
public class AdamsDrink extends AlexDrink {

    AdamsDrink(String name, Liquid mainLiquid) {
        super(name, mainLiquid);
    }
    @Override
    public String toString() {
        return name;
    }


    @Override
    public double getVolume() {
        return super.getVolume()+1;
    }

    @Override
    public double getAlcoholPercent() {
        return super.getAlcoholPercent()/10;
    }

    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0;
    }

    /**
     * @return the price of this drink (depending on number of liquids)
     */
    @Override
    public double getPrice() {
        return 8.4;
    }
}
