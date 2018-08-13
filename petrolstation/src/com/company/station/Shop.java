package com.company.station;

import com.company.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    public ArrayList<Till> tills = new ArrayList<Till>();
    public ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    public int noOfTills;
    private double profit;
    private int shoppers;

    public Shop() {}

    private void takePayment(Vehicle vehicle){
    	Till t = getEmptiestTill();
		t.addToQueue(vehicle);
    }

    
    public void addShopper(Vehicle vehicle){
    	if (vehicle.shopCheck() == false)
    	{
    		takePayment(vehicle);
    	} else if (vehicle.shopping == true) {
    		vehicles.add(vehicle);
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
            if (t.queueSize < tToCheck.queueSize)
            {
                t = tToCheck;
            }
        }
        return t;
    }
}
