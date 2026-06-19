package serenova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import serenova.db.DBConnection;
import serenova.model.User;

/**
 *
 * @author HP
 */
public class UserDAO {
    
    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getPassword());
        pst.setString(3, user.getRole());
        
        int rows = pst.executeUpdate();
        return rows > 0;
    }
    
    public User getUserById(Integer userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id=?";
        
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1, userId);
        
        ResultSet rst = pst.executeQuery();
        
        if (rst.next()) {
            User user = new User();
            user.setUserId(rst.getInt("user_id"));
            user.setUsername(rst.getString("username"));
            user.setPassword(rst.getString("password"));
            user.setRole(rst.getString("role"));
            return user;
        }
        return null;
    }
    
    public User getUserByName(String userName) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=?";
        
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, userName);
        
        ResultSet rst = pst.executeQuery();
        
        if (rst.next()) {
            User user = new User();
            user.setUserId(rst.getInt("user_id"));
            user.setUsername(rst.getString("username"));
            user.setPassword(rst.getString("password"));
            user.setRole(rst.getString("role"));
            return user;
        }
        return null;
    }
    
    public boolean updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET username=?, password=?, role=? WHERE user_id=?";
        
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, user.getUsername());
        pst.setString(2, user.getPassword());
        pst.setString(3, user.getRole());
        pst.setInt(4, user.getUserId());
        
        int rows = pst.executeUpdate();
        return rows > 0;
    }
    
    public boolean deleteUser(Integer userId) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id = ?";
        
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt(1, userId);
        
        int rows = pst.executeUpdate();
        return rows > 0;
    }
}
