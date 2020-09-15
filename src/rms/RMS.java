/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import java.util.ArrayList;
import javax.swing.*;
import rms.models.Order;
import rms.resources.OrdersDbHandler;
import rms.resources.Utils;
import rms.screens.Login;

/**
 *
 * @author soupa
 */
public class RMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Order> orders = Utils.arrangeOrders(new OrdersDbHandler().getOrders());
        for(Order order : orders){
        
            order.displayDetails();
            System.out.println("Priority: " + order.getPriority());
            System.out.println("Total: $" + order.getTotal());
            
        }
        
//        SwingUtilities.invokeLater(new Runnable(){
//
//            @Override
//            public void run(){
//
//                Login loginForm = new Login();
//                loginForm.setVisible(true);
//
//            }
//
//        });
        
    }
    
}
