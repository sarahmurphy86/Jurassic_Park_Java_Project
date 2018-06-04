import Dinosaurs.DietType;
import Dinosaurs.FoodType;
import Dinosaurs.Tyrannosaurus;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TyrannosaurusTest {
    Tyrannosaurus tyrannosaurus;

    @Before
    public void before() {

        tyrannosaurus = new Tyrannosaurus("Teddy", DietType.CARNIVORE, 5, 10.00, 40.00);

    }

    @Test
    public void canGetName(){
        assertEquals("Teddy", tyrannosaurus.getName());
    }

    @Test
    public void canGetDietType() {
        assertEquals(DietType.CARNIVORE, tyrannosaurus.getDietType());
    }

    @Test
    public void canGetHungerLevel() {
        assertEquals(5, tyrannosaurus.getHungerLevel());
    }

    @Test
    public void canGetWeight(){
        assertEquals(10, tyrannosaurus.getWeightInTonnes(), 0.00);
    }

    @Test
    public void canGetLengthInFeet(){
        assertEquals(40, tyrannosaurus.getLengthInFeet(), 0.00);
    }

    @Test
    public void canEatIfHungry(){
        tyrannosaurus.canFeed(FoodType.DINOBISCUITS);
        assertEquals(2, tyrannosaurus.getHungerLevel());
    }

}

