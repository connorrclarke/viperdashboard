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
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Clarke_876632
 */
public class GraphicsPanelCBM extends JPanel {
    
    private int[] months;

    public void setMonths(int[] months) {
        this.months = months;
        
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        //Draw X and Y axis
        g.setColor(BLACK);
        g.drawLine(40, 40, 40, 500);
        g.drawLine(40, 500, 460, 500);
        
        g.drawString("Cases by Month", 15, 20);
        
        //Draw Y axis tick marks
        int yTicks = 500;
        int yValue = 1;
        while (yTicks > 40) {
            yTicks -= 15;
            if (yTicks >= 40){
                g.drawLine(35, yTicks, 45, yTicks);
                g.drawString(String.valueOf(yValue), 20, yTicks+5);
                yValue++;
            }
        }
        
        //Draw X axis labels
        g.drawString("Aug", 106, 515);
        g.drawString("Sep", 240, 515);
        g.drawString("Oct", 375, 515);
        
        Font newFont = new Font("Dialog", Font.ROMAN_BASELINE, 20);
        g.setFont(newFont);
        g.drawString("There were _____ cases in September", 90, 650);
        
        if (months == null) return;
        
        int buffer = 20;
        int graphUnit = 420;  //x-axis space
        int barWidth = (graphUnit - (months.length + 1) * buffer) / months.length;
        int barUnit = 15;
        
        int xPos = buffer + 40;
        
        Color[] colors = {GREEN, CYAN, LIGHT_GRAY, PINK, ORANGE};
        int colorNum = 0;
        
        for (int bar : months) {

            g.setColor(BLACK);

            int barHeight = bar * barUnit;
            int yPos = 500 - barHeight;
            
            g.fillRect(xPos, yPos, barWidth, barHeight);

            xPos += buffer + barWidth;
        }
        
        xPos = buffer + 40;
        for (int bar : months) {

            g.setColor(colors[colorNum]);

            int barHeight = bar * barUnit;
            int yPos = 500 - barHeight;

            if (!(barHeight == 0)) {
                g.fillRect(xPos + 5, yPos + 5, barWidth - 10, barHeight - 5);
            }

            xPos += buffer + barWidth;
            colorNum++;
        }
        
        Font numFont = new Font("Dialog", Font.ROMAN_BASELINE, 40);
        g.setFont(numFont);
        g.setColor(ORANGE);
        g.drawString(Integer.toString(months[1]), 205, 650);
    }
}
