import Dinosaurs.DietType;
import Dinosaurs.FoodType;
import Dinosaurs.SpeciesType;
import Dinosaurs.Tyrannosaurus;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TyrannosaurusTest {
    Tyrannosaurus tyrannosaurus1;
    Tyrannosaurus tyrannosaurus2;

    @Before
    public void before() {

        tyrannosaurus1 = new Tyrannosaurus("Teddy",5, 10.00, 40.00);
        tyrannosaurus2 = new Tyrannosaurus("Teddy", 2, 11.00, 43.00);

    }

    @Test
    public void canGetName(){
        assertEquals("Teddy", tyrannosaurus1.getName());
    }

    @Test
    public void canGetDietType() {
        assertEquals(DietType.CARNIVORE, tyrannosaurus1.getDietType());
    }

    @Test
    public void canGetSpeciesType() {
        assertEquals(SpeciesType.TYRANNOSAURUS, tyrannosaurus1.getSpeciesType());
    }

    @Test
    public void canGetHungerLevel() {
        assertEquals(5, tyrannosaurus1.getHungerLevel());
    }

    @Test
    public void canGetWeight(){
        assertEquals(10, tyrannosaurus1.getWeightInTonnes(), 0.00);
    }

    @Test
    public void canGetLengthInFeet(){
        assertEquals(40, tyrannosaurus1.getLengthInFeet(), 0.00);
    }

    @Test
    public void canEat(){
        tyrannosaurus1.canFeed(FoodType.DINOBISCUITS);
        assertEquals(2, tyrannosaurus1.getHungerLevel());
    }

    @Test
    public void canNotHaveMinusHungerLevel(){
        tyrannosaurus2.canFeed(FoodType.PARKRANGER);
        assertEquals(0, tyrannosaurus2.getHungerLevel());
    }

    @Test
    public void isRampaging__true(){
        assertEquals(true, tyrannosaurus1.isRampaging());
    }

    @Test
    public void isRampaging__false(){
        assertEquals(false, tyrannosaurus2.isRampaging());
    }

}

