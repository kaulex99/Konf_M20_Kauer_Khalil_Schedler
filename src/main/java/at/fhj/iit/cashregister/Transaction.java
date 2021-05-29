package at.fhj.iit.cashregister;

import java.util.Date;

// TODO JavaDoc Alex
public class Transaction {
    private final Buyable product;
    private final String sellerName;
    private final Date buyDate;

    public Transaction(Buyable product, String sellerName, Date buyDate) {
        this.product = product;
        this.sellerName = sellerName;
        this.buyDate = buyDate;
    }

    public Buyable getProduct() {
        return product;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Date getBuyDate() {
        return buyDate;
    }
}
