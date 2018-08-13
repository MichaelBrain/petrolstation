package com.company;

import com.company.station.Pump;
import com.company.vehicles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 
 * The petrol station class acts as a type of which references a list of pumps and controls each tick of the simulation. this is responsible for creating cars.
 * 
 * @author corcorar, brainmw 
 *
 */
public class PetrolStation {

    private int tick;
    public int noOfPumps;
    private int pumpCount;
    private double fuelPrice;
    private double profit;
    private double losses;
    public List<Pump> pumps;
    public int scProbability = 60;
    public int fcProbability = 90;
    public int mProbablilty = 20;
    
    PetrolStation() {
    	pumps = new ArrayList<Pump>();
    }
    
    /**
     * 
     * The update function runs every new tick and refreshes the pump and creates a new car for checking if it can fuel in the station.
     *
     */
    public void update() {
    	    	
    	Pump p = new Pump();
    	for (int i = 0; i < pumps.size(); i++) {
    		p=pumps.get(i);	
    		if (p.queueSize != 0) {
    		p.TickRefresh(pumps.get(i).queue.get(0));
    		}
    		else {
    			break;
    		}
    	}
    	addCars();
    }

    /**
     * 
     * The add cars function gets the emptiest pump, then checks all the probabilities and determines the correct vehicle to create and adds it to the queue.
     *
     */
    private void addCars(){
    	Pump chosenPump = new Pump();
    	chosenPump = getEmptiestPump();
    	Random SpawnProb = new Random();
    	int randNum = SpawnProb.nextInt(100) + 1;
    	System.out.println(randNum);
    	
    	//if the random integer is below the motorbike probability, then create a motorbike
    	if (randNum < mProbablilty){
    		Motorbike mBike = new Motorbike();
    		chosenPump.addToQueue(mBike);
    	}
    	//if the random integer is below the small car probability, then create a small car
    	else if (randNum < scProbability) {
    		SmallCar sc = new SmallCar();
    		chosenPump.addToQueue(sc);
    	}
    	//if the random integer is below the family sedan probability, then create a family sedan
    	else if (randNum < fcProbability ) {
    		FamilySedan fs = new FamilySedan();
    		chosenPump.addToQueue(fs);
    	}
    }

    /**
	 *
	 * The getEmptiest pump function determines the emptiest pump by comparing all of the queue sizes to get the lowest value.
	 *
	 *@return the pump with the lowest queuesize.
	 */
	private Pump getEmptiestPump() {
		Pump p = pumps.get(0);
		Pump pToCheck = new Pump();
		for (int i=0; i < pumps.size(); i++)
		{
			pToCheck = pumps.get(i);
			if (p.queueSize < pToCheck.queueSize)
			{
				p = pToCheck;
			}
		}
		return p;
	}
	
	public void RunEvery10() {
		while (true) {
			try {
				update();
				System.out.println("Next Tick");
				TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					System.out.println("Wait failed");
				}
		}
	}
}

