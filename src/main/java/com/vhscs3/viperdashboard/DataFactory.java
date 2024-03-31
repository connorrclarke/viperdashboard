/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhscs3.viperdashboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clarke_876632
 */
public class DataFactory {
    
    private ArrayList<Course> courses;
    
    public DataFactory() {
        
        courses = new ArrayList<>();
        loadMasterSchedule();
        
        //System.out.println(courses.size());
        //System.out.println(getCourses("CTE", 1).length);
        
    }
    
    public static void main(String[] args) {
        
        DataFactory df = new DataFactory();
        
    }

    private void loadMasterSchedule() {
    //Reads the data from masterSchedule.csv, creates a course, and adds
    //the course to the <courses> ArrayList.
    
        try {
            Scanner file;
            file = new Scanner(new File("dat" + File.separator + "masterSchedule.csv"));

            while (file.hasNextLine()) {

                Scanner line = new Scanner(file.nextLine());
                line.useDelimiter(",");

                String  rm = line.next();
                String  ds = line.next();
                String  id = line.next();
                int     pr = line.nextInt();
                String  dp = line.next();

                courses.add(new Course(rm, ds, id, pr, dp));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] getCourses(String department, int period) {
        
        TreeSet<String> found = new TreeSet<>();
        
        for (Course course : courses) {
            if (course.department.equals(department) && (course.period == period)) {
                found.add(course.description);
            }
        }
        return found.toArray(new String[found.size()]);
    }
    
    public String[] getSections(String description, int period) {
        
        TreeSet<String> found = new TreeSet<>();
        
        for (Course course : courses) {
            if (course.description.equals(description) && (course.period == period)) {
                found.add(course.room);
            }           
        }
        return found.toArray(new String[found.size()]);
    }
    
    public String getIdentifier(String description, int period, String room) {
        
        for (Course course : courses) {
            if (course.description.equals(description) && (course.period == period) && (course.room.equals(room)))
                return course.identifier;
        }
        return "";
    }

    // =============== INNER CLASS ===============
    private static class Course {

        private String  room;
        private String  description;
        private String  identifier;
        private int     period;
        private String  department;

        public Course(String room, String description, String identifier, int period, String department) {
            this.room = room;
            this.description = description;
            this.identifier = identifier;
            this.period = period;
            this.department = department;
        }
        
        
        
    }
    
}
