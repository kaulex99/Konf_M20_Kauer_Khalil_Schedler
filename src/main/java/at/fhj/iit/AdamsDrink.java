

package at.fhj.iit;

/**
 * AdamsDrink is an extension of AlexDrink
 *
 * @Author: Adam Khalil
 * @Version: 1.0
 */

public class AdamsDrink extends AlexDrink {

    public AdamsDrink(String name, Liquid mainLiquid) {
        super(name, mainLiquid);
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public double getVolume() {
        return super.getVolume() + 1;
    }

    @Override
    public double getAlcoholPercent() {
        return super.getAlcoholPercent() / 10;
    }

    @Override
    public boolean isAlcoholic() {
        return getAlcoholPercent() > 0;
    }

    @Override
    public double getPrice() {
        return 8.4;
    }
}
