package com.company.vehicles;

public class Truck extends Vehicle {

    public int fuelTankSize = 80;
    public int fuelReceived;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    public boolean shopCheck() {
        return false;
    }
}
