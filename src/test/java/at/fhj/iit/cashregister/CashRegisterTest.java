package at.fhj.iit.cashregister;

import at.fhj.iit.AlexDrink;
import at.fhj.iit.Liquid;
import org.junit.jupiter.api.BeforeEach;
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
        // TODO @Alex
    }

    @Test
    void getPersonRevenue() {
        AlexDrink drink1 = new AlexDrink("TestDrink1", new Liquid("TestLiquid", 1.15, 20));
        cashRegister.sell(drink1, "Franz", new Date());
        cashRegister.sell(drink1, "Heinz", new Date());
        cashRegister.sell(drink1, "Adam", new Date());
        cashRegister.sell(drink1, "Fabi", new Date());
        cashRegister.sell(drink1, "Heinz", new Date());

        assertEquals(10.6, cashRegister.getPersonRevenue("Heinz"));
    }

    @Test
    void getPersonDayRevenue() {
        // TODO @Alex implement
    }
}