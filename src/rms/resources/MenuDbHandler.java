package rms.resources;

import rms.models.MenuItem;

import java.sql.*;
import java.util.ArrayList;
import rms.StringConstants;

public class MenuDbHandler {

    public MenuItem getMenuItem(int id, int qty){

        MenuItem item = null;

        try(

                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();

        ){

            String sqlSelect = "SELECT name,price,tpp,nppt from menu WHERE id =" + id;
            ResultSet rSet = stmt.executeQuery(sqlSelect);

            rSet.next();
            item = new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),id,qty);

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

        return item;

    }

    public void addMenuItem(String name,double price){

        try(

                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
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

    public ArrayList getMenu(){
    
        ArrayList<MenuItem> menu = new ArrayList();
        
        try(

                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();

        ){

            String strSelect = "SELECT id,name,price,tpp,nppt FROM menu";
            ResultSet rSet = stmt.executeQuery(strSelect);

            while(rSet.next()) {
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                double price = rSet.getDouble("price");
                int tpp = rSet.getInt("tpp");
                int nppt = rSet.getInt("nppt");
                menu.add(new MenuItem(name,price,nppt,tpp,id,0));
            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return menu;
    
    }
    
    public void displayMenu(){

        try(

                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();

        ){

            String strSelect = "SELECT name,price,tpp,nppt FROM menu";
            ResultSet rSet = stmt.executeQuery(strSelect);

            System.out.printf("%-50s%-10s%-5s%-5s\n","Name","Price","TPP","NPPT");
            while(rSet.next()) {
                String name = rSet.getString("name");
                double price = rSet.getDouble("price");
                int tpp = rSet.getInt("tpp");
                int nppt = rSet.getInt("nppt");
                System.out.printf("%-50s%-10.2f%-5d%-5d\n",name,price,tpp,nppt);
            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

}
