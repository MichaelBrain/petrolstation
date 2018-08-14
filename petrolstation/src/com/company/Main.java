package com.company;

import com.company.station.Pump;
import com.company.station.Shop;
import com.company.station.Till;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static final String SPACER = "-------------------------------------------";
    public static PetrolStation station;

    public static void main(String[] args) {
        setUp();
    }

    public static void setUp(){
        station = new PetrolStation();

        String numberOfPumps = JOptionPane.showInputDialog(null, "Please input a number of pumps.");
        String numberOfTills = JOptionPane.showInputDialog(null, "Please input a number of tills.");
        station.noOfPumps = Integer.parseInt(numberOfPumps);
        station.shop.noOfTills = Integer.parseInt(numberOfTills);

        ArrayList<Pump> pumpList = new ArrayList<Pump>();
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

        System.out.println("There are currently " + station.shop.tills.size() + " tills operating");
        System.out.println(SPACER);
        
        station.RunEvery10();
    }
}
