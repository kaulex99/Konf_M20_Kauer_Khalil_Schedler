package at.fhj.iit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Adam Khalil
 * @version 1.0
 * @see AdamsDrink
 */

class AdamsDrinkTest {

    private AdamsDrink drink;

    @BeforeEach
    void setUp() {
        Liquid liquid = new Liquid("beverage", 6, 10);
        drink = new AdamsDrink("drinkName", liquid);

    }

    @AfterEach
    void tearDown() {
        drink = null;
        //add other teardown logic if necessary

    }

    @Test
    @DisplayName("Check if the alcohol percentage calculation works correctly")
    void AlcoholPercent() {
        assertEquals(4, drink.getAlcoholPercent());
    }

    @Test
    @DisplayName("Verify that the to string only returns the name")
    void testToString() {
        assertEquals("drinkName", drink.toString());
    }

    @Test
    @DisplayName("Check if one gets added to the volume")
    void getVolume() {
        assertEquals(7, drink.getVolume());
    }

    @Test
    @DisplayName("Check if the drink is alcoholic")
    void isAlcoholic() {
        assertTrue(drink.isAlcoholic());
    }

}