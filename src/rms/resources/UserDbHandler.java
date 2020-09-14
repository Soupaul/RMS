package rms.resources;

import java.sql.*;

public class UserDbHandler {

    private final String DB_URL = "jdbc:mysql://localhost:3306/rms?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "007hrit@mysql";

    public void registerStaff(String name,String password,int age,double salary){

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String salt = Utils.genRandomSalt();
            String encPass = Utils.encryptPassword(password,salt);
            String sqlInsert = "INSERT INTO staff (name,salt,password,age,salary) VALUES ( '" + name + "', '" + salt + "', '" + encPass + "', " + age + ", " + salary + " )";
            int countInserted = stmt.executeUpdate(sqlInsert);
            if(countInserted != 0) System.out.println("Staff member successfully registered");

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void loginStaff(String name,String password){

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String sqlSelect = "SELECT salt,password from staff WHERE name = '" + name + "'";
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            rSet.next();
            String dbSalt = rSet.getString("salt");
            String dbPass = rSet.getString("password");

            String pass = Utils.encryptPassword(password,dbSalt);

            if(dbPass.equals(pass))
                System.out.println("Login successful");
            else
                System.out.println("Login unsuccessful");

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void deleteStaff(String name){

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String sqlDelete = "DELETE FROM staff WHERE name = '" + name + "'";
            int countDeleted = stmt.executeUpdate(sqlDelete);
            if(countDeleted != 0) System.out.println("Staff member record deleted");

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public void displayStaffInfo(){

        try(

                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt = conn.createStatement();

        ){

            String strSelect = "SELECT name,age,salary FROM staff";
            ResultSet rSet = stmt.executeQuery(strSelect);

            System.out.printf("%-20s%-10s%-10s\n","Name","Age","Salary");
            while(rSet.next()) {
                String name = rSet.getString("name");
                int age = rSet.getInt("age");
                double salary = rSet.getDouble("salary");
                System.out.printf("%-20s%-10d%-10.2f\n",name,age,salary);
            }

        }
        catch(SQLException ex){
            ex.printStackTrace();
        }

    }

}
