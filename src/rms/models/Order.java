package rms.models;

import rms.resources.MenuDbHandler;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Order {

    private int id;
    private String dueTime;
    private ArrayList<MenuItem> items;

    public Order(int id, String dueTime, ArrayList<MenuItem> items){

        this.id = id;
        this.dueTime = dueTime;
        this.items = items;

    }

    public Order(int id,String dueTime,String details){

        this.id = id;
        this.dueTime = dueTime;
        this.items = new ArrayList<>();
        processOrder(details);

    }

    public ArrayList getItems(){

        return items;

    }

    public void displayDetails(){

        System.out.println("Order ID: " + id + " Due Time: " + dueTime);

        for(MenuItem item : items){

            item.displayDetails();

        }

    }

    public double getTotal(){

        double total = 0.0;

        for(MenuItem item : items){

            total += item.getPrice() * item.getQty();

        }

        return total;

    }

    private void processOrder(String details){

        MenuDbHandler menu = new MenuDbHandler();
        StringTokenizer st1 = new StringTokenizer(details,",");

        while(st1.hasMoreTokens()){

            String token = st1.nextToken().trim();
            int itemID = Integer.parseInt(token.substring(0,token.lastIndexOf(":")));
            int itemQty = Integer.parseInt(token.substring(token.lastIndexOf(":") + 1));
            MenuItem item = menu.getMenuItem(itemID,itemQty);
            this.items.add(item);

        }

    }

}
