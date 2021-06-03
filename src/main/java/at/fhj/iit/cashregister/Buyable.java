package at.fhj.iit.cashregister;

/**
 * Buyable interface to inherit  methods for the Revenues
 * @author Adam Khalil
 * @version 1.0
 */

public interface Buyable {

    /**
     * Gets the prices of the drinks
     * @return the price of a drink depending on which class it heritages from
     */
    double getPrice();

    /**
     * Gets the information if it is alcoholic or not
     * @return if it is alcoholic or not
     */
    boolean isAlcoholic();

    /**
     * Gets the information about the alcohol percentage
     * @return alcohol percentage of a drink based on which class it heritages from
     */
    double getAlcoholPercent();
}
