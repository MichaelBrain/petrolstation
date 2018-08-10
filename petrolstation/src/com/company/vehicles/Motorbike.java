package com.company.vehicles;

public class Motorbike extends Vehicle {

    public int fuelTankSize = 5;
    public int fuelReceived;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    public boolean shopCheck() {
        return false;
    }
}
