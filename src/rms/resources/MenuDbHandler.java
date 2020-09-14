package rms.resources;

import rms.models.MenuItem;

import java.sql.*;

public class MenuDbHandler {

    private final String DB_URL = "jdbc:mysql://localhost:3306/rms?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "007hrit@mysql";

    public MenuItem getMenuItem(int id, int qty){

        MenuItem item = null;

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String sqlSelect = "SELECT name,price from menu WHERE id =" + id;
            ResultSet rSet = stmt.executeQuery(sqlSelect);

            rSet.next();
            item = new MenuItem(rSet.getString("name"),rSet.getDouble("price"),id,qty);

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return item;

    }

    public void addMenuItem(String name,double price){

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String sqlInsert = "INSERT INTO menu (name,price) VALUES ('" + name + "', " + price + ")";
            int countInsert = stmt.executeUpdate(sqlInsert);
            if(countInsert != 0) System.out.println("Item added successfully");

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void displayMenu(){

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String strSelect = "SELECT name,price FROM menu";
            ResultSet rSet = stmt.executeQuery(strSelect);

            System.out.printf("%-50s%-5s\n","Name","Price");
            while(rSet.next()) {
                String name = rSet.getString("name");
                double price = rSet.getDouble("price");
                System.out.printf("%-50s%-5.2f\n",name,price);
            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

}
