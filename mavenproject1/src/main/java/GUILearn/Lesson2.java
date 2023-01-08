package GUILearn;

import javax.swing.*;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

//Creating a window
//Add a label to the GUI

public class Lesson2 {
    public static void main(String[] args) {
        Frame frame1 = new Frame();     //creates an obeject and calls the constructor
    }

}

class Frame extends JFrame
{
    public Frame(){
        JLabel label = new JLabel("Hello world!!!");    //creates a label
        add(label); //adds label to the window
        setVisible(true);   //Sets visibility
        setSize(400,400);   //Sets window size 
    }
}
