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

public class FreehandDrawingBoard extends JFrame {


private JPanel drawingPanel;
private JButton clearButton;
private Point startPoint, endPoint;
private boolean isDrawing = false;

public FreehandDrawingBoard() {
    setTitle("Freehand Drawing Board");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    drawingPanel = new JPanel();
    drawingPanel.setBackground(Color.WHITE);
    drawingPanel.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            startPoint = e.getPoint();
            isDrawing = true;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            isDrawing = false;
        }
    });
    drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            endPoint = e.getPoint();
            if (isDrawing) {
                Graphics g = drawingPanel.getGraphics();
                g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
                startPoint = endPoint;
            }
        }
    });
    add(drawingPanel, BorderLayout.CENTER);

    clearButton = new JButton("Clear");
    clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            drawingPanel.repaint();
        }
    });
    add(clearButton, BorderLayout.SOUTH);
}

    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new FreehandDrawingBoard().setVisible(true);
        }
    });
}

}
