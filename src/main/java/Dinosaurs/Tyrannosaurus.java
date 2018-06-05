package Dinosaurs;

public class Tyrannosaurus extends Dinosaur implements IRampage{

    public Tyrannosaurus(String name, DietType dietType, SpeciesType speciesType, int hungerLevel, double weightInTonnes, double lengthInFeet) {
        super(name, dietType, speciesType, hungerLevel, weightInTonnes, lengthInFeet);
    }

    public boolean canRampage() {
        if (this.hungerLevel <= 5) {
            return true;
        }
        else return false;
    }
}
