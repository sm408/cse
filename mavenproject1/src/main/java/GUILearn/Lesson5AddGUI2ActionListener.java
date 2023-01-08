package GUILearn;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Lesson5AddGUI2ActionListener {
    public static void main(String[] args) {
        Addition2 obj = new Addition2();
    }

}


class Addition2 extends JFrame implements ActionListener{
    
    //Defined outside the constructor to increse the scope
    JTextField num1 = new JTextField(10);   //creates text field
    JTextField num2 = new JTextField(10);
    JButton btn1 = new JButton("Add");      //creates a button
    JLabel res = new JLabel("Result: ");    //creates a label
        
    public Addition2(){
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        btn1.addActionListener(this);   //actonlistener is an interface
        
        //adding all the components created to the obj window
        add(num1);
        add(num2);
        add(btn1);
        add(res);
    }
    
    @Override
    public void actionPerformed(ActionEvent numInput){
        //Implementation of actionListener        
        int n1 = Integer.parseInt(num1.getText());  //gets text from text field num1 and converts to integer
        int n2 = Integer.parseInt(num2.getText());
        
        int result = n1+n2;
        
        res.setText(result + "");
        
    }
}
