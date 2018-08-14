package com.company.station;

import com.company.vehicles.*;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    public ArrayList<Till> tills;
    public ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    public int noOfTills;
    public double profit;
	public double losses;
    private int shoppers;

    public Shop() {
		tills = new ArrayList<Till>();
	}

    public void TickRefresh() {
		for (int i=0; i < tills.size(); i++) {
			Till t = tills.get(i);
			t.takePayment();
		}
	}

    private void takePayment(Vehicle vehicle){
    	Till t = getEmptiestTill();
		t.addToQueue(vehicle);
    }

    
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
