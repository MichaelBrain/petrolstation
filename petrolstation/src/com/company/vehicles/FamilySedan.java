package com.company.vehicles;

public class FamilySedan extends Vehicle {

    public int fuelTankSize = 18;
    public int fuelReceived;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    public boolean shopCheck() {
        return false;
    }
}
