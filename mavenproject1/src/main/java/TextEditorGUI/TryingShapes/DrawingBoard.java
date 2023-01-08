package TextEditorGUI.TryingShapes;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class DrawingBoard extends JPanel {
  private ArrayList<Point> points = new ArrayList<Point>();

  public DrawingBoard() {
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        points.add(e.getPoint());
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        points.add(e.getPoint());
        repaint();
      }
    });
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(3));
    for (int i = 1; i < points.size(); i++) {
      Point p1 = points.get(i - 1);
      Point p2 = points.get(i);
      g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Drawing Board");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new DrawingBoard());
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
