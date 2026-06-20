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
import serenova.model.Payment;

/**
 *
 * @author HP
 */
public class PaymentDAO {

    public boolean addPayment(Payment payment) throws SQLException{

        String sql = "INSERT INTO payments (reservation_id,payment_date,amount,payment_method) VALUES (?,?,?,?)";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, payment.getReservationId());
        pst.setDate(2, Date.valueOf(payment.getPaymentDate()));
        pst.setBigDecimal(3, payment.getAmount());
        pst.setString(4, payment.getPaymentMethod());

        int rows = pst.executeUpdate();

        return rows > 0;
    }

    public boolean updatePayment(Payment payment) throws SQLException{

        String sql = "UPDATE payments SET reservation_id=?,payment_date=?,amount=?,payment_method=? WHERE payment_id=?";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, payment.getReservationId());
        pst.setDate(2, Date.valueOf(payment.getPaymentDate()));
        pst.setBigDecimal(3, payment.getAmount());
        pst.setString(4, payment.getPaymentMethod());
        pst.setInt(5, payment.getPaymentId());

        int rows = pst.executeUpdate();

        return rows > 0;
    }

    public boolean deletePayment(Integer paymentId) throws SQLException{

        String sql = "DELETE FROM payments WHERE payment_id=?";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, paymentId);
        
        int rows = pst.executeUpdate();

        return rows > 0;
    }

    public List<Payment> getAllPayments() throws SQLException{

        String sql = "SELECT * FROM payments";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rst = pst.executeQuery();
        List<Payment> payments = new ArrayList<>();

        while (rst.next()){

            Payment payment = new Payment();
            
            payment.setPaymentId(rst.getInt("payment_id"));
            payment.setReservationId(rst.getInt("reservation_id"));
            payment.setPaymentDate(rst.getDate("payment_date").toLocalDate());
            payment.setAmount(rst.getBigDecimal("amount"));
            payment.setPaymentMethod(rst.getString("payment_method"));

            payments.add(payment);

        }

        return payments;

    }

    public Payment getPaymentsById(Integer paymentId) throws SQLException{

        String sql = "SELECT * FROM payments WHERE payment_id=?";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, paymentId);

        ResultSet rst = pst.executeQuery();

        if (rst.next()){

            Payment payment = new Payment();
            
            payment.setPaymentId(rst.getInt("payment_id"));
            payment.setReservationId(rst.getInt("reservation_id"));
            payment.setPaymentDate(rst.getDate("payment_date").toLocalDate());
            payment.setAmount(rst.getBigDecimal("amount"));
            payment.setPaymentMethod(rst.getString("payment_method"));

            return payment;

        }
        
        return null;

    }

    public Payment getPaymentsByReservationId(Integer reservationId) throws SQLException{

        String sql = "SELECT * FROM payments WHERE reservation_id=?";
        Connection con = DBConnection.getInstance();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, reservationId);

        ResultSet rst = pst.executeQuery();

        if (rst.next()){

            Payment payment = new Payment();
            
            payment.setPaymentId(rst.getInt("payment_id"));
            payment.setReservationId(rst.getInt("reservation_id"));
            payment.setPaymentDate(rst.getDate("payment_date").toLocalDate());
            payment.setAmount(rst.getBigDecimal("amount"));
            payment.setPaymentMethod(rst.getString("payment_method"));

            return payment;

        }
        
        return null;

    }

    
}
