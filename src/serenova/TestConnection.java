/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova;
import serenova.db.DBConnection;
import java.sql.*;

/**
 *
 * @author HP
 */
public class TestConnection {
    
    public static void main (String[]args)
    {
        try
        {
            DBConnection.getInstance();
            System.out.println("Connected Succesfully");
        }
        catch(SQLException e)
        {
            System.out.println("Connection Failed");
            System.out.println(e);
        }

    }
}
