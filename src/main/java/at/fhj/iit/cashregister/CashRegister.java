package at.fhj.iit.cashregister;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO JavaDoc Fabi
public class CashRegister {
    private List<Transaction> transactions = new ArrayList<>();

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

    /**
     * Total sales filtered by date
     * @param day Date for filtering transactions
     * @return sum of filtered total sales
     */
    double getDayRevenue(Date day){
        double sum = 0;

        for (Transaction t: transactions) {
            if (isSameDate(t.getBuyDate(), day))
                sum += t.getProduct().getPrice();
        }

        return sum;
    }

    /**
     * Total sales filtered by person name
     * @param name Name for filtering transactions
     * @return sum of filtered total sales
     */
    double getPersonRevenue(String name){
        double sum = 0;

        for(Transaction t: transactions){
            if(t.getSellerName().equals(name))
                sum += t.getProduct().getPrice();
        }

        return sum;
    }

    /**
     * Total sales filtered by person name and date
     * @param name Name for filtering transactions
     * @param day Date for filtering transactions
     * @return sum of filtered total sales
     */
    double getPersonDayRevenue(String name, Date day){
        double sum = 0;

        for(Transaction t: transactions){
            if(t.getSellerName().equals(name) && isSameDate(t.getBuyDate(), day))
                sum += t.getProduct().getPrice();
        }

        return sum;
    }

    /**
     * Compare two dates and checks if they have the same day, month and year
     * @param dateOne any date for comparison
     * @param dateTwo any other date for comparisons
     * @return if they have the same day, month and year -> true/false
     */
    private boolean isSameDate(Date dateOne, Date dateTwo){
        LocalDate date1 = dateOne.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = dateTwo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return date1.isEqual(date2);
    }
}
