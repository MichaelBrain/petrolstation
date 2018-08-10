package com.company.station;

import com.company.vehicles.Vehicle;
import com.company.station.*;

import java.util.List;

public class Pump {

    private List<Vehicle> queue;
    private int queueSize;
    private int litresPumped;

    public Pump(){
    	
    }
    
    public void TickRefresh() {
    	Vehicle v = queue.get(0);
    	if(moreFuelNeeded(v)) {
    		pumpFuel(v);
    	}
    	else {
    		if (v.shopCheck()) {
    		}
    	}
    }

    private void pumpFuel(Vehicle vehicle) {
    	vehicle.fuelReceived += 1;
    }

    private boolean moreFuelNeeded(Vehicle vehicle) {
    	if (vehicle.fuelTankSize < vehicle.fuelReceived) {
    		return true;
    	}
    	else {
    		return false;	
    	}
    }

    private void removeFromQueue(Vehicle vehicle) {
    	queue.remove(0);
    }

    private void addToQueue(Vehicle vehicle) {
    	if (queueSize < 6) {
    		queue.add(vehicle);
    	}
    	
    }
}
