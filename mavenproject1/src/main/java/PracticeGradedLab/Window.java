package PracticeGradedLab;

import java.io.*;
import javax.swing.*;
import java.awt.*;



/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
public class Window {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hellu");
        
        JButton button = new JButton("Click me!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(button);
        button.setBounds(150,200,220,50);
        
        frame.setSize(500,600);
        
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
        
        frame.setVisible(true);
    }

}
