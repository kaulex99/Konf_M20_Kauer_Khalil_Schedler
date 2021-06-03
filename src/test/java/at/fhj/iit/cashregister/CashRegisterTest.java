package at.fhj.iit.cashregister;

import at.fhj.iit.AdamsDrink;
import at.fhj.iit.Liquid;
import at.fhj.iit.SimpleDrink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

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