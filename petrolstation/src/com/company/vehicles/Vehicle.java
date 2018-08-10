package com.company.vehicles;

import java.math.BigDecimal;

public abstract class Vehicle {

    public int fuelTankSize;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    public abstract boolean shopCheck(int probabilityOfShop);
}
