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

        List<Pump> pumpList = new ArrayList<Pump>();
        for (int i=0; i < station.noOfPumps; i++)
        {
        	Pump p = new Pump();
        	pumpList.add(p);
        }
        station.pumps = pumpList;

        System.out.println(SPACER);
        System.out.println("Petrol Station is open for business");
        System.out.println(SPACER);

        System.out.println("There are currently " + station.pumps.size() + " pumps operating");
        System.out.println(SPACER);
    }
}
