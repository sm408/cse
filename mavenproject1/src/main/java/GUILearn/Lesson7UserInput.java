package GUILearn;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
public class Lesson7UserInput {
    public static void main(String[] args) {
        UserInput obj = new UserInput();
    }

}

class UserInput extends JFrame{
    
    //declare buttons
    JTextField t1;
    JButton b1;
    JRadioButton r1, r2;
    JLabel l1;
    
    public UserInput(){
        t1 = new JTextField(15);
        b1 = new JButton("Submit");
        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        l1  = new JLabel(" ");
        
        
        //creating buttonGroups
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        
        add(t1);
        add(r1);
        add(r2);
        add(b1);
        add(l1);
        
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = t1.getText();
                
                if(r1.isSelected())
                    name = "Mr. " + name;
                else
                    name = "Ms. " + name;
                
                l1.setText(name);
                
            }
        });
        
        
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}