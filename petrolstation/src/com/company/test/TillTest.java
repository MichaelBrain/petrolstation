package com.company.test;

import com.company.station.Pump;
import com.company.station.Shop;
import com.company.station.Till;
import com.company.vehicles.FamilySedan;
import com.company.vehicles.Motorbike;
import com.company.vehicles.SmallCar;
import com.company.vehicles.Vehicle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TillTest {
    Till till;
    List<Vehicle> queue;

    @Before
    public void setUp() throws Exception {
        till = new Till();
        queue = till.queue;
    }

    @After
    public void tearDown() {
        till = null;
        queue= null;
    }

    @Test
    public void addFromQueueCantFit() throws Exception {
        Motorbike motorbike = new Motorbike(); // queue size 0.75;

        till.queueSize = 7.50;

        till.addToQueue(motorbike);
        Assert.assertEquals(7.5, till.queueSize, 0.00);
    }

    @Test
    public void addFromQueue() throws Exception {
        Motorbike motorbike = new Motorbike(); // queue size 0.75;

        till.queueSize = 6.75;

        till.addToQueue(motorbike);
        Assert.assertEquals(7.5, till.queueSize, 0.75);
    }

    @Test
    public void takePayment() throws Exception {
        Motorbike motorbike = new Motorbike(); // queue size 0.75;
        motorbike.readyToPay = true;
        till.addToQueue(motorbike);

        Assert.assertEquals(6.00, till.takePayment(), 6.00);
        Assert.assertEquals(true, motorbike.paid);
    }

    @Test
    public void takePaymentNotReady() throws Exception {
        Motorbike motorbike = new Motorbike(); // queue size 0.75;
        motorbike.readyToPay = false;
        till.addToQueue(motorbike);

        Assert.assertEquals(0, till.takePayment(), 0);
    }

    @Test
    public void takePaymentCar() throws Exception {
        SmallCar car = new SmallCar();
        car.readyToPay = true;
        till.addToQueue(car);

        Assert.assertEquals(10.80, till.takePayment(), 10.80);
        Assert.assertEquals(true, car.paid);
    }
}
