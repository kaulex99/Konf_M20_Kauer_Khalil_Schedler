package at.fhj.iit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fabian Schedler
 * @version 1.0
 * @since 2021-04-15
 */
@DisplayName("Testing FabiDrink implementation")
class FabiDrinkTest {

    private FabiDrink sut;

    @BeforeEach
    void setUp() {
        this.sut = new FabiDrink("TestDrink");
    }

    @ParameterizedTest
    @DisplayName("Testing add Liquid")
    @ValueSource(ints = {0, 5, 10, 13})
    void addLiquid(int count) {
        for (int i = 0; i < count; i++) {
            this.sut.addLiquid(new Liquid("Liquid" + i, 0.1, 50));
        }

        assertEquals(count, this.sut.liquids.size());
    }

    @Test
    @DisplayName("Testing volume")
    void getVolume() {
        assertEquals(this.sut.getVolume(), 0);

        this.sut.addLiquid(new Liquid("Liquid1", 0.1, 50));
        this.sut.addLiquid(new Liquid("Liquid2", 0.25, 0));
        this.sut.addLiquid(new Liquid("Liquid3", 0.15, 20));

        assertEquals(0.5, this.sut.getVolume(), 0.0001);
    }

    @Test
    @DisplayName("Testing alcohol percentage calculation")
    void getAlcoholPercent() {
        assertEquals(0, this.sut.getAlcoholPercent());

        this.sut.addLiquid(new Liquid("Liquid1", 0.100, 50));
        assertEquals(50, this.sut.getAlcoholPercent(), 0.0001);

        this.sut.addLiquid(new Liquid("Liquid2", 0.100, 0));
        assertEquals(25, this.sut.getAlcoholPercent(), 0.0001);
    }

    @Test
    @DisplayName("Testing is alcoholic")
    void isAlcoholic() {
        assertFalse(this.sut.isAlcoholic());

        this.sut.addLiquid(new Liquid("L1", 100, 10));
        assertTrue(this.sut.isAlcoholic());

        this.sut.addLiquid(new Liquid("L2", 100, 0));
        assertTrue(this.sut.isAlcoholic());
    }

    @Test
    @DisplayName("Testing is not alcoholic")
    void isNotAlcoholic() {
        assertFalse(this.sut.isAlcoholic());

        this.sut.addLiquid(new Liquid("L1", 0.1, 0));
        assertFalse(this.sut.isAlcoholic());
    }

    @Test
    @DisplayName("Testing toString format")
    void testToString() {
        this.sut.addLiquid(new Liquid("L1", 0.1, 38));
        this.sut.addLiquid(new Liquid("L2", 0.25, 85));
        this.sut.addLiquid(new Liquid("L3", 1.2, 0));

        assertEquals("TestDrink has 16,16% and contains:\n" +
                "\t- 0.1 l of L1 (38.0%)\n" +
                "\t- 0.25 l of L2 (85.0%)\n" +
                "\t- 1.2 l of L3 (0.0%)\n",
                this.sut.toString());
    }

    @Test
    @DisplayName("Testing constructor with name")
    void nameConstructor() {
        FabiDrink drink = new FabiDrink("TestName");

        assertEquals("TestName", drink.name);
        assertEquals(0, drink.liquids.size());
    }

    @Test
    @DisplayName("Testing constructor with main Liquid")
    void mainLiquidConstructor() {
        FabiDrink drink = new FabiDrink("TestDrink", new Liquid("L1", 0.1, 10));

        assertEquals(1, drink.liquids.size());
        assertEquals("TestDrink", drink.name);
    }

    @Test
    @DisplayName("Testing constructor with Liquid list")
    void liquidListConstructor() {
        List<Liquid> liquids = new ArrayList<>();

        liquids.add(new Liquid("L1", 100, 10));
        liquids.add(new Liquid("L2", 100, 10));
        liquids.add(new Liquid("L3", 100, 10));

        FabiDrink drink = new FabiDrink("TestDrink", liquids);

        assertEquals(3, drink.liquids.size());
        assertEquals("TestDrink", drink.name);
    }
}