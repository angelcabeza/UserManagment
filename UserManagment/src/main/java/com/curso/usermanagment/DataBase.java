/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.usermanagment;

import java.util.HashMap;

/**
 *
 * @author acabezam
 */
public class DataBase {
    private HashMap<String, User> database = new HashMap<>();
    private String loggedUser;
    
    public DataBase(){};
    
    public boolean register(String email, String username, String password){
        User newUser = new User(username, email ,password);
        
        if (!database.containsKey(email)){
            database.put(email, newUser);
            return true;
        } else {
            System.out.println("Username ya existe");
        }
        
        return false;
    }
    
    public boolean login(String username, String password){
        if (database.containsKey(username)){
            if (checkHasSamePswd(username,password)){
                loggedUser = database.get(username).getEmail();
                return true;
            }
        }
        
        return false;
    }
    
    private boolean checkUserExist(String username){
        return database.containsKey(username);
    }
    
    public boolean checkHasSamePswd(String username, String password){
        return database.get(username).getPassword().equals(password);
    }
    
    public boolean isLoggedIn(){
        return loggedUser != null;
    }
    
    public boolean logIn(String username, String password){
        if (checkUserExist(username) && checkHasSamePswd(username, password)){
            loggedUser = username;
            return true;
        } else {
            return false;
        }
    }
    
    public void setSecurityQuestion(String text){
        getLoggedUser().setSecurityQuestion(text);
    }
    
    public User getLoggedUser(){
        return database.get(loggedUser);
    }
    
    public void changeEmail(String email){
        User newUser = database.get(loggedUser);
        newUser.setEmail(email);
        
        database.remove(email);
        database.put(email, newUser);
    }
    
    public void changePassword(String newPassword){
        database.get(loggedUser).setPassword(newPassword);
    }
    
    public void logOut(){
        loggedUser = null;
    }
}
