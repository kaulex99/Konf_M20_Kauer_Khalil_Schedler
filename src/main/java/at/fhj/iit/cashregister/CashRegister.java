package at.fhj.iit.cashregister;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO JavaDoc Fabi
public class CashRegister {
    private List<Transaction> transactions = new ArrayList<>();

    void sell(Buyable product, String seller, Date sellDate) {
        transactions.add(new Transaction(product, seller, sellDate));
    }

    double getNoneAlcoholicRevenue() {
        // TODO implement Fabi
        return 0;
    }

    /**
     * Total sales of low alcoholic drinks
     * @return lowAlcoholRevenue made with alcoholic drinks that are 16% or less
     */
    double getLowAlcoholicRevenue() {
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
     * @return highAlcoholRevenue made with alcoholic drinks that are higher than 16%
     */
    double getHighAlcoholicRevenue() {
        double highAlcoholRevenue = 0;
        for (Transaction t : transactions) {
            if (t.getProduct().getAlcoholPercent() > 16) {
                highAlcoholRevenue += t.getProduct().getPrice();
            }
        }
        return highAlcoholRevenue;
    }

    double getDayRevenue(Date day) {
        // TODO implement Alex
        return 0;
    }

    double getPersonRevenue(String name) {
        // TODO implement Alex
        return 0;
    }

    double getPersonDayRevenue(String name, Date day) {
        // TODO implement Alex
        return 0;
    }
}
