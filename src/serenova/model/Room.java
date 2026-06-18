/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.model;
import java.math.BigDecimal;

/**
 *
 * @author HP
 */
public class Room {
    
    private Integer roomId;
    private String roomNumber,
            roomType,
            status;
    private BigDecimal pricePerNight;
    
    public void setRoomId(Integer id){
        this.roomId = id;
    }
    
    public void setRoomNumber(String number){
        this.roomNumber = number;
    }
    
    public void setRoomType(String type){
        this.roomType = type;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setPricePerNight(BigDecimal price){
        this.pricePerNight = price;
    }
    
    public Integer getRoomId(){
        return roomId;
    }
    
    public String getRoomNumber(){
        return roomNumber;
    }
    
    public String getRoomType(){
        return roomType;
    }
    
    public String getStatus(){
        return status;
    }
    
    public BigDecimal getPricePerNight(){
        return pricePerNight;
    }
    
    public Room(){
        
    }
    
    public Room(String number, String type, String status,BigDecimal price){
        this.roomNumber = number;
        this.roomType = type;
        this.status = status;
        this.pricePerNight = price;
        
    }
    
}
