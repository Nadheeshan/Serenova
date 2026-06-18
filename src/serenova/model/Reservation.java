/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

/**
 *
 * @author HP
 */
public class Reservation {
    
    private Integer reservationId,
            guestId,
            roomId;
    private LocalDate checkInDate,
            checkOutDate;
    private LocalDateTime createdAt;
    private String status;
    private BigDecimal totalAmount;
    
    public Reservation(){
        
    }
    
    public Reservation(Integer guestId , Integer roomId, LocalDate checkIn, LocalDate checkOut, String status, BigDecimal total){
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
        this.status = status;
        this.totalAmount = total;
    }
    
    public void setReservationId(Integer id){
        this.reservationId = id;
    }
    public void setGuestId(Integer guestId){
        this.guestId = guestId;
    }
    public void setRoomId(Integer roomId){
        this.roomId = roomId;
    }
    public void setCheckInDate(LocalDate checkIn){
        this.checkInDate = checkIn;
    }
    public void setCheckOutDate(LocalDate checkOut){
        this.checkOutDate = checkOut;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setTotalAmount(BigDecimal total){
        this.totalAmount = total;
    }
    
    public Integer getReservationId(){
        return reservationId;
    }
    public Integer getGuestId(){
        return guestId;
    }
    public Integer getRoomId(){
        return roomId;
    }
    public LocalDate getCheckInDate(){
        return checkInDate;
    }
    public LocalDate getCheckOutDate(){
        return checkOutDate;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public String getStatus(){
        return status;
    }
    public BigDecimal getTotalAmount(){
        return totalAmount;
    }
}
