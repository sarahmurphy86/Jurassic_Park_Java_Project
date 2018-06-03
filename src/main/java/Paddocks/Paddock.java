package Paddocks;

import Dinosaurs.Dinosaur;
import Dinosaurs.Diplodocus;
import Dinosaurs.Velociraptor;

import java.util.ArrayList;

public abstract class Paddock {
    protected String name;
    protected ArrayList<Dinosaur> dinosaurList;

    public Paddock(String name){
        this.name = name;
        this.dinosaurList = new ArrayList<>();
    }

    public String getPaddockName() {
        return this.name;
    }

    public int dinosaurListCount() {
        return this.dinosaurList.size();
    }

    public void addDinosaur(Dinosaur dinosaur){
        this.dinosaurList.add(dinosaur);
    }

    public void removeDinosaur(Dinosaur dinosaur) {
        this.dinosaurList.remove(dinosaur);
    }
}
