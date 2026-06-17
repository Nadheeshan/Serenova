/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DBConnection {
    
    private static final String DBURL = "jdbc:mysql://localhost:3306/serenova_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";
    private static Connection instance;
    
    private DBConnection(){
      
    }
    
    public static Connection getInstance() throws SQLException{
        
        if(instance == null || instance.isClosed()){
            
            instance = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        }
        
        return instance;
        
    }
}
