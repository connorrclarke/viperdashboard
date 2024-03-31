/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhscs3.viperdashboard;

import java.io.Serializable;
import java.util.TreeMap;

/**
 *
 * @author Clarke_876632
 */
public class VDModel implements Serializable{
    
    private TreeMap<Integer, Case> cases;
    private TreeMap<String, Schedule> schedules;

    public VDModel(TreeMap<Integer, Case> cases, TreeMap<String, Schedule> schedules) {
        this.cases = cases;
        this.schedules = schedules;
    }

    public TreeMap<Integer, Case> getCases() {
        return cases;
    }

    public TreeMap<String, Schedule> getSchedules() {
        return schedules;
    }
}