package com.company.station;

import com.company.vehicles.FamilySedan;
import com.company.vehicles.Motorbike;
import com.company.vehicles.SmallCar;
import com.company.vehicles.Vehicle;
import java.util.Random;

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
	private static final String SPACER = "--------- TILL ---------";

    public Till(){
    }

	/**
	 *
	 * Takes the payment from the vehicle and returns payment amount so profit can be calculated
	 * @return paymentAmount double
	 *
	 */
    public double takePayment(){
    	paymentAmount=0;
    	readyToPay();
		System.out.println(SPACER);
    	System.out.println("Vehicles in till queue " + queue.size());
    	if (queue.size() != 0) {
	        Vehicle vehicle = queue.get(0);
	        if (vehicle instanceof Motorbike) {
	            Motorbike m = (Motorbike) vehicle;
	            if (m.readyToPay == true) {
	            paymentAmount = paymentAmount + (double)m.fuelReceived * fuelPrice;
	            m.paid = true;
	            queueSize = queueSize - m.queueSize;
	            queue.remove(0);
	            System.out.println("Motorbike amount paid: " + paymentAmount);
	            return paymentAmount;
	            }
	            else {
	            	return 0;
	            }
	        } else if (vehicle instanceof SmallCar) {
	            SmallCar sc = (SmallCar) vehicle;
	            if (sc.readyToPay == true ) {
	            paymentAmount = paymentAmount + (double)sc.fuelReceived * fuelPrice;
	            sc.paid = true;
	            queue.remove(0);
	            queueSize = queueSize - sc.queueSize;
	            System.out.println("Small Car amount paid: " + paymentAmount);
				return paymentAmount;
	            } else {
	            	return 0;
	            }
	        } else if (vehicle instanceof FamilySedan) {
	            FamilySedan fs = (FamilySedan) vehicle;
	            if (fs.readyToPay == true) {
	            paymentAmount = paymentAmount + (double)fs.fuelReceived * fuelPrice;
	            fs.paid = true;
	            queue.remove(0);
	            queueSize = queueSize - fs.queueSize;
	            System.out.println("Family Sedan amount paid: " + paymentAmount);
				return paymentAmount;
	            } else {
	            	return 0;
	            }
	        }
    	}
    	return 0.00;
    }
    
    private void readyToPay() {
    	for (int i=0; i < queue.size(); i++) {
        	Random rand = new Random();
        	int num = rand.nextInt(6)+12;
    		Vehicle vehicle = queue.get(i);
    		if (vehicle instanceof Motorbike) {
	            Motorbike m = (Motorbike) vehicle;
	            if (m.tickTime <= num) {
	            	m.readyToPay = true;
	            }
	        } else if (vehicle instanceof SmallCar) {
	            SmallCar sc = (SmallCar) vehicle;
	            if (sc.tickTime <= num) {
	            	sc.readyToPay = true;
	            }
	        } else if (vehicle instanceof FamilySedan) {
	            FamilySedan fs = (FamilySedan) vehicle;
	            if (fs.tickTime <= num) {
	            	fs.readyToPay = true;
	            }
	        }  
    	}
    }

    /**
     *
     * addToQueue will add a vehicle to the till with the least amount waiting
	 * @param vehicle
     *
     */
    public void addToQueue(Vehicle vehicle) {
        if (queueSize <= (double)6 - vehicle.queueSize) {
            queue.add(vehicle);
        }
    }
}
