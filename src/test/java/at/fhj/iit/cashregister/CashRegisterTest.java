package at.fhj.iit.cashregister;

import at.fhj.iit.Liquid;
import at.fhj.iit.SimpleDrink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests CashRegister implementation
 *
 * @author Fabian Schedler, Alexander Kauer, Adam Khalil
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

    @Test
    void getDayRevenue() {
        // TODO @Alex implement
    }

    @Test
    void getPersonRevenue() {
        // TODO @Alex implement
    }

    @Test
    void getPersonDayRevenue() {
        // TODO @Alex implement
    }
}