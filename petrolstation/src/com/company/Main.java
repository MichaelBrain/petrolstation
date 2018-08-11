package com.company;

import com.company.station.Pump;
import com.company.station.Shop;
import com.company.station.Till;
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
        Shop shop = new Shop();

        List<Pump> pumpList = new ArrayList<Pump>();
        for (int i=0; i < station.noOfPumps; i++)
        {
        	Pump p = new Pump();
        	pumpList.add(p);
        }
        station.pumps = pumpList;

        List<Till> tillList = new ArrayList<Till>();
        for (int i=0; i < shop.noOfTills; i++)
        {
            Till t = new Till();
            tillList.add(t);
        }
        shop.tills = tillList;

        System.out.println(SPACER);
        System.out.println("Petrol Station is open for business");
        System.out.println(SPACER);

        System.out.println("There are currently " + station.pumps.size() + " pumps operating");
        System.out.println(SPACER);

        System.out.println("There are currently " + shop.tills.size() + " tills operating");
        System.out.println(SPACER);
    }
}
