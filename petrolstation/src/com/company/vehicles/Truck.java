package com.company.vehicles;

public class Truck extends Vehicle {

    public int fuelTankSize = 80;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    public boolean shopCheck(int probabilityOfShop) {
        return false;
    }
}
