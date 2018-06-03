package Paddocks;

import Dinosaurs.DietType;
import Dinosaurs.Dinosaur;
import Dinosaurs.Diplodocus;


import java.util.ArrayList;

public abstract class Paddock {
    protected String name;
    protected int capacity;
    protected ArrayList<Dinosaur> dinosaurList;

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
       if (this.dinosaurList.size()< this.capacity)
        dinosaurList.add(dinosaur);
    }

    public void removeDinosaur(Dinosaur dinosaur) {
        this.dinosaurList.remove(dinosaur);
    }

    public boolean findHerbivore(Dinosaur dinosaur) {
        if (dinosaur.getDietType()==DietType.HERBIVORE);
            return true;
        }


}



