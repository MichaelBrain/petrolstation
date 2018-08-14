package com.company.test;

import com.company.vehicles.Motorbike;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMotorbike {

    @Before
    public void setUp() {

    }

    @Test
    public void TestMotorBikeTankSize() {
        Motorbike motorbike = new Motorbike();
        assertEquals(8, motorbike.fuelTankSize);
    }

    @Test
    public void TestMotorBikeQueueSize() {
        Motorbike motorbike = new Motorbike();
        assertEquals(0.75, motorbike.queueSize);
    }

    @Test
    public void TestMotorBikeShopCheck() {
        Motorbike motorbike = new Motorbike();
        assertEquals(false, motorbike.shopCheck());
    }

    @Test
    public void TestMotorBikeReadyToPay() {
        Motorbike motorbike = new Motorbike();
        motorbike.paid = true;
        assertEquals(true, motorbike.paid);
    }
}
