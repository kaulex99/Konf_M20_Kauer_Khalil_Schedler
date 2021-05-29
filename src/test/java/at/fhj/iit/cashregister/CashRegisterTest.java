package at.fhj.iit.cashregister;

import at.fhj.iit.FabiDrink;
import at.fhj.iit.Liquid;
import at.fhj.iit.SimpleDrink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

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