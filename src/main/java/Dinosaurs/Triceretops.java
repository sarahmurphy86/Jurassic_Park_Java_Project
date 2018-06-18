package Dinosaurs;

import Dinosaurs.Enums.DietType;

public class Triceretops extends Dinosaur {

    public Triceretops(String name, int hungerLevel, double weightInTonnes, double lengthInFeet) {
        super(name, DietType.HERBIVORE, SpeciesType.TRICERATOPS, hungerLevel, weightInTonnes, lengthInFeet);
    }
}
