package Paddocks;

import java.util.ArrayList;

public class HoldingPaddock extends Paddock {

    public HoldingPaddock (String name, int capacity){
        super(name, capacity);
        this.dinosaurList = new ArrayList<>();
    }
}
