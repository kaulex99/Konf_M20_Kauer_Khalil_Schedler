package at.fhj.iit.cashregister;

import java.time.LocalDate;
import java.time.ZoneId;
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
     *
     * @param product  product (drink) to sell
     * @param seller   name of the seller (waiter)
     * @param sellDate date at which the product was sold
     */
    public void sell(Buyable product, String seller, Date sellDate) {
        transactions.add(new Transaction(product, seller, sellDate));
    }

    /**
     * Total sales of none alcoholic drinks
     *
     * @return revenue made with none alcoholic drinks
     */
    public double getNoneAlcoholicRevenue() {
        double revenue = 0;
        for (Transaction t : transactions) {
            if (!t.getProduct().isAlcoholic()) {
                revenue += t.getProduct().getPrice();
            }
        }
        return revenue;
    }

    /**
     * Total sales of low alcoholic drinks
     *
     * @return lowAlcoholRevenue made with alcoholic drinks that are 16% or less
     */
    public double getLowAlcoholicRevenue() {
        double lowAlcoholRevenue = 0;
        for (Transaction t : transactions) {
            if (t.getProduct().getAlcoholPercent() > 0 && t.getProduct().getAlcoholPercent() <= 16) {
                lowAlcoholRevenue += t.getProduct().getPrice();
            }
        }
        return lowAlcoholRevenue;
    }

    /**
     * Total sales of high alcoholic drinks
     *
     * @return highAlcoholRevenue made with alcoholic drinks that are higher than 16%
     */
    public double getHighAlcoholicRevenue() {
        double highAlcoholRevenue = 0;
        for (Transaction t : transactions) {
            if (t.getProduct().getAlcoholPercent() > 16) {
                highAlcoholRevenue += t.getProduct().getPrice();
            }
        }
        return highAlcoholRevenue;
    }

    /**
     * Total sales filtered by date
     *
     * @param day Date for filtering transactions
     * @return sum of filtered total sales
     */
    public double getDayRevenue(Date day) {
        double sum = 0;

        for (Transaction t : transactions) {
            if (isSameDate(t.getBuyDate(), day))
                sum += t.getProduct().getPrice();
        }

        return sum;
    }

    /**
     * Total sales filtered by person name
     *
     * @param name Name for filtering transactions
     * @return sum of filtered total sales
     */
    public double getPersonRevenue(String name) {
        double sum = 0;

        for (Transaction t : transactions) {
            if (t.getSellerName().equals(name))
                sum += t.getProduct().getPrice();
        }

        return sum;
    }

    /**
     * Total sales filtered by person name and date
     *
     * @param name Name for filtering transactions
     * @param day  Date for filtering transactions
     * @return sum of filtered total sales
     */
    public double getPersonDayRevenue(String name, Date day) {
        double sum = 0;

        for (Transaction t : transactions) {
            if (t.getSellerName().equals(name) && isSameDate(t.getBuyDate(), day))
                sum += t.getProduct().getPrice();
        }

        return sum;
    }

    /**
     * Compare two dates and checks if they have the same day, month and year
     *
     * @param dateOne any date for comparison
     * @param dateTwo any other date for comparisons
     * @return if they have the same day, month and year -> true/false
     */
    private boolean isSameDate(Date dateOne, Date dateTwo) {
        LocalDate date1 = dateOne.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = dateTwo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return date1.isEqual(date2);
    }

    /**
     * Number of sold items
     *
     * @return number of transactions (sold drinks)
     */
    public int getTransactionCount() {
        return transactions.size();
    }
}
