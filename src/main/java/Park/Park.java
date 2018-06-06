package Park;

import Dinosaurs.*;
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

//    Version 1
//    public void addVisitor(Visitor visitor) {
//        if(this.visitorList.size()<this.visitorCapacity)
//            this.visitorList.add(visitor);
//    }

//    Version 2
    public void addVisitor(Visitor visitor) {
        if(this.visitorList.size()<this.visitorCapacity && checkIfDinosaurIsRampaging() != true )
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

// What dinosaur do you want to move - DietType.HERBIVORE
// Find what paddock the dinosaur is in - originPaddock
// What paddock do you want to move the dinosaur to - destinationPaddock
// Take the dinosaur out of origin paddock (remove method)
// Add the dinosaur to the destination paddock (add method)

//    Move herbivore- version 1 (if you try and move the Herbivore into a paddock with a Carnivore - it disappears! You can remove it but you cannot add it))
//    public void moveHerbivore(Dinosaur dinosaur, Paddock originPaddock, Paddock destinationPaddock) {
//       if(dinosaur.getDietType()== DietType.HERBIVORE){
//            originPaddock.removeDinosaur();
//            destinationPaddock.addDinosaur(dinosaur);
//        }
//    Move herbivore - version 2
    public void moveHerbivore(Dinosaur dinosaur, Paddock originPaddock, Paddock destinationPaddock) {
        if(dinosaur.getDietType()== DietType.HERBIVORE) {
            originPaddock.removeDinosaur();
        }
        if (destinationPaddock.dinosaurList.size()== 0){
            destinationPaddock.addDinosaur(dinosaur);
        }

        else if (destinationPaddock.dinosaurList.get(0).getDietType() == DietType.HERBIVORE) {
            destinationPaddock.addDinosaur(dinosaur);
        }
        else if(destinationPaddock.dinosaurList.get(0).getDietType() != DietType.HERBIVORE){
            originPaddock.addDinosaur(dinosaur);
        }
    }

    public void moveVelociraptor(Dinosaur dinosaur, Paddock originPaddock, Paddock destinationPaddock) {
        if(dinosaur.getSpeciesType()== SpeciesType.VELOCIRAPTOR){
            originPaddock.removeDinosaur();
            destinationPaddock.addDinosaur(dinosaur);
        }
    }
//Does the isRampaging method need to be added to all dinosaurs - how do you access this as an interface on one dinosaur?
// Use Instance of - i.e. treat the dinosaur as an instance of IRampage object.
    public boolean checkIfDinosaurIsRampaging() {
        for (Paddock paddock : this.paddockList) {
            for (Dinosaur dinosaur : paddock.dinosaurList) {
                if (dinosaur instanceof IRampage) {
                    IRampage rampage = (IRampage) dinosaur;
                    if (rampage.isRampaging()) return true;
                }
            }
        }
        return false;
    }


}


//Messing about - delete the below...
//    public boolean checkIfDinosaurIsRampaging() {
//        for (Paddock paddock : this.paddockList){
//            for(Dinosaur dinosaur : this.dinosaurList)
//                  if(dinosaur.getSpeciesType()==SpeciesType.TYRANNOSAURUS && )
//        }
//        return true;
//    }
//        else return false;
//}


