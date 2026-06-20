/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import serenova.db.DBConnection;
import serenova.model.Reservation;

/**
 *
 * @author HP
 */
public class ReservationDAO {

    public boolean addReservation(Reservation reservation) throws SQLException{

        String sql = "INSERT INTO reservations (guest_id,room_id,checkin_date,checkout_date,total_amount,status) VALUES (?,?,?,?,?,?)";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, reservation.getGuestId());
        pst.setInt(2, reservation.getRoomId());
        pst.setDate(3, Date.valueOf(reservation.getCheckInDate()));
        pst.setDate(4, Date.valueOf(reservation.getCheckOutDate()));
        pst.setBigDecimal(5, reservation.getTotalAmount());
        pst.setString(6, reservation.getStatus());

        int rows = pst.executeUpdate();

        return rows > 0;

    }

    public Reservation getReservationById(Integer reservationId) throws SQLException{

        String sql = "SELECT * FROM reservations WHERE reservation_id = ?";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, reservationId);

        ResultSet rst = pst.executeQuery();

        if (rst.next()){

            Reservation  reservation = new Reservation();

            reservation.setReservationId(rst.getInt("reservation_id"));
            reservation.setGuestId(rst.getInt("guest_id"));
            reservation.setRoomId(rst.getInt("room_id"));
            reservation.setCheckInDate(rst.getDate("checkin_date").toLocalDate());
            reservation.setCheckOutDate(rst.getDate("checkout_date").toLocalDate());
            reservation.setTotalAmount(rst.getBigDecimal("total_amount"));
            reservation.setStatus(rst.getString("status"));
            reservation.setCreatedAt(rst.getTimestamp("created_at").toLocalDateTime());

            return reservation;

        }

        return null;
    }

    public List<Reservation> getAllReservation() throws SQLException{

        String sql = "SELECT * FROM reservations";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);


        ResultSet rst = pst.executeQuery();

        List<Reservation> reservations = new ArrayList<>();


        while (rst.next()){

            Reservation  reservation = new Reservation();

            reservation.setReservationId(rst.getInt("reservation_id"));
            reservation.setGuestId(rst.getInt("guest_id"));
            reservation.setRoomId(rst.getInt("room_id"));
            reservation.setCheckInDate(rst.getDate("checkin_date").toLocalDate());
            reservation.setCheckOutDate(rst.getDate("checkout_date").toLocalDate());
            reservation.setTotalAmount(rst.getBigDecimal("total_amount"));
            reservation.setStatus(rst.getString("status"));
            reservation.setCreatedAt(rst.getTimestamp("created_at").toLocalDateTime());

            reservations.add(reservation);
        }

        return reservations;


    }

    public boolean updateReservation(Reservation reservation) throws SQLException{

        String sql = "UPDATE reservations SET guest_id=?,room_id=?,checkin_date=?,checkout_date=?,total_amount=?,status=? WHERE reservation_id=?";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, reservation.getGuestId());
        pst.setInt(2, reservation.getRoomId());
        pst.setDate(3, Date.valueOf(reservation.getCheckInDate()));
        pst.setDate(4, Date.valueOf(reservation.getCheckOutDate()));
        pst.setBigDecimal(5, reservation.getTotalAmount());
        pst.setString(6, reservation.getStatus());
        pst.setInt(7, reservation.getReservationId());

        int rows = pst.executeUpdate();

        return rows > 0;

    }

    public boolean deleteReservation(Integer reservationId) throws SQLException{

        String sql = "DELETE FROM reservations WHERE reservation_id=?";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, reservationId);

        int rows = pst.executeUpdate();

        return rows > 0;

    }

    public List<Reservation> getReservationByGuestId(Integer guestId) throws SQLException{

        String sql = "SELECT * FROM reservations WHERE guest_id = ?";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, guestId);

        ResultSet rst = pst.executeQuery();
        List<Reservation> reservations = new ArrayList<>();

        while (rst.next()){

            Reservation  reservation = new Reservation();

            reservation.setReservationId(rst.getInt("reservation_id"));
            reservation.setGuestId(rst.getInt("guest_id"));
            reservation.setRoomId(rst.getInt("room_id"));
            reservation.setCheckInDate(rst.getDate("checkin_date").toLocalDate());
            reservation.setCheckOutDate(rst.getDate("checkout_date").toLocalDate());
            reservation.setTotalAmount(rst.getBigDecimal("total_amount"));
            reservation.setStatus(rst.getString("status"));
            reservation.setCreatedAt(rst.getTimestamp("created_at").toLocalDateTime());

            reservations.add(reservation);

        }

        return reservations;

    }

    public boolean updateReservationStatus(Integer reservationId, String status ) throws SQLException{

        String sql ="UPDATE reservations SET status=? WHERE reservation_id=? ";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, status);
        pst.setInt(2, reservationId);

        int rows = pst.executeUpdate();

        return rows > 0;
    }





    
}
