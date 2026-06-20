/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.controller;
import java.sql.SQLException;
import serenova.dao.UserDAO;
import serenova.model.User;

/**
 *
 * @author HP
 */
public class UserController {

    public boolean login(String username, String password) throws SQLException{

        UserDAO user = new UserDAO();
        User newUser = user.getUserByName(username);

        if (newUser!= null){

            if (newUser.getPassword().equals(password)){

                return true;
            }

            else{

                return false;
            }
        }

        else{

            return false;
        }

    }
    
}
