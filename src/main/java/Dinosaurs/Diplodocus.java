package Dinosaurs;

import Dinosaurs.Enums.DietType;

public class Diplodocus extends Dinosaur {


    public Diplodocus(String name, int hungerLevel, double weightInTonnes, double lengthInFeet) {
        super(name, DietType.HERBIVORE, SpeciesType.DIPLODOCUS, hungerLevel, weightInTonnes, lengthInFeet);
    }

}
