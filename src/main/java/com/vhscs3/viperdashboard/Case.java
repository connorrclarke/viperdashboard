/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhscs3.viperdashboard;

import java.io.Serializable;
import java.util.GregorianCalendar;


public class Case extends Schedule implements Serializable{
    
    private GregorianCalendar    reportDate;	// date case was reported on LISD
    private GregorianCalendar   locationDate;	// last date period on campus
    private boolean confirmed;			// Specifies confirmed (true) or probable (false)
    private boolean student;                    // Specifies student (true)  or staff (false)
    private Integer grade;                      // Specifies grade level (9-12, teachers = -1)   

    
    // Constructors
    public Case(GregorianCalendar reportDate, GregorianCalendar locationDate, boolean confirmed, boolean student, Integer grade, String id, Period[] periods) {
        super(id, periods);
        this.reportDate = reportDate;
        this.locationDate = locationDate;
        this.confirmed = confirmed;
        this.student = student;
        this.grade = grade;

    }
    
    // Getters and Setters
    // Don't want data manipulated, so Setters are not included

    public GregorianCalendar getReportDate() {
        return reportDate;
    }

    public GregorianCalendar getLocationDate() {
        return locationDate;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public boolean isStudent() {
        return student;
    }

    public Integer getGrade() {
        return grade;
    }
    
    public String getId() {
        return super.getId();
    }
    
    public Period[] getPeriods() {
        return super.getPeriods();
    }
    
    @Override
    public String toString() {
        
        String gradeOrStaff = (student)? "Grade: "+grade : "Staff";
        
        String text = this.getId() + " - " + gradeOrStaff + " (" + reportDate.getTime() + ", " + locationDate.getTime() + ")\n";
        
        for (int i=0; i<this.getPeriods().length; i++) {
            text += "\t" + (i+1)+ ") " + this.getPeriods()[i].toString()+"\n";
        }
        
        return text;
    }
    
}
