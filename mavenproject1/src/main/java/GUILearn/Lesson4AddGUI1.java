package GUILearn;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
public class Lesson4AddGUI1 {
    public static void main(String[] args) {
        Addition obj = new Addition();
        
    }

}

class Addition extends JFrame {
    public Addition(){
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JTextField num1 = new JTextField(10);   //creates text field
        JTextField num2 = new JTextField(10);
        JButton btn1 = new JButton("Add");      //creates a button
        JLabel res = new JLabel("Result: ");    //creates a label

        //adding all the components created to the obj window
        add(num1);
        add(num2);
        add(btn1);
        add(res);
    }
}
