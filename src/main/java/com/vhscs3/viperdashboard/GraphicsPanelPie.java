/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhscs3.viperdashboard;

import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.CYAN;
import static java.awt.Color.GREEN;
import static java.awt.Color.LIGHT_GRAY;
import static java.awt.Color.ORANGE;
import static java.awt.Color.PINK;
import static java.awt.Color.RED;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Clarke_876632
 */
public class GraphicsPanelPie extends JPanel {
    //percentage cases by grade and month
    
    private int[] values; 

    public void setValues(int[] values) {
        this.values = values;
        
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        //Draw circle outline
        g.setColor(BLACK);
        g.drawOval(100, 125, 300, 300);
        
        g.drawString("Percentage of Cases by...", 15, 20);
        
        g.setColor(RED);
        Font newFont = new Font("Dialog", Font.ROMAN_BASELINE, 20);
        g.setFont(newFont);
        g.drawString("Vandegrift HS is currently in STAGE 5", 75, 550);
        
        g.setColor(BLACK);
        g.drawString("There have been _____ total cases at Vandegrift", 35, 650);
        g.drawString("There have been _____ cases this month", 65, 750);
        
        if (values == null) return;
                
        Color[] colors = {GREEN, CYAN, LIGHT_GRAY, PINK, ORANGE};
        
        int colorNum = 0;
        
        int total = 0;
        for (int num : values) {
            total = num + total;
        }
        int start = 0;
        
        for (int num : values) {
        
            g.setColor(colors[colorNum]);
            
            double percent = ((num * 100) / (double) total);
            double angle = ((360 * percent) / 100);
            
            g.fillArc(100, 125, 300, 300, start, (int)(angle + 0.5));

            colorNum += 1;
            start = start + (int)(angle + 0.5);
        }
        
        g.setColor(BLACK);
        g.drawOval(100, 125, 300, 300);
        
        
        Font numFont = new Font("Dialog", Font.ROMAN_BASELINE, 40);
        g.setFont(numFont);
        g.setColor(ORANGE);
        int cases = 0;
        for (int v : values){
            cases = cases + v;
        }
        g.drawString(Integer.toString(cases), 193, 650);
        g.drawString("8", 234, 750);
    }
}