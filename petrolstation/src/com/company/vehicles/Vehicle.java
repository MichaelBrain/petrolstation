package com.company.vehicles;

/**
 * The Vehicle class acts as a type for all other vehicles to follow, this will be inherited by the Truck, Small Car, Family Sedan and Motorbike.
 * This class contains the variables each vehicle type will require for operation in the petrol station system.
 * 
 * @author corcorar, brainmw
 *
 */
public abstract class Vehicle {

    public int fuelTankSize = 0;
    public int tickTime = 0;
    public int fuelReceived = 0;
    public int probabilityOfShop = 0;
    public double queueSize = 0.0;
    public double queueDuration = 0.0;
    public boolean shopping = false;
    public boolean paid = false;

    /**
     * takes the probability of the vehicle shopping and generates a random number against it, if it is lower then it will return true for shopping.
     */
    public abstract boolean shopCheck();
}
