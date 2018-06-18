package Park;

import Dinosaurs.*;
import Dinosaurs.Enums.Behaviours.IRampage;
import Dinosaurs.Enums.DietType;
import Paddocks.Paddock;
import Visitors.Visitor;

import java.util.ArrayList;

public class Park {
    private String name;
    private double admissionPriceAdult;
    private double till;
    private int visitorCapacity;
    private int paddockCapacity;
    private ArrayList<Paddock> paddockList;
    private ArrayList<Visitor> visitorList;

    public Park(String name, double admissionPriceAdult, int visitorCapacity, int paddockCapacity){
        this.name = name;
        this.admissionPriceAdult = admissionPriceAdult;
        this.till = 0;
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

    public double getAdmissionPriceAdult() {
        return this.admissionPriceAdult;
    }

    public double getTill() {
        return this.till;
    }

    public void addVisitor(Visitor visitor) {
        if ((this.visitorList.size() < this.visitorCapacity) && (!checkIfDinosaurIsRampaging())) {
            this.visitorList.add(visitor);
            this.till += admissionPriceAdult;
        }
    }

    public void removeVisitor(Visitor visitor) {
        if(!checkIfDinosaurIsRampaging()){
            this.visitorList.remove(visitor);
        }
    }

    public int getPaddockCount() {
        return this.paddockList.size();
    }

    public void addPaddock(Paddock paddock) {
        if (this.paddockList.size() < this.paddockCapacity) {
            this.paddockList.add(paddock);
        }
    }

    public void removePaddock(Paddock paddock) {
        this.paddockList.remove(paddock);
    }

    public int getVisitorCapacity() {
        return this.visitorCapacity;
    }

    public void moveHerbivore(Dinosaur dinosaur, Paddock originPaddock, Paddock destinationPaddock) {

        if(dinosaur.getDietType() == DietType.HERBIVORE) {
            originPaddock.removeDinosaur();
        }

        if (destinationPaddock.dinosaurList.size() == 0 || destinationPaddock.dinosaurList.get(0).getDietType() == DietType.HERBIVORE){
            destinationPaddock.addDinosaur(dinosaur);
        }

        else originPaddock.addDinosaur(dinosaur);
    }


    public void moveVelociraptor(Dinosaur dinosaur, Paddock originPaddock, Paddock destinationPaddock) {
        if(dinosaur.getSpeciesType()== SpeciesType.VELOCIRAPTOR){
            originPaddock.removeDinosaur();
            destinationPaddock.addDinosaur(dinosaur);
        }
    }

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


