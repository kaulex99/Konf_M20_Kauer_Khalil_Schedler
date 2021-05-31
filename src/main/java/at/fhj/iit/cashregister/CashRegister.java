package at.fhj.iit.cashregister;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * For selling the drinks and creating revenue reports
 *
 * @author Fabian Schedler, Alexander Kauer, Adam Khalil
 */
public class CashRegister {
    /**
     * List of all transactions made (contains all sold drinks)
     */
    private List<Transaction> transactions = new ArrayList<>();

    /**
     * Sells a drink (adds new transaction)
     * @param product product (drink) to sell
     * @param seller name of the seller (waiter)
     * @param sellDate date at which the product was sold
     */
    void sell(Buyable product, String seller, Date sellDate){
        transactions.add(new Transaction(product, seller, sellDate));
    }

    double getNoneAlcoholicRevenue(){
        // TODO implement Fabi
        return 0;
    }

    double getLowAlcoholicRevenue(){
        // TODO implement Adam
        return 0;
    }

    double getHighAlcoholicRevenue(){
        // TODO implement Adam
        return 0;
    }

    double getDayRevenue(Date day){
        // TODO implement Alex
        return 0;
    }

    double getPersonRevenue(String name){
        // TODO implement Alex
        return 0;
    }

    double getPersonDayRevenue(String name, Date day){
        // TODO implement Alex
        return 0;
    }

    /**
     * Number of sold items
     * @return number of transactions (sold drinks)
     */
    int getTransactionCount() {
        return transactions.size();
    }
}
