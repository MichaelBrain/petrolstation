package com.company;

import com.company.station.Pump;
import com.company.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String SPACER = "-------------------------------------------";

    public static void main(String[] args) {
        setUp();
    }

    public static void setUp(){
        PetrolStation station = new PetrolStation();
        Pump pump1 = new Pump();
        Pump pump2 = new Pump();
        Pump pump3 = new Pump();
        Pump pump4 = new Pump();

        System.out.println(SPACER);
        System.out.println("Petrol Station is open for business");
        System.out.println(SPACER);

        station.pumps = new ArrayList<Pump>();
        station.pumps.add(pump1);
        station.pumps.add(pump2);
        station.pumps.add(pump3);
        station.pumps.add(pump4);

        System.out.println("There are currently " + station.pumps.size() + " pumps operating");
        System.out.println(SPACER);
    }
}
