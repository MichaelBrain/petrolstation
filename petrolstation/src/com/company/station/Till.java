package com.company.station;

import com.company.vehicles.Vehicle;

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
    public List<Vehicle> queue;
    public int queueSize;

    public Till(){
    }

    private void takePayment(Vehicle vehicle){

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
