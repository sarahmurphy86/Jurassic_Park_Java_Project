package Dinosaurs;

import Dinosaurs.Enums.DietType;
import Dinosaurs.Enums.FoodType;

public abstract class Dinosaur {

    private String name;
    private DietType dietType;
    private SpeciesType speciesType;
    protected int hungerLevel;
    private double weightInTonnes;
    private double lengthInFeet;

    public Dinosaur(String name, DietType dietType, SpeciesType speciesType, int hungerLevel, double weightInTonnes, double lengthInFeet) {
        this.name = name;
        this.dietType = dietType;
        this.speciesType = speciesType;
        this.hungerLevel = hungerLevel;
        this.weightInTonnes = weightInTonnes;
        this.lengthInFeet = lengthInFeet;
    }

    public String getName() {
        return this.name;
    }

    public DietType getDietType() {
        return this.dietType;
    }

    public SpeciesType getSpeciesType() {
        return this.speciesType;
    }

    public int getHungerLevel() {
        return this.hungerLevel;
    }

    public double getWeightInTonnes() {
        return this.weightInTonnes;
    }

    public double getLengthInFeet() {
        return this.lengthInFeet;
    }

    public int canFeed(FoodType foodType) {
        int newHunger = this.hungerLevel - foodType.getNutriton();

            if (newHunger < 0) {
                this.hungerLevel = 0;
                return this.hungerLevel;
            }

            else if (newHunger >= 0) {
                this.hungerLevel = newHunger;
            }
                return this.hungerLevel;
    }

}






