package com.company.station;

import java.util.List;

public class Shop {

    public List<Till> tills;
    public int noOfTills;
    private double profit;
    private int shoppers;

    public Shop() {}

    private void takePayment(List<Till> tills){

    }

    private void addShopper(List<Till> tills){

    }

    private void removeShopper(List<Till> tills){

    }

    /**
     *
     * The getEmptiest till function determines the emptiest till by comparing all of the queue sizes to get the lowest value.
     *
     *@return the till with the lowest queuesize.
     */
    private Till getEmptiestTill() {
        Till t = tills.get(0);
        Till tToCheck;
        for (int i=0; i < tills.size(); i++)
        {
            tToCheck = tills.get(i);
            if (t.queueSize > tToCheck.queueSize)
            {
                t = tToCheck;
            }
        }
        return t;
    }
}
