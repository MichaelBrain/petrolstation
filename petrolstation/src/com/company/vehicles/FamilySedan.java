package com.company.vehicles;

public class FamilySedan extends Vehicle {

    public int fuelTankSize = 18;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    public boolean shopCheck(int probabilityOfShop) {
        return false;
    }
}
