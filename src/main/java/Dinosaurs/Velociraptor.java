package Dinosaurs;

import Dinosaurs.Enums.DietType;

public class Velociraptor extends Dinosaur{

    public Velociraptor(String name, int hungerLevel, double weightInTonnes, double lengthInFeet) {
        super(name, DietType.CARNIVORE, SpeciesType.VELOCIRAPTOR, hungerLevel, weightInTonnes, lengthInFeet);
    }
}
