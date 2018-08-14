package com.company.test;

import com.company.vehicles.FamilySedan;
import com.company.vehicles.SmallCar;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestFamilySedan {

    @Before
    public void setUp() {

    }

    @Test
    public void TestFamilySedanTankSize() {
        FamilySedan fs = new FamilySedan();
        assertEquals(18, fs.fuelTankSize);
    }

    @Test
    public void TestFamilySedanQueueSize() {
        FamilySedan fs = new FamilySedan();
        assertEquals(1.5, fs.queueSize);
    }

    @Test
    public void TestFamilySedanShopCheck() {
        FamilySedan fs = new FamilySedan();
        assertEquals(false, fs.shopCheck());
    }

    @Test
    public void TestFamilySedanReadyToPay() {
        FamilySedan fs = new FamilySedan();
        fs.paid = true;
        assertEquals(true, fs.paid);
    }
}
