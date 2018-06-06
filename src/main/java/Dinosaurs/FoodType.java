package Dinosaurs;

public enum FoodType {

    PARKRANGER(5),
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
