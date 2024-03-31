/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhscs3.viperdashboard;

import java.io.Serializable;

/**
 *
 * @author irad_Allen
 */
public class Schedule implements Comparable, Serializable{
    
    private String      id;                     // Unique identifies for the schedule
    private Period[]    periods;                // Array of 9 periods to represent the schedule

    // Constructor

    public Schedule(String id, Period[] periods) {
        this.id = id;
        this.periods = periods;
    }
    
    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Period[] getPeriods() {
        return periods;
    }

    public void setPeriods(Period[] periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        
        String text = id + " - \n";
        
        for (int i=0; i<periods.length; i++) {
            text += "\t" + (i+1)+ ") " + periods[i].toString()+"\n";
        }      
        
        return text;
    }
    


    @Override
    public int compareTo(Object o) {
        try {
            int idNumThis = Integer.parseInt(this.getId());
            int idNumThat = Integer.parseInt(((Schedule) o).getId());
            
            if (idNumThis >  idNumThat)      return 1;
            if (idNumThis <  idNumThat)      return -1;
            if (idNumThis == idNumThat)      return 0;
            
        } catch (NumberFormatException e) {
            return this.id.compareTo((String)o);
            
        }
        
        return 0;
        
    }
}
