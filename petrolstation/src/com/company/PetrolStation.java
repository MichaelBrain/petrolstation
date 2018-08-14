package com.company;

import com.company.station.Pump;
import com.company.station.Shop;
import com.company.station.Till;
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
    public int noOfTills;
    private int pumpCount;
    private double fuelPrice = 1.20;
    private double profit;
    private double losses;
    public ArrayList<Pump> pumps = new ArrayList<Pump>();
    public int scProbability = 0;
    public int fcProbability = 0;
    public int mProbablilty = 0;
    private int mCount = 0;
    private int scCount = 0;
    private int fsCount = 0;
	public Shop shop = Main.shop;
	private static final String SPACER = "--------- OTHER ---------";
    
    PetrolStation() {
    }
    
    /**
     * 
     * The update function runs every new tick and refreshes the pump and creates a new car for checking if it can fuel in the station.
     *
     */
    public void update() {
    	    	
    	Pump p = new Pump();
    	for (int i = 0; i < pumps.size(); i++) {
    		p = pumps.get(i);
    		if (p.queueSize != 0) {
    		p.TickRefresh(shop);
    		}
    		else {
    		}
    	}
    	shop.TickRefresh();
    	profit = shop.profit;
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

    	//if the random integer is below the motorbike probability, then create a motorbike
		System.out.println(SPACER);
    	if (randNum < mProbablilty){
    		Motorbike mBike = new Motorbike();
    		if (chosenPump.addToQueue(mBike, mBike.queueSize)) {
    			System.out.println("A Motorbike Arrives");
    			mCount++;
			} else {
				System.out.println("Motorbike too large, motorbike has left");
				losses += mBike.fuelTankSize * fuelPrice;
			}
    	}
    	//if the random integer is below the small car probability, then create a small car
    	else if (randNum < scProbability) {
    		SmallCar sc = new SmallCar();
			if (chosenPump.addToQueue(sc, sc.queueSize)) {
				System.out.println("A Small Car Arrives");
				scCount++;
			} else {
				System.out.println("Small Car too large, Small Car has left");
				losses += sc.fuelTankSize * fuelPrice;
			}
    	}
    	//if the random integer is below the family sedan probability, then create a family sedan
    	else if (randNum < fcProbability ) {
    		FamilySedan fs = new FamilySedan();
			if (chosenPump.addToQueue(fs, fs.queueSize)) {
				System.out.println("A Family Sedan Arrives");
				fsCount++;
			} else {
				System.out.println("Family Sedan too large, Family Sedan has left");
				losses += fs.fuelTankSize * fuelPrice;
			}
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
		int chosenPumpNo = 0;
		Pump pToCheck = new Pump();
		for (int i=0; i < pumps.size(); i++)
		{
			pToCheck = pumps.get(i);
			if (p.queueSize > pToCheck.queueSize)
			{
				chosenPumpNo = i;
				p = pToCheck;
			}
		}
		System.out.println("Pump number " + chosenPumpNo + " chosen");
		return p;
	}
	
	public void RunEvery10() {
		int iterator = 0;
		while (iterator < 1440) {
			try {
				update();
				iterator++;
				System.out.println("------ " + iterator + " of 1440 ------");
				TimeUnit.SECONDS.sleep(10);
				System.out.println("Total profit: " + profit);
				System.out.println("Total losses: " + losses);
				} catch (InterruptedException e) {
					System.out.println("Wait failed");
				}
		System.out.println("Motorbikes: " + mCount);
		System.out.println("Small Cars: " + scCount);
		System.out.println("Family Sedans: " + fsCount);
		}
	}
}

