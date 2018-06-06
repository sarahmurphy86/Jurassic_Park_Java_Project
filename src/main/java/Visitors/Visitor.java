package Visitors;

import Park.Park;

public class Visitor {
    private String name;
    private double wallet;

    public Visitor(String name, double wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return this.name;
    }

    public double getWallet() {
        return this.wallet;
    }

    public void payAdmissionFee(Park park) {
        this.wallet -= park.getAdmissionPriceAdult();
    }
}
