package Paddocks;

import java.util.ArrayList;

public class DiplodocusPaddock extends Paddock {

    public DiplodocusPaddock(String name, int capacity){
        super(name, capacity);
        this.dinosaurList = new ArrayList<>();
    }
}
