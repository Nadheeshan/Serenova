/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova;

import serenova.dao.GuestDAO;
import serenova.model.Guest;

/**
 *
 * @author HP
 */
public class TestConnection {
    
    public static void main (String[]args)
    {
        try {

            GuestDAO dao = new GuestDAO();

            Guest g = new Guest("Nahdeeshan","200126602837","0760354685","rkshan1459@gmail.com","colombo");
            dao.addGuest(g);
            Guest g2 = new Guest("Danu","200126602837","0760354685","rkshan1459@gmail.com","colombo");
            g2.setGuestId(1);
            dao.updateGuest(g2);
            
            dao.deleteGuest(6);
            
            Guest g3 = dao.getGuestById(1);
            if(g3 != null){
                
                System.out.println(g3.getFullName());
            }
            
            


        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
