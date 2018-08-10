package com.company.vehicles;

/**
 * The Motorbike class extends the vehicle class as another type of vehicle that can access the petrol station.
 * 
 * @author corcorar, brainmw
 *
 */
public class Motorbike extends Vehicle {

    public int fuelTankSize = 5;
    public int fuelReceived;
    public double probabilityOfShop;
    public int queueSize;
    public double queueDuration;

    /**
     * takes the probability of the vehicle shopping and generates a random number against it, if it is lower then it will return true for shopping.
     */
    public boolean shopCheck() {
        return false;
    }
}
