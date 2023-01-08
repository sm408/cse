package GUILearn;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Name: Shubham Maurya Roll No.: 2010110615 Course: CSD213
 */
public class Lesson3 {

    public static void main(String[] args) {
        Frame3 frame = new Frame3();
    }

}

class Frame3 extends JFrame {

    public Frame3() {
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
