/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.usermanagment;

/**
 *
 * @author acabezam
 */
public class Message {
    private String date;
    private String hour;
    private String text;
    
    public Message(String text){
        this.text = text;
    }
    
    public String getText(){
        return text;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getHour(){
        return hour;
    }
    
}
