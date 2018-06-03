package Paddocks;

import Dinosaurs.Dinosaur;

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
}
