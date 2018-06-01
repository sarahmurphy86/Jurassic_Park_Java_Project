import Dinosaurs.DietType;
import Dinosaurs.Diplodocus;
import Dinosaurs.FoodType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiplodocusTest {

    Diplodocus diplodocus;

    @Before
    public void before() {

        diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, 10, 15.00, 90.00);

    }

    @Test
    public void canGetName(){
        assertEquals("Dippy", diplodocus.getName());
    }

    @Test
    public void canGetDietType() {
        assertEquals(DietType.HERBIVORE, diplodocus.getDietType());
    }

    @Test
    public void canGetHungerLevel() {
        assertEquals(10, diplodocus.getHungerLevel());
    }

    @Test
    public void canGetWeight(){
        assertEquals(15, diplodocus.getWeight(), 0.00);
    }

    @Test
    public void canGetLengthInFeet(){
        assertEquals(90, diplodocus.getLengthInFeet(), 0.00);
    }

    @Test
    public void canIncreaseHungerLevel(){
        diplodocus.canEat(FoodType.CHICKEN);
        assertEquals(12, diplodocus.getHungerLevel());
    }

    @Test
    public void canDecreaseHungerLevel(){
        diplodocus.canEat(FoodType.PLANTS);
        assertEquals(9, diplodocus.getHungerLevel());
    }


}

