/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;

import java.util.Comparator;
import rms.models.Order;

/**
 *
 * @author soupa
 */
public class OrderComparator implements Comparator<Order>{

    // Arranging according to descending order of priority of orders.
    @Override
    public int compare(Order o1, Order o2) {
        
        if(o1.getPriority() < o2.getPriority())
            return 1;
        else if(o1.getPriority() > o2.getPriority())
            return -1;
        
        return 0;
    }
    
}
