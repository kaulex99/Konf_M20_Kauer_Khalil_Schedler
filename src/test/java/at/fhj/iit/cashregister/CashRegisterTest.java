package at.fhj.iit.cashregister;

import at.fhj.iit.AlexDrink;
import at.fhj.iit.FabiDrink;
import at.fhj.iit.Liquid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Adam Khalil, Alexander Kauer, Fabian Schedler
 * @version 1.0
 * @see CashRegister
 */
class CashRegisterTest {

    private CashRegister cashRegister;

    @BeforeEach
    void setUp() {
        cashRegister = new CashRegister();
    }

    @Test
    void sell() {
        // TODO @Fabian implement
    }

    @Test
    void getNoneAlcoholicRevenue() {
        // TODO @Fabian implement
    }

    @Test
    void getLowAlcoholicRevenue() {
        // TODO @Adam implement
    }

    @Test
    void getHighAlcoholicRevenue() {
        // TODO @Adam implement
    }

    /**
     * Test CashRegister.getDayRevenue method
     */
    @Test
    @DisplayName("Get day revenue")
    void getDayRevenue() {
        FabiDrink cocktail = new FabiDrink("Long Island Ice Tea", new Liquid("Cola", 0.05, 0));
        cocktail.addLiquid(new Liquid("White Rum", 0.02, 39.9));
        Date today = Date.from(LocalDate.now(ZoneId.systemDefault()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date otherDay = Date.from(LocalDate.of(2021, 5, 29).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        cashRegister.sell(cocktail, "Test2", today);
        cashRegister.sell(cocktail, "Test1", otherDay);
        cashRegister.sell(cocktail, "Test2", today);
        cashRegister.sell(cocktail, "Test2", otherDay);

        assertEquals(cocktail.getPrice()*2, cashRegister.getDayRevenue(otherDay));
    }

    /**
     * Test CashRegister.getPersonRevenue method
     */
    @Test
    @DisplayName("Get person revenue")
    void getPersonRevenue() {
        AlexDrink drink1 = new AlexDrink("TestDrink1", new Liquid("TestLiquid", 1.15, 20));
        cashRegister.sell(drink1, "Franz", new Date());
        cashRegister.sell(drink1, "Heinz", new Date());
        cashRegister.sell(drink1, "Adam", new Date());
        cashRegister.sell(drink1, "Fabi", new Date());
        cashRegister.sell(drink1, "Heinz", new Date());

        assertEquals(drink1.getPrice()*2, cashRegister.getPersonRevenue("Heinz"));
    }

    /**
     * Test CashRegister.getPersonDayRevenue method
     */
    @Test
    @DisplayName("Get person and day revenue")
    void getPersonDayRevenue() {
        AlexDrink drink1 = new AlexDrink("TestDrink1", new Liquid("TestLiquid", 1.15, 20));
        Date today = Date.from(LocalDate.now(ZoneId.systemDefault()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date otherDay = Date.from(LocalDate.of(2021, 5, 29).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        cashRegister.sell(drink1, "Franz", otherDay);
        cashRegister.sell(drink1, "Heinz", otherDay);
        cashRegister.sell(drink1, "Adam",today);
        cashRegister.sell(drink1, "Fabi", today);
        cashRegister.sell(drink1, "Heinz", today);

        assertEquals(drink1.getPrice(), cashRegister.getPersonDayRevenue("Heinz", otherDay));
    }
}