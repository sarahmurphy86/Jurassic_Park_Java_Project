package Paddocks;

import Dinosaurs.DietType;
import Dinosaurs.Dinosaur;
import Dinosaurs.Diplodocus;


import java.util.ArrayList;

public abstract class Paddock {
    protected String name;
    protected int capacity;
    protected ArrayList<Dinosaur> dinosaurList;
    protected ArrayList<Dinosaur> herbivoreList;

    public Paddock(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.dinosaurList = new ArrayList<>();
        this.herbivoreList = new ArrayList<>();
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
       if (this.dinosaurList.size()< this.capacity)
        dinosaurList.add(dinosaur);
    }

//    To remove any dinosaur - ie pick the first one in the array
    public Dinosaur removeDinosaur() {
        return this.dinosaurList.remove(0);
    }

//    public int herbivoreListCount(){
//        for (Dinosaur dinosaur : dinosaurList){
//            if (dinosaur.getDietType()== DietType.HERBIVORE);
////            this.dinosaurList.remove(dinosaur);
//            this.herbivoreList.add(dinosaur);
//        }
//        return this.herbivoreList.size();
//    }


//    public void removeHerbivore(Dinosaur dinosaur) {
//        if (dinosaur.getDietType()==DietType.HERBIVORE)
//        this.dinosaurList.remove(dinosaur);
//    }

//    public boolean findHerbivore(Dinosaur dinosaur) {
//        if (dinosaur.getDietType()== DietType.HERBIVORE);
//            return true;
//        }


}



