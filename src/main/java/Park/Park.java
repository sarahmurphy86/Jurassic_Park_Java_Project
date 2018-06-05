package Park;

import Dinosaurs.DietType;
import Dinosaurs.Dinosaur;
import Paddocks.Paddock;
import Visitors.Visitor;

import java.util.ArrayList;

public class Park {
    protected String name;
    private int visitorCapacity;
    private int paddockCapacity;
    private ArrayList<Paddock> paddockList;
    private ArrayList<Visitor> visitorList;

    public Park(String name, int visitorCapacity, int paddockCapacity){
        this.name = name;
        this.visitorCapacity = visitorCapacity;
        this.paddockCapacity = paddockCapacity;
        this.paddockList = new ArrayList<Paddock>();
        this.visitorList =new ArrayList<Visitor>();
    }

    public String getName() {
        return this.name;
    }

    public int getVisitorCount() {
        return this.visitorList.size();
    }

    public void addVisitor(Visitor visitor) {
        if(this.visitorList.size()<this.visitorCapacity)
            this.visitorList.add(visitor);
    }

    public void removeVisitor(Visitor visitor) {
        this.visitorList.remove(visitor);
    }

    public int getPaddockCount() {
        return this.paddockList.size();
    }

    public void addPaddock(Paddock paddock) {
        if(this.paddockList.size()<this.paddockCapacity)
        this.paddockList.add(paddock);
    }
    public void removePaddock(Paddock paddock) {
        this.paddockList.remove(paddock);
    }

    public int getVisitorCapacity() {
        return this.visitorCapacity;
    }

//    public boolean checkIfHerbivore(Dinosaur dinosaur) {
//        if(dinosaur.getDietType() == DietType.HERBIVORE) {
//            return true;
//        }
//            else return false;
//    }

// What dinosaur do you want to move - DietType.HERBIVORE
// Find what paddock the dinosaur is in - originPaddock
// What paddock do you want to move the dinosaur to - destinationPaddock
// Take the dinosaur out of origin paddock (remove method)
// Add the dinosaur to the destination paddock (add method)

    public void moveHerbivore(Dinosaur dinosaur, Paddock originPaddock, Paddock destinationPaddock) {
       if(dinosaur.getDietType()== DietType.HERBIVORE){
            originPaddock.removeDinosaur();
            destinationPaddock.addDinosaur(dinosaur);
        }
    }
}

