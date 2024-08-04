/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
 
/**
*
* @author madushanka
*/
 
//Creating extended class of JComponent class
 
class backImage extends JComponent {
 
Image i;
 
//Creating Constructer
public backImage(Image i) {
this.i = i;
 
}
 
//Overriding the paintComponent method
@Override
public void paintComponent(Graphics g) {
 
g.drawImage(i, 0, 0, null);  // Drawing image using drawImage method
 
}
}