package TextEditorGUI.TryingShapes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * Name: Shubham Maurya Roll No.: 2010110615 Course: CSD213
 */
public class Shapes {
    
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        AddSub obj = new AddSub();
    }
    
}

class AddSub extends JFrame {

    //Defined outside the constructor to increse the scope
    JButton btn1 = new JButton("Rectangle");      //creates button
    JButton btn2 = new JButton("Eclipse");
    JButton btn3 = new JButton("Tringle");      //creates button
    JButton btn4 = new JButton("Gola");
    JButton btn5 = new JButton("PanchKon");      //creates button
    
    public AddSub() {
        setLayout(new BorderLayout(10,10));
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        btn1.addActionListener((ActionEvent clicked) -> {
            //Implementation of actionListener;

        });
        
        btn2.addActionListener((ActionEvent clicked) -> {
            //Implementation of actionListener;

        });   //actonlistener is an interface
        
        btn3.addActionListener((ActionEvent clicked) -> {
            //Implementation of actionListener;

        });
        
        btn4.addActionListener((ActionEvent clicked) -> {
            //Implementation of actionListener;

        });
        
        btn5.addActionListener((ActionEvent clicked) -> {
            //Implementation of actionListener;

        });

        //adding all the components created to the obj window
        JPanel panel = new JPanel();
        
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.setBorder(new TitledBorder("Buttons"));

//        JPanel panel2 = new JPanel();
        JPanel drawingPanel = new JPanel();
        drawingPanel.setSize(300, 300);
        drawingPanel.setVisible(true);
        drawingPanel.setBorder(new TitledBorder("Drawing Pane"));
        
        JPanel all = new JPanel();
        all.setLayout(new BorderLayout(10,10));
        
        all.add(panel, BorderLayout.NORTH);
        all.add(drawingPanel, BorderLayout.CENTER);
        
        add(all);
    }
    
}
