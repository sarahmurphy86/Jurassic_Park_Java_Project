import Dinosaurs.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiplodocusTest {

    Dinosaur diplodocus;
    Diplodocus diplodocus2;

    @Before
    public void before() {

        diplodocus = new Diplodocus("Dippy", 10, 15.00, 90.00);
        diplodocus2 = new Diplodocus("Dave",  1, 15.00, 90.00);
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
    public void canGetSpeciesType(){
        assertEquals(SpeciesType.DIPLODOCUS, diplodocus.getSpeciesType());
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
    public void canEat(){
        diplodocus.canFeed(FoodType.PLANTS);
        assertEquals(9, diplodocus.getHungerLevel());
    }

    @Test
    public void canNotHaveAMinusHungerValue() {
        diplodocus2.canFeed(FoodType.DINOBISCUITS);
        assertEquals(0, diplodocus2.getHungerLevel());
    }






}

