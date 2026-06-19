/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serenova.model;

/**
 *
 * @author HP
 */
public class User {
    private Integer userId;
    private String username,
            password,
            role;
    
    public User(){
        
    }
    
    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public void setUserId(Integer id){
        this.userId = id;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setRole(String role){
        this.role = role;
    }
    
    public Integer getUserId(){
        return userId;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
        
}
