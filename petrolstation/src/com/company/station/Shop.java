package com.company.station;

import com.company.vehicles.*;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    public ArrayList<Till> tills = new ArrayList<Till>();
    public ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    public int noOfTills = 0;
    public double profit = 0;
	public double losses = 0;
    private int shoppers = 0;
	private static final String SPACER = "--------- SHOP ---------";

    public Shop() {
	}

	/**
	 *
	 * TickRefresh will run each time a new simulation tick is started, this function checks if fuel is needed for the first vehicle in the queue.
	 * If payment is needed, it will run the takePayment function otherwise it will wait
	 *
	 */
    public void TickRefresh() {
		System.out.println(SPACER);
    	System.out.println("Vehicle queue size: " + vehicles.size());
		for (int i=0; i < tills.size(); i++) {
			Till t = tills.get(i);
			profit += t.takePayment();
		}
	}

	/**
	 *
	 * Takes the payment from the vehicle
	 * @param vehicle
	 *
	 */
    private void takePayment(Vehicle vehicle){
    	Till t = getEmptiestTill();
		t.addToQueue(vehicle);
    }


	/**
	 *
	 * Adds the Vehicle to the queue within the shop to either shop or make a payment
	 * @param vehicle
	 *
	 */
    public void addShopper(Vehicle vehicle){
    	if (vehicle instanceof Motorbike) {
    		Motorbike m = (Motorbike) vehicle;
    		if (m.shopCheck()) {
    			if (m.shopping) {
    				vehicles.add(m);
    			}
    		}
    		else {
    			takePayment(m);
    		}
    	}
    	else if (vehicle instanceof SmallCar) {
    		SmallCar sc = (SmallCar) vehicle;
    		if (sc.shopCheck()) {
    			if (sc.shopping) {
    				vehicles.add(sc);
    			}
    		}
    		else {
    			takePayment(sc);
    		}
    	}
    	else if (vehicle instanceof FamilySedan) {
    		FamilySedan fs = (FamilySedan) vehicle;
    		if (fs.shopCheck()) {
    			if (fs.shopping) {
    				vehicles.add(fs);
    			}
    		}
    		else {
    			takePayment(fs);
    		}
    	}
    }
    
    

    private void removeShopper(Vehicle vehicle){
    	vehicles.remove(vehicle);	
    }

    
    
    /**
     *
     * The getEmptiest till function determines the emptiest till by comparing all of the queue sizes to get the lowest value.
     *
     *@return the till with the lowest queuesize.
     */
    private Till getEmptiestTill() {
        Till t = tills.get(0);
        Till tToCheck;
        for (int i=0; i < tills.size(); i++)
        {
            tToCheck = tills.get(i);
            if (t.queueSize > tToCheck.queueSize)
            {
                t = tToCheck;
            }
        }
        return t;
    }
}
