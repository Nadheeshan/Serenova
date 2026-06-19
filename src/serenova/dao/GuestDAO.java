/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import serenova.db.DBConnection;
import serenova.model.Guest;

/**
 *
 * @author HP
 */
public class GuestDAO {
    
    public boolean addGuest(Guest guest) throws SQLException{
        
        String sql = "INSERT INTO guests (full_name,nic_passport,phone,email,address) VALUES (?,?,?,?,?)";
        
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1,guest.getFullName());
        pst.setString(2,guest.getNicPassport());
        pst.setString(3,guest.getPhone());
        pst.setString(4,guest.getEmail());
        pst.setString(5,guest.getAddress());
        
        int rows = pst.executeUpdate();
        return rows>0;
        
        
        
    }
    
    public Guest getGuestById(Integer guestId) throws SQLException{
        
        String sql = "SELECT * FROM guests WHERE guest_id=?";

        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, guestId);

        ResultSet rst = pst.executeQuery();

        if (rst.next()){

            Guest guest = new Guest();
            guest.setGuestId(rst.getInt("guest_id"));
            guest.setFullName(rst.getString("full_name"));
            guest.setNicPassport(rst.getString("nic_passport"));
            guest.setPhone(rst.getString("phone"));
            guest.setEmail(rst.getString("email"));
            guest.setAddress(rst.getString("address"));

            return guest;

        }

        return null;

    }
    
    public boolean updateGuest(Guest guest) throws SQLException{
        
        String sql = "UPDATE guests SET full_name=?,nic_passport=?,phone=?,email=?,address=? WHERE guest_id=?";
        
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1,guest.getFullName());
        pst.setString(2,guest.getNicPassport());
        pst.setString(3,guest.getPhone());
        pst.setString(4,guest.getEmail());
        pst.setString(5,guest.getAddress());
        pst.setInt(6,guest.getGuestId());
        
        int rows = pst.executeUpdate();
        return rows > 0;
        
    }
    
    public boolean deleteGuest(Integer guestId) throws SQLException{
        
        String sql = "DELETE FROM guests WHERE guest_id = ?";
        
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1,guestId);
        
        int rows = pst.executeUpdate();
        return rows > 0;
    }
}
