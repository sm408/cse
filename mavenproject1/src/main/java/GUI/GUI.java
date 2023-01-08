package GUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * Name: Shubham Maurya Roll No.: 2010110615 Course: CSD213
 */
public class GUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Frame");
        frame.setSize(600, 200);
        frame.getContentPane().setBackground(Color.green);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        
        JButton jbtn1 = new JButton("OK");
        frame.add(jbtn1);
        jbtn1.setBackground(Color.red);
        Font myFont1 = new Font("Aharoni", Font.BOLD, 16);
        jbtn1.setFont(myFont1);
        frame.add(new JLabel("Enter your name: "));
        frame.add(new JTextField("Type name here: "));
        frame.add(new JCheckBox("Bold"));
        frame.add(new JRadioButton("Red"));
        frame.add(new JComboBox(new String[]{"Red", "Green", "Blue"}));
        frame.setBackground(Color.RED);

    }
}
