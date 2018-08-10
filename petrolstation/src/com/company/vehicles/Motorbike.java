package com.company.vehicles;

public class Motorbike extends Vehicle {

    public int fuelTankSize = 5;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    public boolean shopCheck(int probabilityOfShop) {
        return false;
    }
}
