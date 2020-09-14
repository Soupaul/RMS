package rms.resources;

import rms.models.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrdersDbHandler {

    private final String DB_URL = "jdbc:mysql://localhost:3306/rms?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "007hrit@mysql";

    public void addOrder(String dueTime,String items){

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String sqlInsert = "INSERT INTO orders (dueTime,items) VALUES ('" + dueTime + "', '" + items + "')";
            int countInsert = stmt.executeUpdate(sqlInsert);
            if(countInsert != 0) System.out.println("Order added successfully");

        }
        catch(SQLException ex){

            ex.printStackTrace();

        }

    }

    public ArrayList getOrders(){

        ArrayList<Order> orders = new ArrayList<>();
        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String strSelect = "SELECT id,dueTime,items FROM orders";
            ResultSet rSet = stmt.executeQuery(strSelect);

            while(rSet.next()) {

                int id = rSet.getInt("id");
                String dueTime = rSet.getString("dueTime");
                String items = rSet.getString("items");
                orders.add(new Order(id, dueTime, items));

            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return orders;

    }

    public void displayOrders(){

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String strSelect = "SELECT id,dueTime,items FROM orders";
            ResultSet rSet = stmt.executeQuery(strSelect);

            System.out.printf("%-5s%-20s%-50s\n","ID","Due Time","Items");
            while(rSet.next()) {
                int id = rSet.getInt("id");
                String dueTime = rSet.getString("dueTime");
                String items = rSet.getString("items");
                System.out.printf("%-5d%-20s%-50s\n",id,dueTime,items);
            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

}
