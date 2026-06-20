/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serenova.db.DBConnection;
import serenova.model.Room;

/**
 *
 * @author HP
 */
public class RoomDAO {

    public boolean addRoom(Room room) throws SQLException{

        String sql ="INSERT INTO rooms (room_number,room_type,price_per_night,status) VALUES (?,?,?,?)";

        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1,room.getRoomNumber());
        pst.setString(2,room.getRoomType());
        pst.setBigDecimal(3, room.getPricePerNight());
        pst.setString(4,room.getStatus());

        int rows = pst.executeUpdate();
        return rows > 0;

    }

    public Room getRoomById(Integer roomId) throws SQLException{

        String sql = "SELECT * FROM rooms WHERE room_id = ?";

        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, roomId);

        ResultSet rst = pst.executeQuery();

        if (rst.next()){

            Room room = new Room();
            room.setRoomId(rst.getInt("room_id"));
            room.setRoomNumber(rst.getString("room_number"));
            room.setRoomType(rst.getString("room_type"));
            room.setPricePerNight(rst.getBigDecimal("price_per_night"));
            room.setStatus(rst.getString("status"));

            return room;
        }

        return null;
    }

    public boolean updateRoom(Room room) throws SQLException{

        String sql ="UPDATE rooms SET room_number=?,room_type=?,price_per_night=?,status=? WHERE room_id=?";

        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1,room.getRoomNumber());
        pst.setString(2,room.getRoomType());
        pst.setBigDecimal(3, room.getPricePerNight());
        pst.setString(4,room.getStatus());
        pst.setInt(5, room.getRoomId());

        int rows = pst.executeUpdate();
        return rows > 0;

    } 

    public boolean deleteRoom(Integer roomId) throws SQLException{

        String sql = "DELETE FROM rooms WHERE room_id=?";

        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, roomId);
        int rows = pst.executeUpdate();

        return rows > 0;
    }

    public List<Room> getAllRooms() throws SQLException{

        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT * FROM rooms";

        Connection con  = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rst = pst.executeQuery();

        while (rst.next()){

            Room room = new Room();
            room.setRoomId(rst.getInt("room_id"));
            room.setRoomNumber(rst.getString("room_number"));
            room.setRoomType(rst.getString("room_type"));
            room.setPricePerNight(rst.getBigDecimal("price_per_night"));
            room.setStatus(rst.getString("status"));

            
            
            rooms.add(room);

        }

         return rooms;
    }

    public List<Room> getAvailableRooms() throws SQLException{

        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT * FROM rooms WHERE status=?";

        Connection con  = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1,"Available");
        ResultSet rst = pst.executeQuery();

        while (rst.next()){

            Room room = new Room();
            room.setRoomId(rst.getInt("room_id"));
            room.setRoomNumber(rst.getString("room_number"));
            room.setRoomType(rst.getString("room_type"));
            room.setPricePerNight(rst.getBigDecimal("price_per_night"));
            room.setStatus(rst.getString("status"));

            
            
            rooms.add(room);

        }

         return rooms;
    }




    
}
