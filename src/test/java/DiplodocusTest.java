import Dinosaurs.DietType;
import Dinosaurs.Diplodocus;
import Dinosaurs.FoodType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiplodocusTest {

    Diplodocus diplodocus;
    Diplodocus diplodocus2;

    @Before
    public void before() {

        diplodocus = new Diplodocus("Dippy", DietType.HERBIVORE, 10, 15.00, 90.00);
        diplodocus2 = new Diplodocus("Dave", DietType.HERBIVORE, 0, 15.00, 90.00);
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
        assertEquals(15, diplodocus.getWeightInTonnes(), 0.00);
    }

    @Test
    public void canGetLengthInFeet(){
        assertEquals(90, diplodocus.getLengthInFeet(), 0.00);
    }

    @Test
    public void canEatIfHungry(){
        diplodocus.canFeed(FoodType.PLANTS);
        assertEquals(9, diplodocus.getHungerLevel());
    }

    @Test
    public void canNotEatIfNotHungry(){
        diplodocus2.canFeed(FoodType.PLANTS);
        assertEquals(0, diplodocus2.getHungerLevel());
    }



}

