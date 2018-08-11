package com.company.station;
import com.company.vehicles.Vehicle;
import com.company.Main;
import com.company.station.*;
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

    private List<Vehicle> queue;
    public int queueSize;

    public Pump(){	
    }
    
    /**
     * 
     * TickRefresh will run each time a new simulation tick is started, this function checks if fuel is needed for the first vehicle in the queue.
     * If fuel is needed, it will run the pumpFuel function otherwise it will check if the vehicle will shop.
     *
     */
    public void TickRefresh() {
    	Vehicle v = queue.get(0);
    	//if moreFuelNeeded returns true, then run the pump fuel function. otherwise check if the vehicle will go shopping.
    	if(moreFuelNeeded(v)) {
    		pumpFuel(v);
    	}
    	else {
    		removeFromQueue(v);
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
    private void pumpFuel(Vehicle vehicle) {
    	vehicle.fuelReceived += 1;
    }

    /**
     * 
     * moreFuelNeeded will check the vehicles tank size against the amount filled, if the fuel tank size is larger than the fuel received, it will return true.
     *
     */
    private boolean moreFuelNeeded(Vehicle vehicle) {
    	if (vehicle.fuelTankSize < vehicle.fuelReceived) {
    		return true;
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
    	if (vehicle.paid) {
    	queue.remove(0);
    	} else {
    		if (!c.vehicles.contains(vehicle)) {
    		c.addShopper(vehicle);
    		}
    	}
    }

    /**
     * 
     * addToQueue will check if a vehicle can be fitted into the queue, if it can then it will be added.
     *
     */
    public void addToQueue(Vehicle vehicle) {
    	if (queueSize < 3.00 && queueSize + vehicle.queueSize < 3.00) {
    		queue.add(vehicle);
    	}
    }
}
