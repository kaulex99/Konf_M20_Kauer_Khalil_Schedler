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
        return super.getVolume();
    }

    @Override
    public double getAlcoholPercent() {
        return super.getAlcoholPercent();
    }

    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0;
    }
}
