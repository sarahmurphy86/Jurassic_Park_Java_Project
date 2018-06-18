package Paddocks;

import Dinosaurs.Enums.DietType;
import Dinosaurs.Dinosaur;
import java.util.ArrayList;


public class Paddock {
    private String name;
    private int capacity;
    public ArrayList<Dinosaur> dinosaurList;


    public Paddock(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.dinosaurList = new ArrayList<>();
    }

    public String getPaddockName() {
        return this.name;
    }

    public int getPaddockCapacity() {
        return this.capacity;
    }

    public int dinosaurListCount() {
        return this.dinosaurList.size();
    }

    public void addDinosaur(Dinosaur dinosaur){
        if (this.dinosaurList.size()== 0){
            dinosaurList.add(dinosaur);
        }

        else if ((this.dinosaurList.size()< this.capacity) && (dinosaurList.get(0).getDietType() == DietType.HERBIVORE)  &&
                (dinosaur.getDietType() != DietType.CARNIVORE)){
            dinosaurList.add(dinosaur);
        }

        else if ((this.dinosaurList.size()< this.capacity) && (dinosaurList.get(0).getSpeciesType() == dinosaur.getSpeciesType())) {
            dinosaurList.add(dinosaur);
        }
        else return;
   }

    public Dinosaur removeDinosaur(){
        return this.dinosaurList.remove(0);
    }





}





