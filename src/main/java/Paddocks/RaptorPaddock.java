package Paddocks;

import Dinosaurs.Dinosaur;

import java.util.ArrayList;

public class RaptorPaddock extends Paddock {

    public RaptorPaddock(String name){
        super(name);
        this.dinosaurList = new ArrayList<>();
    }
}
