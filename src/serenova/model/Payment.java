/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.model;
import java.time.LocalDate;
import java.math.BigDecimal;

/**
 *
 * @author HP
 */
public class Payment {
    
    private Integer paymentId,
            reservationId;
    private LocalDate paymentDate;
    private BigDecimal amount;
    private String paymentMethod;
    
    public Payment(){
        
    }
    
    public Payment(Integer reservationId,LocalDate date,BigDecimal amount,String method){
        this.reservationId = reservationId;
        this.paymentDate = date;
        this.amount = amount;
        this.paymentMethod = method;
    }
    
    public void setPaymentId(Integer id){
        this.paymentId = id;
    }
    public void setReservationId(Integer id){
        this.reservationId = id;
    }
    public void setPaymentDate(LocalDate date){
        this.paymentDate = date;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    public void setPaymentMethod(String method){
        this.paymentMethod = method;
    }
    
    public Integer getPaymentId(){
        return paymentId;
    }
     public Integer getReservationId(){
        return reservationId;
    }
     public LocalDate getPaymentDate(){
         return paymentDate;
     }
     public BigDecimal getAmount(){
         return amount;
     }
     public String getPaymentMethod(){
         return paymentMethod;
     }
    
}
