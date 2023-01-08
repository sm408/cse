package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
public class Panels {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Microwave (Testing Panes)");
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4,3));
        
        for(int i = 1; i<=9; i++){
            p1.add(new JButton("" + i));
        }
        
        p1.add(new JButton("0"));
        p1.add(new JButton("Start"));
        p1.add(new JButton("Stop"));
        
        //Panel p2 holds top text field and the panel P1
        JPanel p2 = new JPanel(new BorderLayout());
        
        p2.add(new JTextField("Time to be displayed here..."),BorderLayout.NORTH);
        p2.add(p1,BorderLayout.CENTER);
        
        //adding borders
        p1.setBorder(new TitledBorder("Keys"));
        p2.setBorder(new LineBorder(new Color(0,0,255),3));
        
        
        frame.setLayout(new BorderLayout(10,10));
        
        //add components to the frame
        frame.add(new JButton("Food goes here..."),
                BorderLayout.WEST);
        
        frame.add(p2,BorderLayout.CENTER);
                
        
    }

}
