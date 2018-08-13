package com.company.station;

import com.company.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * The till class acts as a type of which references a list of vehicles and will complete actions such as taking payment and other shop activities.
 *
 * @author corcorar, brainmw
 *
 */
public class Till {

    private double paymentAmount;
    public ArrayList<Vehicle> queue = new ArrayList<Vehicle>();
    public int queueSize;
    public double fuelPrice = 1.2;

    public Till(){
    }

    private void takePayment(){
    	Vehicle v = queue.get(0);
    	paymentAmount = paymentAmount + (double)v.fuelReceived * fuelPrice;
    	v.paid = true;
    	queue.remove(0);
    }

    /**
     *
     * addToQueue will add a vehicle to the till with the least amount waiting
     *
     */
    public void addToQueue(Vehicle vehicle) {
        if (queueSize < 6 - vehicle.queueSize) {
            queue.add(vehicle);
        }
    }
}
