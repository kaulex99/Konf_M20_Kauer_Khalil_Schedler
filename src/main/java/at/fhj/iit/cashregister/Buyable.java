package at.fhj.iit.cashregister;

/**
 * @author Adam Khalil
 * @version 1.0
 */

public interface Buyable {
    double getPrice();
    boolean isAlcoholic();
    double getAlcoholPercent();
}
