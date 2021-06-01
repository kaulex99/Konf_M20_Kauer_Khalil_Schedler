package at.fhj.iit.cashregister;

import java.util.Date;

/**
 * Simple Transaction for CashRegister class
 * needed to store product buying behaviour in CashRegister class
 * @author Fabian Schedler, Alexander Kauer, Adam Khalil
 * @version 1.0
 */
public class Transaction {
    private final Buyable product;
    private final String sellerName;
    private final Date buyDate;

    /**
     * Constructor to create a Transaction object
     * @param product instance of a buyable product i.e. any Drink
     * @param sellerName name of the sell
     * @param buyDate date, when the product was sold
     */
    public Transaction(Buyable product, String sellerName, Date buyDate) {
        this.product = product;
        this.sellerName = sellerName;
        this.buyDate = buyDate;
    }

    /**
     * @return the Buyable sold in this transaction
     */
    public Buyable getProduct() {
        return product;
    }

    /**
     * @return name of the seller as string
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * @return Date when the transaction was accomplished
     */
    public Date getBuyDate() {
        return buyDate;
    }
}
