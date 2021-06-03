package at.fhj.iit.cashregister;

import at.fhj.iit.Liquid;
import at.fhj.iit.AlexDrink;
import at.fhj.iit.FabiDrink;
import at.fhj.iit.SimpleDrink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests CashRegister implementation
 *
 * @author Adam Khalil, Alexander Kauer, Fabian Schedler
 * @version 1.0
 * @see CashRegister
 */
class CashRegisterTest {

    /**
     * Instance for tests (system under test)
     */
    private CashRegister cashRegister;

    /**
     * Create fresh CashRegister instance for each test
     */
    @BeforeEach
    void setUp() {
        cashRegister = new CashRegister();
    }

    /**
     * Test if CashRegister.sell method adds a transaction
     */
    @Test
    @DisplayName("Check if sell adds transactions")
    void sell() {
        assertEquals(0, cashRegister.getTransactionCount());

        Buyable drink = new SimpleDrink("Drink", new Liquid("Liquid", 0.5, 5));
        Date now = new Date();

        cashRegister.sell(drink, "Fabian", now);

        assertEquals(1, cashRegister.getTransactionCount());

        cashRegister.sell(drink, "Alex", now);
        cashRegister.sell(drink, "Fabian", now);
        cashRegister.sell(drink, "Adam", now);

        assertEquals(4, cashRegister.getTransactionCount());
    }

    /**
     * Test CashRegister.getNoneAlcoholicRevenue method
     */
    @Test
    @DisplayName("Check non alcoholic revenue")
    void getNoneAlcoholicRevenue() {
        assertEquals(0, cashRegister.getNoneAlcoholicRevenue());

        Date now = new Date();
        Buyable noneAlcoholic = new SimpleDrink("noAlc", new Liquid("Cola", 0.5, 0));
        Buyable alcoholic = new FabiDrink("Alc", new Liquid("Whisky", 0.02, 40));

        cashRegister.sell(alcoholic, "Fabian", now);

        assertEquals(0, cashRegister.getNoneAlcoholicRevenue());

        cashRegister.sell(noneAlcoholic, "Fabian", now);
        cashRegister.sell(noneAlcoholic, "Fabian", now);

        assertEquals(noneAlcoholic.getPrice() * 2, cashRegister.getNoneAlcoholicRevenue());
    }

    /**
     * Tests if the revenue is correct for alcoholic drinks that are less or equal 16%
     */
    @Test
    @DisplayName("Check low alcoholic revenue")
    void getLowAlcoholicRevenue() {
        assertEquals(0, cashRegister.getLowAlcoholicRevenue());

        Date now = new Date();
        Buyable nonAlcoholic1 = new SimpleDrink("noAlc", new Liquid("Cola", 0.5, 0));
        Buyable nonAlcoholic2 = new SimpleDrink("noAlc", new Liquid("Fanta", 0.5, 0));
        Buyable lowAlcoholic1 = new SimpleDrink("lowAlc", new Liquid("Bier", 0.5, 5));
        Buyable lowAlcoholic2 = new SimpleDrink("lowAlc", new Liquid("Wein", 0.5, 10));
        Buyable highAlcoholic1 = new SimpleDrink("highAlc", new Liquid("Schnaps", 0.5, 20));


        cashRegister.sell(nonAlcoholic1, "Adam", now);
        cashRegister.sell(nonAlcoholic2, "Adam", now);
        cashRegister.sell(highAlcoholic1, "Adam", now);

        assertEquals(0, cashRegister.getLowAlcoholicRevenue());

        cashRegister.sell(lowAlcoholic1, "Adam", now);
        cashRegister.sell(lowAlcoholic2, "Adam", now);

        assertEquals(lowAlcoholic1.getPrice() + lowAlcoholic2.getPrice(), cashRegister.getLowAlcoholicRevenue());
    }

    /**
     * Tests if the revenue is correct for alcoholic drinks over 16%
     */
    @Test
    @DisplayName("Check high alcoholic revenue")
    void getHighAlcoholicRevenue() {
        assertEquals(0, cashRegister.getHighAlcoholicRevenue());

        Date now = new Date();
        Buyable nonAlcoholic1 = new SimpleDrink("noAlc", new Liquid("Cola", 0.5, 0));
        Buyable nonAlcoholic2 = new SimpleDrink("noAlc", new Liquid("Fanta", 0.5, 0));
        Buyable lowAlcoholic1 = new SimpleDrink("lowAlc", new Liquid("Bier", 0.5, 5));
        Buyable lowAlcoholic2 = new SimpleDrink("lowAlc", new Liquid("Wein", 0.5, 10));
        Buyable highAlcoholic1 = new SimpleDrink("highAlc", new Liquid("Schnaps", 0.5, 20));
        Buyable highAlcoholic2 = new SimpleDrink("highAlc", new Liquid("Vodka", 0.5, 40));


        cashRegister.sell(nonAlcoholic1, "Adam", now);
        cashRegister.sell(nonAlcoholic2, "Adam", now);
        cashRegister.sell(lowAlcoholic1, "Adam", now);
        cashRegister.sell(lowAlcoholic2, "Adam", now);


        assertEquals(0, cashRegister.getHighAlcoholicRevenue());

        cashRegister.sell(highAlcoholic1, "Adam", now);
        cashRegister.sell(highAlcoholic2, "Adam", now);

        assertEquals(highAlcoholic1.getPrice() + highAlcoholic2.getPrice(), cashRegister.getHighAlcoholicRevenue());
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

        assertEquals(cocktail.getPrice() * 2, cashRegister.getDayRevenue(otherDay));
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

        assertEquals(drink1.getPrice() * 2, cashRegister.getPersonRevenue("Heinz"));
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
        cashRegister.sell(drink1, "Adam", today);
        cashRegister.sell(drink1, "Fabi", today);
        cashRegister.sell(drink1, "Heinz", today);

        assertEquals(drink1.getPrice(), cashRegister.getPersonDayRevenue("Heinz", otherDay));
    }
}