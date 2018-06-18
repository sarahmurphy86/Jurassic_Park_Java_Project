package Dinosaurs;

import Dinosaurs.Enums.Behaviours.IRampage;
import Dinosaurs.Enums.DietType;

public class Tyrannosaurus extends Dinosaur implements IRampage {

    public Tyrannosaurus(String name, int hungerLevel, double weightInTonnes, double lengthInFeet) {
        super(name, DietType.CARNIVORE, SpeciesType.TYRANNOSAURUS, hungerLevel, weightInTonnes, lengthInFeet);
    }

    public boolean isRampaging() {
        return this.hungerLevel >= 5;
    }


}
