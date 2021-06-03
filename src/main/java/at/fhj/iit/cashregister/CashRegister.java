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

    double getNoneAlcoholicRevenue(){
        // TODO implement Fabi
        return 0;
    }

    /**
     * Total sales of low alcoholic drinks
     * @return lowAlcoholRevenue made with alholic drinks that are 16% or less
     */
    double getLowAlcoholicRevenue(){
        double lowAlcoholRevenue = 0;
        for (Transaction t : transactions){
            if(t.getProduct().isAlcoholic() && t.getProduct().getAlcoholPercentage()<=16) {
                lowAlcoholRevenue += t.getProduct().getPrice();
            }
        }
        return lowAlcoholRevenue;
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
