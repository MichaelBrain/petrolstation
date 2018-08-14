package com.company.station;

import com.company.Main;
import com.company.PetrolStation;
import com.company.station.*;
import com.company.vehicles.*;
import java.util.ArrayList;

import java.util.List;

/**
 * 
 * The pump class acts as a type of which references a list of vehicles and will complete actions such as pumping fuel, checking if fuel is needed.
 * This type also tracks its own queue to ensure it does not exceed the size of the queue when adding vehicles.
 * 
 * @author corcorar, brainmw 
 *
 */
public class Pump {

    public ArrayList<Vehicle> queue = new ArrayList<Vehicle>();
    public double queueSize=0;
	private static final String SPACER = "--------- PUMP ---------";

    public Pump(){
    }
    
    /**
     * 
     * TickRefresh will run each time a new simulation tick is started, this function checks if fuel is needed for the first vehicle in the queue.
     * If fuel is needed, it will run the pumpFuel function otherwise it will check if the vehicle will shop.
     *
     */
    public void TickRefresh(Shop shop) {
    	if (queue.size() != 0) {
	    	Vehicle vehicle = queue.get(0);
	    	//if moreFuelNeeded returns true, then run the pump fuel function. otherwise check if the vehicle will go shopping.
	    	if(moreFuelNeeded()) {
	    		pumpFuel();
	    	}
	    	else {
	    		removeFromQueue(vehicle, shop);
	    	}
	    	
	    	for (int i=0; i < queue.size(); i++) {
	    		queue.get(0).tickTime += 1;
	    	}
    	}
    }
    
    /**
     * 
     * pumpFuel will run when called from TickRefresh and will increment the fuelReceveived variable by 1 as 1 gallon was pumped.
     *
     */
    public void pumpFuel() {
		System.out.println(SPACER);

		Vehicle vehicle = queue.get(0);
    	if (vehicle instanceof Motorbike) {
    		Motorbike m = (Motorbike) vehicle;
    		m.fuelReceived += 1;
    		System.out.println("Motorbike - Total fuel pumped: " + m.fuelReceived + ". Total fuel required: " + m.fuelTankSize);
    		queue.set(0, m);
    	} else if (vehicle instanceof SmallCar) {
    		SmallCar sc = (SmallCar) vehicle;
    		sc.fuelReceived += 1;
    		System.out.println("Small car - Total fuel pumped: " + sc.fuelReceived + ". Total fuel required: " + sc.fuelTankSize);
    		queue.set(0, sc);
    	} else if (vehicle instanceof FamilySedan) {
    		FamilySedan fs = (FamilySedan) vehicle;
    		fs.fuelReceived += 1;
    		System.out.println("Family Sedan - Total fuel pumped: " + fs.fuelReceived + ". Total fuel required: " + fs.fuelTankSize);
    		queue.set(0, fs);
    	}
    }

    /**
     * 
     * moreFuelNeeded will check the vehicles tank size against the amount filled, if the fuel tank size is larger than the fuel received, it will return true.
     *
     */
    public boolean moreFuelNeeded() {
    	Vehicle v = queue.get(0);
    	if (v instanceof Motorbike) {
    		Motorbike m = (Motorbike) v;
    		if (m.fuelTankSize > m.fuelReceived) {
    			System.out.println("Motorbike - tank size: " + m.fuelTankSize + ". Received: " + m.fuelReceived);
        		return true;
        	}
        	else {
        		return false;	
        	}
    	} 
    	
    	else if (v instanceof SmallCar) {
    		SmallCar sc = (SmallCar) v;
    		if (sc.fuelTankSize > sc.fuelReceived) {
    			System.out.println("Small Car - tank size: " + sc.fuelTankSize + ". Received: " + sc.fuelReceived);
        		return true;
        	}
    		else {
    			return false;
    		}
    	}
    	
    	else if(v instanceof FamilySedan) {
    		FamilySedan fs = (FamilySedan) v;
    		if (fs.fuelTankSize > fs.fuelReceived) {
    			System.out.println("Family Sedan - tank size: " + fs.fuelTankSize + ". Received: " + fs.fuelReceived);
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

    /**
     * 
     * removes the first vehicle from the queue if they have paid, otherwise it checks if they are shopping or paying and if not will add them to the shop queues.
     * @param vehicle
	 * @[param c Shop
	 *
     */
    public void removeFromQueue(Vehicle vehicle, Shop c) {
    	if (vehicle instanceof Motorbike) {
    		Motorbike m = (Motorbike) vehicle;
    		if (m.paid ) {
    			queueSize = queueSize - m.queueSize;
    			queue.remove(0);
    		}
    		else if (!c.vehicles.contains(m)) {
    			c.addShopper(m);
    		}
    		
    	} else if (vehicle instanceof SmallCar) {
    		SmallCar sc = (SmallCar) vehicle;
    		if (sc.paid == true) {
    			queue.remove(0);
    			queueSize = queueSize - sc.queueSize;
    		}
    		else if (!c.vehicles.contains(sc)) {
    			c.addShopper(sc);
    		}
    		
    	} else if (vehicle instanceof FamilySedan) {
    		FamilySedan fs = (FamilySedan) vehicle;
    		if (fs.paid == true) {
    			queue.remove(0);
    			queueSize = queueSize - fs.queueSize;
    		}
    		else if (!c.vehicles.contains(fs)) {
    			c.addShopper(fs);
    		}
    	}
    }

    /**
     * 
     * addToQueue will check if a vehicle can be fitted into the queue, if it can then it will be added.
	 * @param vehicle
	 * @param vQueueSize
     * @return boolean
     *
     */
    public boolean addToQueue(Vehicle vehicle, double vQueueSize) {
    	
    	if (queueSize < (double)3 && queueSize + vQueueSize <= (double)3) {
    		queue.add(vehicle);
    		queueSize = queueSize + vQueueSize;
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}

