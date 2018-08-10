package com.company.vehicles;

public class SmallCar extends Vehicle {

    public int fuelTankSize = 40;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    public boolean shopCheck(int probabilityOfShop) {
        return false;
    }
}
