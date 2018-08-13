package com.company.station;

import com.company.Main;
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

    public Pump(){
    	queue = new ArrayList<Vehicle>();
    }
    
    /**
     * 
     * TickRefresh will run each time a new simulation tick is started, this function checks if fuel is needed for the first vehicle in the queue.
     * If fuel is needed, it will run the pumpFuel function otherwise it will check if the vehicle will shop.
     *
     */
    public void TickRefresh() {
    	Vehicle vehicle = queue.get(0);
    	//if moreFuelNeeded returns true, then run the pump fuel function. otherwise check if the vehicle will go shopping.
    	if(moreFuelNeeded()) {
    		pumpFuel();
    	}
    	else {
    		removeFromQueue(vehicle);
    	}
    	
    	for (int i=0; i < queue.size(); i++) {
    		queue.get(0).tickTime += 1;
    	}
    }
    
    /**
     * 
     * pumpFuel will run when called from TickRefresh and will increment the fuelReceveived variable by 1 as 1 gallon was pumped.
     *
     */
    private void pumpFuel() {
    	Vehicle vehicle = queue.get(0);
    	if (vehicle instanceof Motorbike) {
    		Motorbike m = (Motorbike) vehicle;
    		m.fuelReceived += 1;
    		System.out.println("Total fuel pumped: " + m.fuelReceived + ". Total fuel required: " + m.fuelTankSize);
    		queue.set(0, m);
    	} else if (vehicle instanceof SmallCar) {
    		SmallCar sc = (SmallCar) vehicle;
    		sc.fuelReceived += 1;
    		System.out.println("Total fuel pumped: " + sc.fuelReceived + ". Total fuel required: " + sc.fuelTankSize);
    		queue.set(0, sc);
    	} else if (vehicle instanceof FamilySedan) {
    		FamilySedan fs = (FamilySedan) vehicle;
    		fs.fuelReceived += 1;
    		System.out.println("Total fuel pumped: " + fs.fuelReceived + ". Total fuel required: " + fs.fuelTankSize);
    		queue.set(0, fs);
    	}
    }

    /**
     * 
     * moreFuelNeeded will check the vehicles tank size against the amount filled, if the fuel tank size is larger than the fuel received, it will return true.
     *
     */
    private boolean moreFuelNeeded() {
    	Vehicle v = queue.get(0);
    	if (v instanceof Motorbike) {
    		Motorbike m = (Motorbike) v;
    		if (m.fuelTankSize > m.fuelReceived) {
    			System.out.println("tank size: " + m.fuelTankSize + ". Received: " + m.fuelReceived);
        		return true;
        	}
        	else {
        		return false;	
        	}
    	} 
    	
    	else if (v instanceof SmallCar) {
    		SmallCar sc = (SmallCar) v;
    		if (sc.fuelTankSize > sc.fuelReceived) {
    			System.out.println("tank size: " + sc.fuelTankSize + ". Received: " + sc.fuelReceived);
        		return true;
        	}
    		else {
    			return false;
    		}
    	}
    	
    	else if(v instanceof FamilySedan) {
    		FamilySedan fs = (FamilySedan) v;
    		if (fs.fuelTankSize > fs.fuelReceived) {
    			System.out.println("tank size: " + fs.fuelTankSize + ". Received: " + fs.fuelReceived);
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
     *
     */
    public void removeFromQueue(Vehicle vehicle) {
    	Shop c = Main.shop;
    	if (vehicle instanceof Motorbike) {
    		Motorbike m = (Motorbike) vehicle;
    		if (m.paid ) {
    			queue.remove(0);
    		}
    		else if (!c.vehicles.contains(m)) {
    			c.addShopper(m);
    		}
    		
    	} else if (vehicle instanceof SmallCar) {
    		SmallCar sc = (SmallCar) vehicle;
    		if (sc.paid ) {
    			queue.remove(0);
    		}
    		else if (!c.vehicles.contains(sc)) {
    			c.addShopper(sc);
    		}
    		
    	} else if (vehicle instanceof FamilySedan) {
    		FamilySedan fs = (FamilySedan) vehicle;
    		if (fs.paid ) {
    			queue.remove(0);
    		}
    		else if (!c.vehicles.contains(fs)) {
    			c.addShopper(fs);
    		}
    	}
    }

    /**
     * 
     * addToQueue will check if a vehicle can be fitted into the queue, if it can then it will be added.
     * @return 
     *
     */
    public boolean addToQueue(Vehicle vehicle, double vQueueSize) {
    	
    	if (queueSize < (double)3 && queueSize + vQueueSize <= (double)3) {
    		queue.add(vehicle);
    		queueSize = queueSize + vQueueSize;
    		System.out.println("Vehicle Added");
    		System.out.println("Queue Size: " + queueSize);
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}

