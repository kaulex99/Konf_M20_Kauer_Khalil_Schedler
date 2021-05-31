package at.fhj.iit.cashregister;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO JavaDoc Fabi
public class CashRegister {
    private List<Transaction> transactions = new ArrayList<>();

    void sell(Buyable product, String seller, Date sellDate){
        transactions.add(new Transaction(product, seller, sellDate));
    }

    /**
     * Total sales of none alcoholic drinks
     * @return revenue made with none alcoholic drinks
     */
    double getNoneAlcoholicRevenue(){
        double revenue = 0;
        for (Transaction t : transactions){
            if(!t.getProduct().isAlcoholic()) {
                revenue += t.getProduct().getPrice();
            }
        }
        return revenue;
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
}
