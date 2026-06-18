/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.model;

/**
 *
 * @author HP
 */
public class Guest {
    
    private Integer guestId;
    private String fullName,
            nicPassport,
            phone,
            email,
            address;
    
    public void setGuestId(Integer id){
        this.guestId = id;
    }
    
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    public void setNicPassport(String nic){
        this.nicPassport = nic;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public Integer getGuestId(){
        return guestId;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public String getNicPassport(){
        return nicPassport;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getAddress(){
        return address;
    }
    
    public Guest(){
        
    }
    
    public Guest(String fullName, String nicPassport, String phone, String email, String address ){
        this.fullName = fullName;
        this.nicPassport = nicPassport;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
    
    
   
}
            
        
       
    

