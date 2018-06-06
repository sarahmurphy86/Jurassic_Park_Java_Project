package Park;

import Dinosaurs.*;
import Paddocks.Paddock;
import Visitors.Visitor;

import java.util.ArrayList;

public class Park {
    private String name;
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

//    Version 2 - adding visitor if there is no dinosaur rampaging.
    public void addVisitor(Visitor visitor) {
        if((this.visitorList.size()<this.visitorCapacity) && (checkIfDinosaurIsRampaging() != true))
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
// Stuck on having the IRampage interface only implemented by Tyrannosaurus
// Could not call the isRampaging method - doesn't exist for dinosaur
// Could have changed the IRampage method to an abstract method and over-ridden it in the other classes
// Make the dinosaur an instance of IRampage (forcing it to be something that can rampage i.e. rampage object)
// IRampage has a variable called rampage
// Means you can call the isRampaging method on a variable rampage instead of dinosaur/tyrannosaurus
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

//  I want to find out how many dinosaurs are in each paddock in the park and get the total amount
//  I want to loop through all the paddocks in the park
//  I then want to loop through the dinosaur list of each paddock
//  If there is a dinosaur in the paddock, I want to add it to the counter- cant have an int so
//  Create an array list for totalDinosaurs = add the dinosaur to this arraylist and then get the size of it.


    public int totalDinosaursInAllPaddocks() {
        ArrayList<Dinosaur>totalDinosaurs= new ArrayList<>();

        for(Paddock paddock : this.paddockList){
            for (Dinosaur dinosaur : paddock.dinosaurList) {
                totalDinosaurs.add(dinosaur);
            }
        }
        return totalDinosaurs.size();
    }
}


