
package lab4;

import javax.swing.;
import java.awt.;

public class ShapePanel extends JPanel {

// Declare buttons for different shapes
private JButton rectangleButton;
private JButton ovalButton;
private JButton lineButton;

// Declare panel to draw shapes
private JPanel drawingPanel;

// Declare variables to store current shape and color
private String currentShape;
private Color currentColor;

// Constructor
public ShapePanel() {

Copy code
// Set layout to BorderLayout
setLayout(new BorderLayout());

// Initialize buttons
rectangleButton = new JButton("Rectangle");
ovalButton = new JButton("Oval");
lineButton = new JButton("Line");

// Add action listeners to buttons
rectangleButton.addActionListener(e -> {
  currentShape = "rectangle";
});
ovalButton.addActionListener(e -> {
  currentShape = "oval";
});
lineButton.addActionListener(e -> {
  currentShape = "line";
});

// Create panel to hold buttons and set layout to FlowLayout
JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new FlowLayout());

// Add buttons to button panel
buttonPanel.add(rectangleButton);
buttonPanel.add(ovalButton);
buttonPanel.add(lineButton);

// Initialize drawing panel and set background color to white
drawingPanel = new JPanel();
drawingPanel.setBackground(Color.WHITE);

// Add button panel and drawing panel to ShapePanel
add(buttonPanel, BorderLayout.NORTH);
add(drawingPanel, BorderLayout.CENTER);
}

// Override paintComponent method to draw shapes on drawing panel
@Override
public void paintComponent(Graphics g) {
super.paintComponent(g);

Copy code
// Set color to currentColor
g.setColor(currentColor);

// Draw shape based on currentShape
if (currentShape.equals("rectangle")) {
  g.fillRect(10, 10, 50, 50);
} else if (currentShape.equals("oval")) {
  g.fillOval(10, 10, 50, 50);
} else if (currentShape.equals("line")) {
  g.drawLine(10, 10, 60, 60);
}
}

// Set current color
public void setCurrentColor(Color color) {
currentColor = color;
}

// Clear drawing panel
public void clearDrawingPanel() {
drawingPanel.repaint();
}
}

// create a frame
JFrame frame = new JFrame("Shape Panel");

// create a ShapePanel
ShapePanel shapePanel = new ShapePanel();

// add shapePanel to the frame
frame.add(shapePanel);

// set frame properties
frame.setSize(400, 400);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

// set current color to red
shapePanel.setCurrentColor(Color.RED);

// draw a rectangle
shapePanel.paintComponent(shapePanel.getGraphics());

// set current color to blue
shapePanel.setCurrentColor(Color.BLUE);

// draw an oval
shapePanel.paintComponent(shapePanel.getGraphics());

// set current color to green
shapePanel.setCurrentColor(Color.GREEN);

// draw a line
shapePanel.paintComponent(shapePanel.getGraphics());

// clear drawing panel
shapePanel.clearDrawingPanel();

// create a main method
public static void main(String[] args) {
// create an instance of the class
ShapePanelDemo demo = new ShapePanelDemo();
}

}


