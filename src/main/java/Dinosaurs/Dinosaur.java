package Dinosaurs;

public abstract class Dinosaur {

    private String name;
    private DietType dietType;
    private int hungerLevel;
    private double weight;

    public Dinosaur(String name, DietType dietType, int hungerLevel, double weight){
        this.name = name;
        this.dietType = dietType;
        this.weight = weight;
    }

}
