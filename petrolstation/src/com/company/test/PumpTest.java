package com.company.test;

import com.company.station.Pump;
import com.company.station.Shop;
import com.company.vehicles.FamilySedan;
import com.company.vehicles.Motorbike;
import com.company.vehicles.SmallCar;
import com.company.vehicles.Vehicle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PumpTest {
    Pump pump;
    List<Vehicle> queue;
    Shop shop;

    @Before
    public void setUp() throws Exception {
        pump = new Pump();
        shop = new Shop();
        queue = pump.queue;
    }

    @After
    public void tearDown() {
        pump = null;
        shop = null;
        queue= null;
    }

    @Test
    public void testMoreFuelNeededTrue() throws Exception {
        Motorbike motorbike = new Motorbike();
        queue.add(motorbike);
        Assert.assertEquals(true, pump.moreFuelNeeded());

        SmallCar car = new SmallCar();
        queue.add(car);
        Assert.assertEquals(true, pump.moreFuelNeeded());

        FamilySedan fs = new FamilySedan();
        queue.add(fs);
        Assert.assertEquals(true, pump.moreFuelNeeded());
    }

    @Test
    public void testMoreFuelNeededFalse() throws Exception {
        Motorbike motorbike = new Motorbike();
        motorbike.fuelReceived = 5;
        queue.add(motorbike);
        Assert.assertEquals(false, pump.moreFuelNeeded());

        SmallCar car = new SmallCar();
        car.fuelReceived = 7; //Full: 9
        queue.add(car);
        Assert.assertEquals(false, pump.moreFuelNeeded()); // false as motorbike is full

        FamilySedan fs = new FamilySedan();
        fs.fuelReceived = 10; //Full: 18
        queue.add(fs);
        Assert.assertEquals(false, pump.moreFuelNeeded()); // false as motorbike is full
    }

    @Test
    public void testMoreFuelNeeded() throws Exception {
        Motorbike motorbike = new Motorbike(); // tests first in the queue so will fail on motorbike
        motorbike.fuelReceived = 4;
        queue.add(motorbike);

        SmallCar car = new SmallCar();
        car.fuelReceived = 9;
        queue.add(car);

        FamilySedan fs = new FamilySedan();
        fs.fuelReceived = 18;
        queue.add(fs);
        Assert.assertEquals(true, pump.moreFuelNeeded());
    }

    @Test
    public void removeFromQueue() throws Exception {
        Motorbike motorbike = new Motorbike(); // queue size 0.75
        motorbike.paid = true;
        queue.add(motorbike);

        shop.vehicles.add(motorbike);

        pump.queueSize = 3.00;

        pump.removeFromQueue(motorbike, shop);
        Assert.assertEquals(2.25, pump.queueSize, 0.75);
    }

    @Test
    public void removeFromQueueFalse() throws Exception {
        Motorbike motorbike = new Motorbike(); // queue size 0.75
        motorbike.paid = false;
        queue.add(motorbike);

        shop.vehicles.add(motorbike);

        pump.queueSize = 3.00;

        pump.removeFromQueue(motorbike, shop);
        Assert.assertEquals(3.00, pump.queueSize, 0.00);
    }

    @Test
    public void addFromQueueMotorbike() throws Exception {
        Motorbike motorbike = new Motorbike(); // queue size 0.75;

        pump.queueSize = 2.25;

        Assert.assertEquals(true, pump.addToQueue(motorbike, 0.75));
        Assert.assertEquals(3.00, pump.queueSize, 0.75);
    }

    @Test
    public void addFromQueueCantFit() throws Exception {
        Motorbike motorbike = new Motorbike(); // queue size 0.75;

        pump.queueSize = 2.50;

        pump.addToQueue(motorbike, 0.75);
        Assert.assertEquals(2.50, pump.queueSize, 0.00);
    }

    @Test
    public void pumpFuel() throws Exception {
        Motorbike motorbike = new Motorbike(); // fuelReceived = 0
        queue.add(motorbike);

        pump.pumpFuel();
        Assert.assertEquals(1, motorbike.fuelReceived);
    }

    @Test
    public void pumpFuelCarTest2ndInQueue() throws Exception {
        Motorbike motorbike = new Motorbike(); // fuelReceived = 1
        queue.add(motorbike);

        SmallCar car = new SmallCar(); // fuelReceived = 0 as motorbike is first in queue
        queue.add(car);

        pump.pumpFuel();
        Assert.assertEquals(1, motorbike.fuelReceived);
        Assert.assertEquals(0, car.fuelReceived);
    }
}
