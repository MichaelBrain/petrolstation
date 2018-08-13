package com.company.vehicles;

import java.util.Random;

/**
 * The FamilySedan class extends the vehicle class as another type of vehicle that can access the petrol station.
 * 
 * @author corcorar, brainmw
 *
 */
public class FamilySedan extends Vehicle {

    public int fuelTankSize = 18;
    public int fuelReceived = 0;
    public int probabilityOfShop = 40;
    public double queueSize = 1.50;
    public double queueDuration;
    public boolean shopping;
    public boolean paid;
    public int tickTime;

    /**
     * takes the probability of the vehicle shopping and generates a random number against it, if it is lower then it will return true for shopping.
     */
    public boolean shopCheck() {
    	if (tickTime <= 60) {
    		Random rand = new Random();
    		int random = rand.nextInt(100)+1;
    		if (random < probabilityOfShop) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;
    	}   
    }
}
