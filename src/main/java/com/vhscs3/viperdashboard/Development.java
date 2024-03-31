/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhscs3.viperdashboard;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Development {
    
    private TreeSet<Case> cases;
    private TreeMap<String, Schedule> schedules;   

    public Development() {
        
        cases       = new TreeSet<>();
        schedules   = new TreeMap<>();
        
        loadSampleData();
   
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Development d = new Development();
    }

    private void loadSampleData() {
        loadCasesFromFile();
        loadSchedulesFromFile(); 
    }

    private void loadCasesFromFile() {
        try {
            // Use a Scanner object to read static data from a csv file.
            // Data is a copy of the rawdata from the LISD COVID19 dashboard.
            // Method will only add Vandegrift HS Cases to the Cases TreeSet.

            Scanner file = new Scanner(new File("dat\\caseData.csv"));
            
            // First two lines of the dat file include column headers and general
            // information.  Will need to skip these lines to start reading case data.
            file.nextLine();
            file.nextLine();
            
            while (file.hasNextLine()) {
                
                String line = file.nextLine();
                Scanner lineData = new Scanner(line);
                lineData.useDelimiter(",");
                
                // Read the data and assigned to variables for prociessing
                String lstDate      = lineData.next();
                String caseNum      = lineData.next();
                String rprtDate     = lineData.next();
                String staffStudent = lineData.next();
                String location     = lineData.next();

                // For cases that have a location as Vandegrift HS
                // Process/convert/cast data strings into the correct data types
                // Creat a Case and add case to the <cases> TreeSet
                if (location.equals("Vandegrift HS")) {
                    
                    String gr           = lineData.next();
                    String esRoom       = lineData.next();
                    String period1      = lineData.next();
                    String period2      = lineData.next();
                    String period3      = lineData.next();
                    String period4      = lineData.next();
                    String period5      = lineData.next();
                    String period6      = lineData.next();
                    String period7      = lineData.next();
                    String period8      = lineData.next();
                    String period9      = lineData.next();
                    
                    // Convert the lastDate and reportDate strings into a Gregorian Calender Object
                    GregorianCalendar lastDate = getDate(lstDate);
                    GregorianCalendar reportDate = getDate(rprtDate);
                    
                    boolean student = staffStudent.equals("Student");
                    
                    // Build Period[] array for the Schedule Constructor from Case
                    Period[] periods = new Period[9];
                    String[] courses = {period1, period2, period3, period4, period5,period6, period7, period8, period9};
                  
                    for (int i=0; i<periods.length; i++) {
                        periods[i] = new Period("", courses[i], "", new Dimension());
                    }
                    
                    
                    // Staff are assigned a default grade of 0
                    // Students will use the grade field from the LISD Dashbaord data.
                    // Student grade level must be stripped from the grade field
                    // so that there is only a numeric value.
                    Integer grade = 0;
                    
                    if (student) {                    
                        grade = Integer.parseInt(gr.substring(0,gr.indexOf("t")));
                    }
                    
                    Case c = new Case(reportDate, lastDate, true, student, grade, caseNum, periods);
                    
                    cases.add(c);
                
                }
                
            }

            // Print all the cases to check formatting and accuracy
            
            Iterator<Case> it = cases.iterator();
            
            for (Case c : cases ) {
                System.out.println(c);
            }
            
            System.out.println(cases.size());
                       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Development.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loadSchedulesFromFile() {
        // 
    }

    private GregorianCalendar getDate(String date) {
        
        String[] digits = date.split("/");
        
        int month   = Integer.parseInt(digits[0]);
        int day     = Integer.parseInt(digits[1]);
        int year    = Integer.parseInt(digits[2]);
        
        return new GregorianCalendar(year, month, day);
    }
    
}
