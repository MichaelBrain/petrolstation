package com.company.station;

import com.company.vehicles.FamilySedan;
import com.company.vehicles.Motorbike;
import com.company.vehicles.SmallCar;
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
    public ArrayList<Vehicle> queue = new ArrayList<Vehicle>() ;
    public double queueSize;
    public double fuelPrice = 1.2;

    public Till(){
    }

    public void takePayment(){
    	System.out.println("Vehicles in till queue " + queue.size());
    if (queue.size() != 0) {
	        Vehicle vehicle = queue.get(0);
	        if (vehicle instanceof Motorbike) {
	            Motorbike m = (Motorbike) vehicle;
	            paymentAmount = paymentAmount + (double)m.fuelReceived * fuelPrice;
	            m.paid = true;
	            queue.remove(0);
	            System.out.println("Profit: " + paymentAmount);
	        } else if (vehicle instanceof SmallCar) {
	            SmallCar sc = (SmallCar) vehicle;
	            paymentAmount = paymentAmount + (double)sc.fuelReceived * fuelPrice;
	            sc.paid = true;
	            queue.remove(0);
	            System.out.println("Profit: " + paymentAmount);
	        } else if (vehicle instanceof FamilySedan) {
	            FamilySedan fs = (FamilySedan) vehicle;
	            paymentAmount = paymentAmount + (double)fs.fuelReceived * fuelPrice;
	            fs.paid = true;
	            queue.remove(0);
	            System.out.println("Profit: " + paymentAmount);
	        }
    	}
    }

    /**
     *
     * addToQueue will add a vehicle to the till with the least amount waiting
     *
     */
    public void addToQueue(Vehicle vehicle) {
        if (queueSize <= (double)6 - vehicle.queueSize) {
            queue.add(vehicle);
        }
    }
}
