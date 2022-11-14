package com.curso.usermanagment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author acabezam
 */
public class User {
    private String username;
    private String email;
    private String securityQuestion;
    private String password;
    private HashMap<User, ArrayList<Message>> recievedMessages = new HashMap<>();

    public User(){
        username = "";
        email = "";
        securityQuestion = "";
        password = "";
    }
    
    public User(String name, String email, String password){
        this.username = name;
        this.email = email;
        this.password = password;
    }
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<User> getMessagesSenders(){
        return recievedMessages.keySet();
    }
    
    public String toString(){
        String text = "";
        
        text += "Email: " + email + " Username: " + username + " Password: " + password;
        
        return text;
    }
}
