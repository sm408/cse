package GUI;

import java.awt.*;
import java.lang.Object;
import java.awt.geom.*;
import javax.swing.*;


/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
public class Graphics {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Testing Graphics");
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        
        frame.add(drawString("Hello",50,50));
    }

}
