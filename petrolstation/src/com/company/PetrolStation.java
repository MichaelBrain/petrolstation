package com.company;
import java.util.concurrent.TimeUnit;
import com.company.station.Pump;
import com.company.station.Shop;
import com.company.vehicles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

/**
 * 
 * The petrol station class acts as a type of which references a list of pumps and controls each tick of the simulation. this is responsible for creating cars.
 * 
 * @author corcorar, brainmw 
 *
 */
public class PetrolStation {

    private int tick;
    public int noOfPumps = 5;
    private int pumpCount;
    private double fuelPrice;
    private double profit;
    private double losses;
    public List<Pump> pumps;
    public int scProbability;
    public int fcProbability;
    public int mProbablilty;
    
    PetrolStation() {
    }
    
    
    /**
     * 
     * The update function runs every new tick and refreshes the pump and creates a new car for checking if it can fuel in the station.
     *
     */
    public void update() {
    	for (int i = 0; i < pumps.size(); i++) {
    		pumps.get(i).TickRefresh();
    	}
    	addCars();
    }

    /**
     * 
     * The add cars function gets the emptiest pump, then checks all the probabilities and determines the correct vehicle to create and adds it to the queue.
     *
     */
    private void addCars(){
    	Pump chosenPump = getEmptiestPump();
    	Random SpawnProb = new Random();
    	int randNum = SpawnProb.nextInt(100) + 1;
    	
    	//if the random integer is below the motorbike probability, then create a motorbike
    	if (randNum > mProbablilty){
    		Motorbike m = new Motorbike();
    		chosenPump.addToQueue(m);
    	}
    	//if the random integer is below the small car probability, then create a small car
    	else if (randNum > scProbability) {
    		SmallCar sc = new SmallCar();
    		chosenPump.addToQueue(sc);
    	}
    	//if the random integer is below the family sedan probability, then create a family sedan
    	else if (randNum > fcProbability ) {
    		FamilySedan fs = new FamilySedan();
    		chosenPump.addToQueue(fs);
    	}
    }

    private void removeVehicle(Vehicle vehicle){
    	
    }
      
    /**
	 *
	 * The getEmptiest pump function determines the emptiest pump by comparing all of the queue sizes to get the lowest value.
	 *
	 *@return the pump with the lowest queuesize.
	 */
	private Pump getEmptiestPump() {
		Pump p = pumps.get(0);
		Pump pToCheck;
		for (int i=0; i < pumps.size(); i++)
		{
			pToCheck = pumps.get(i);
			if (p.queueSize > pToCheck.queueSize)
			{
				p = pToCheck;
			}
		}
		return p;
	}
	
	private void RunEvery10() {
		while (true) {
			try {
				update();
				TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					System.out.println("Wait failed");
				}
		}
	}
}

