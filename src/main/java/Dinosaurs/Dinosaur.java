package Dinosaurs;

public abstract class Dinosaur {

    protected String name;
    protected DietType dietType;
    protected int hungerLevel;
    protected double weightInTonnes;
    protected double lengthInFeet;

    public Dinosaur(String name, DietType dietType, int hungerLevel, double weightInTonnes, double lengthInFeet){
        this.name = name;
        this.dietType = dietType;
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

    public int getHungerLevel() {
        return this.hungerLevel;
    }

    public double getWeight() {
        return this.weightInTonnes;
    }

    public double getLengthInFeet() {
        return this.lengthInFeet;
    }

//    public int canEat(){
//        return this.hungerLevel - FoodType.getNutrition();
//    }

    public int changeHungerLevel(int hungerLevel){
        return this.hungerLevel += hungerLevel;
    }

    public int canEat(FoodType foodType) {
        return this.hungerLevel -= foodType.getNutriton();
    }
}

