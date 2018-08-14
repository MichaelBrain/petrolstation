package com.company.test;

import com.company.vehicles.Motorbike;
import com.company.vehicles.SmallCar;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSmallCar {

    @Before
    public void setUp() {

    }

    @Test
    public void TestCarTankSize() {
        SmallCar car = new SmallCar();
        assertEquals(9, car.fuelTankSize);
    }

    @Test
    public void TestCarQueueSize() {
        SmallCar car = new SmallCar();
        assertEquals(1.0, car.queueSize);
    }

    @Test
    public void TestCarShopCheck() {
        SmallCar car = new SmallCar();
        assertEquals(false, car.shopCheck());
    }

    @Test
    public void TestCarReadyToPay() {
        SmallCar car = new SmallCar();
        car.paid = true;
        assertEquals(true, car.paid);
    }
}
