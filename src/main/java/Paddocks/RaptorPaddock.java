package Paddocks;

import Dinosaurs.Dinosaur;

import java.util.ArrayList;

public class RaptorPaddock extends Paddock {

    public RaptorPaddock(String name, int capacity){
        super(name, capacity);
        this.dinosaurList = new ArrayList<>();
    }
}
