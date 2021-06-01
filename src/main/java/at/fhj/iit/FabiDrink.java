package at.fhj.iit;

import java.util.ArrayList;
import java.util.List;

/**
 * FabiDrink
 * Represents a wild mix of liquids
 *
 * @author Fabian Schedler
 * @version 1.1
 */
public class FabiDrink extends Drink {

    /**
     * List of liquids in the drink
     */
    protected List<Liquid> liquids = new ArrayList<>();

    /**
     * Creates a FabiDrink object with given name
     *
     * @param name       name of drink
     */
    FabiDrink(String name){
        super(name);
    }

    /**
     * Creates a FabiDrink object with given name and a main liquid
     *
     * @param name       name of drink
     * @param mainLiquid the main liquid in the drink
     */
    public FabiDrink(String name, Liquid mainLiquid) {
        super(name);
        this.liquids.add(mainLiquid);
    }

    /**
     * Creates a FabiDrink object with given name and liquids
     *
     * @param name    name of drink
     * @param liquids liquids contained in the drink
     */
    FabiDrink(String name, List<Liquid> liquids) {
        super(name);
        this.liquids.addAll(liquids);
    }

    /**
     * adds a new liquid to the drink
     *
     * @param l liquid to add
     */
    public void addLiquid(Liquid l) {
        this.liquids.add(l);
    }

    /**
     * @return volume of the whole drink
     */
    @Override
    public double getVolume() {
        double v = 0;

        for (Liquid l : liquids) {
            v += l.getVolume();
        }
        return v;
    }

    /**
     * @return the alcohol percentage of the whole drink
     */
    @Override
    public double getAlcoholPercent() {
        if (this.getVolume() <= 0) return 0;

        double alcQuantity = 0;
        for (Liquid l : liquids) {
            alcQuantity += l.getVolume() * l.getAlcoholPercent();
        }
        return alcQuantity / this.getVolume();
    }

    /**
     * @return if the drink is alcoholic
     */
    @Override
    public boolean isAlcoholic() {
        for (Liquid l : liquids) {
            if (l.getAlcoholPercent() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return formatted recipe
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(name)
                .append(" has ").append(String.format("%.2f", this.getAlcoholPercent())).append("% and contains:\n");

        for (Liquid l : liquids) {
            s.append("\t- ")
                    .append(l.getVolume()).append(" l")
                    .append(" of ")
                    .append(l.getName())
                    .append(" (").append(l.getAlcoholPercent()).append("%)")
                    .append("\n");
        }

        return s.toString();
    }

    /**
     * @return the price of this drink (depending on number of liquids)
     */
    @Override
    public double getPrice() {
        return liquids.size() * 1.3;
    }
}
