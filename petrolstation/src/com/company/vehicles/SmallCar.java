package com.company.vehicles;

import java.util.Random;

/**
 * The SmallCar class extends the vehicle class as another type of vehicle that can access the petrol station.
 * 
 * @author corcorar, brainmw
 *
 */
public class SmallCar extends Vehicle {

    public int fuelTankSize = 9;
    public int fuelReceived;
    public int tickTime = 0;
    public int probabilityOfShop = 30;
    public double queueSize = 1.00;
    public double queueDuration;
    public boolean shopping;
    public boolean paid;
    public boolean readyToPay = false;

    /**
     * takes the probability of the vehicle shopping and generates a random number against it, if it is lower then it will return true for shopping.
     */
    public boolean shopCheck() {
    	return false;
//    	if (tickTime <= 30) {
//    		Random rand = new Random();
//    		int random = rand.nextInt(100)+1;
//    		if (random < probabilityOfShop) {
//    			return true;
//    		}
//    		else {
//    			return false;
//    		}
//    	}
//    	else {
//    		return false;
//    	}   
    }
}
