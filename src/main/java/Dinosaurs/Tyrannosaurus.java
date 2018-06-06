package Dinosaurs;

public class Tyrannosaurus extends Dinosaur implements IRampage{

    public Tyrannosaurus(String name, int hungerLevel, double weightInTonnes, double lengthInFeet) {
        super(name, DietType.CARNIVORE, SpeciesType.TYRANNOSAURUS, hungerLevel, weightInTonnes, lengthInFeet);
    }

//    Version 1
//    return this.hungerLevel >=5 rather than if statement - look at this when re-factoring.
//    public boolean isRampaging() {
//        if (this.hungerLevel >= 5) {
//            return true;
//        }
//        else return false;
//    }
//  Version 2
    public boolean isRampaging() {
        return this.hungerLevel >= 5;
    }



}
