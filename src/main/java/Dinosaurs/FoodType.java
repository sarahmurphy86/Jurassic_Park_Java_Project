package Dinosaurs;

public enum FoodType {

    DINOBISCUITS(3),
    CHICKEN(2),
    PLANTS(1);

    private final int nutrition;

    FoodType(int nutrition){
        this.nutrition = nutrition;
    }

    public int getNutriton(){
        return this.nutrition;
    }

}
