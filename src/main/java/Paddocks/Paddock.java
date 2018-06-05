package Paddocks;

import Dinosaurs.DietType;
import Dinosaurs.Dinosaur;
import Dinosaurs.SpeciesType;

import java.util.ArrayList;

import static Dinosaurs.DietType.HERBIVORE;

public class Paddock {
    protected String name;
    protected int capacity;
    public ArrayList<Dinosaur> dinosaurList;


    public Paddock(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.dinosaurList = new ArrayList<>();

    }

    public String getPaddockName() {
        return this.name;
    }

    public int getPaddockCapacity() {
        return this.capacity;
    }

    public int dinosaurListCount() {
        return this.dinosaurList.size();
    }

// Add Dinosaur method - version 1

//    public void addDinosaur(Dinosaur dinosaur){
//        dinosaurList.add(dinosaur);
//    }

//Add Dinosaur method-version 2

//    public void addDinosaur(Dinosaur dinosaur){
//       if (this.dinosaurList.size()< this.capacity)
//        dinosaurList.add(dinosaur);
//    }

//Add Dinosaur method - version 3
//    public void addDinosaur(Dinosaur dinosaur){
//        if (this.dinosaurList.size()== 0)
//            dinosaurList.add(dinosaur);
//        else if ((this.dinosaurList.size()< this.capacity) && (dinosaurList.get(0).getDietType() == dinosaur.getDietType()))
//            dinosaurList.add(dinosaur);
//        else return;
//    }

//Add Dinosaur method - version 4 - if a Herbivore was already in the paddock you could add a carnivore
//  public void addDinosaur(Dinosaur dinosaur){
//    if (this.dinosaurList.size()== 0){
//        dinosaurList.add(dinosaur);
//    }
//
//    else if ((this.dinosaurList.size()< this.capacity) && (dinosaurList.get(0).getDietType() == DietType.HERBIVORE)
//        dinosaurList.add(dinosaur);
//    }
//
//    else if ((this.dinosaurList.size()< this.capacity) && (dinosaurList.get(0).getSpeciesType() == dinosaur.getSpeciesType())) {
//        dinosaurList.add(dinosaur);
//    }
//    else return;
//}
//    Add dinosaur - method 5

    public void addDinosaur(Dinosaur dinosaur){
        if (this.dinosaurList.size()== 0){
            dinosaurList.add(dinosaur);
        }

        else if ((this.dinosaurList.size()< this.capacity) && (dinosaurList.get(0).getDietType() == DietType.HERBIVORE)  &&
                (dinosaur.getDietType() != DietType.CARNIVORE)){
            dinosaurList.add(dinosaur);
        }

        else if ((this.dinosaurList.size()< this.capacity) && (dinosaurList.get(0).getSpeciesType() == dinosaur.getSpeciesType())) {
            dinosaurList.add(dinosaur);
        }
        else return;
   }

//    To remove any dinosaur - ie pick the first one in the array

    public Dinosaur removeDinosaur(){
        return this.dinosaurList.remove(0);
    }





}





