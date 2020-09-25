package rms.resources;

import rms.models.Order;

import java.sql.*;
import java.util.ArrayList;
import rms.StringConstants;

public class OrdersDbHandler {

    public void addOrder(String timePlaced,String items){

        try(

                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();

        ){

            String sqlInsert = "INSERT INTO orders (timePlaced,items) VALUES ('" + timePlaced + "', '" + items + "')";
            int countInsert = stmt.executeUpdate(sqlInsert);
            if(countInsert != 0) System.out.println("Order added successfully");

        }
        catch(SQLException ex){

            ex.printStackTrace();

        }

    }
    
    public void removeOrder(int id){
    
        try(

                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();

        ){

            String sqlDelete = "DELETE FROM orders WHERE id = " + id;
            int countDeleted = stmt.executeUpdate(sqlDelete);
            if(countDeleted != 0) System.out.println("Order removed");

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    
    }

    public ArrayList getOrders(){

        ArrayList<Order> orders = new ArrayList<>();
        try(

                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();

        ){

            String strSelect = "SELECT id,timePlaced,items FROM orders";
            ResultSet rSet = stmt.executeQuery(strSelect);

            while(rSet.next()) {

                int id = rSet.getInt("id");
                String timePlaced = rSet.getString("timePlaced");
                String items = rSet.getString("items");
                orders.add(new Order(id, timePlaced, items));

            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return orders;

    }

    public void displayOrders(){

        try(

                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();

        ){

            String strSelect = "SELECT id,timePlaced,items FROM orders";
            ResultSet rSet = stmt.executeQuery(strSelect);

            System.out.printf("%-5s%-20s%-50s\n","ID","Time Placed","Items");
            while(rSet.next()) {
                int id = rSet.getInt("id");
                String timePlaced = rSet.getString("timePlaced");
                String items = rSet.getString("items");
                System.out.printf("%-5d%-20s%-50s\n",id,timePlaced,items);
            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

}
