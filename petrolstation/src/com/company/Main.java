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
    public static Shop shop = new Shop();

    public static void main(String[] args) {
        setUp();
    }

    public static void setUp(){
        PetrolStation s = new PetrolStation();

        String numberOfPumps = JOptionPane.showInputDialog(null, "Please input a number of pumps.");
        String numberOfTills = JOptionPane.showInputDialog(null, "Please input a number of tills.");
        String spawnProbMandSC = JOptionPane.showInputDialog(null, "Please define the spawn rate of motorbike and small cars between 1 and 100%");
        String spawnProbFS = JOptionPane.showInputDialog(null, "Please define the spawn rate of family sedans between 1 and 100%");
        s.mProbablilty = Integer.parseInt(spawnProbMandSC);
        s.scProbability = 2 * Integer.parseInt(spawnProbMandSC);
        s.fcProbability = s.scProbability + Integer.parseInt(spawnProbFS);
        s.noOfPumps = Integer.parseInt(numberOfPumps);
        shop.noOfTills = Integer.parseInt(numberOfTills);

        ArrayList<Pump> pumpList = new ArrayList<Pump>();
        for (int i=0; i < s.noOfPumps; i++)
        {
        	Pump p = new Pump();
        	pumpList.add(p);
        }
        s.pumps = pumpList;
        
        
        ArrayList<Till> tillList = new ArrayList<Till>();
        for (int i=0; i < shop.noOfTills; i++)
        {
        	Till t = new Till();
        	tillList.add(t);
        }
        shop.tills = tillList;
        System.out.println("Till count: " + shop.tills.size());

        
        System.out.println(SPACER);
        System.out.println("Petrol Station is open for business");
        System.out.println(SPACER);

        System.out.println("There are currently " + s.pumps.size() + " pumps operating");
        System.out.println(SPACER);

        System.out.println("There are currently " + shop.noOfTills + " tills operating");
        System.out.println(SPACER);
        
        s.RunEvery10();
    }
}
