package at.fhj.iit;

import javax.crypto.AEADBadTagException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FabiDrink
 * Represents a wild mix of liquids
 */
public class FabiDrink extends Drink {

    protected ArrayList<Liquid> liquids = new ArrayList<>();
    /**
     * Creates a FabiDrink object with given name and a main liquid
     *
     * @param name name of drink
     * @param mainLiquid    the main liquid in the drink
     */
    FabiDrink(String name, Liquid mainLiquid) {
        super(name);
        this.liquids.add(mainLiquid);
    }

    FabiDrink(String name, Liquid ...liquids){
        super(name);
        this.liquids.addAll(Arrays.asList(liquids));
    }

    void addLiquid(Liquid l){
        this.liquids.add(l);
    }

    @Override
    public double getVolume() {
        double v = 0;

        for(Liquid l : liquids){
            v += l.getVolume();
        }
        return v;
    }

    @Override
    public double getAlcoholPercent() {
        double alcQuantity = 0;
        for(Liquid l : liquids){
            alcQuantity += l.getVolume() * l.getAlcoholPercent();
        }
        return alcQuantity * this.getVolume();
    }

    @Override
    public boolean isAlcoholic() {
        for(Liquid l : liquids){
           if(l.getAlcoholPercent() > 0){
               return true;
           }
        }
        return false;
    }
}
