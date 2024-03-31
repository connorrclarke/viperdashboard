/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhscs3.viperdashboard;

import java.awt.Dimension;
import java.io.Serializable;

/**
 *
 * @author gupta_934507
 */
public class Period implements Serializable{
    
    private String        teacher;          // Teacher name formatted Last, First
    private String        name;             // Course Name specified on LISD Dashboard
    private String        room;             // Room designater specified by LISD Dashboard
    private Dimension     location;         // x, y coordinate values that locate the period on a map
    
    //  Constructors

    public Period(String teacher, String name, String room, Dimension location) {
        this.teacher = teacher;
        this.name = name;
        this.room = room;
        this.location = location;
    }
    
    // Getters and Setters
    // Don't want data to be manipulated, so "setters" are not provided

    public String getTeacher() {
        return teacher;
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public Dimension getLocation() {
        return location;
    }

    @Override
    public String toString() {
        // Does not include the Dimension instance variable        
        return "Period{" + name + ", " + teacher + ", " + room + '}';
    } 
    
}
    
    
