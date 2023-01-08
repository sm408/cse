package TextEditorGUI.TryingShapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.UndoableEditListener;

public class Notepad2 extends JFrame implements ActionListener, CaretListener, MouseListener, MouseMotionListener {
  private JMenuBar menuBar;
  private JMenu fileMenu, editMenu, formatMenu, helpMenu;
  private JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem;
  private JMenuItem undoItem, cutItem, copyItem, pasteItem, deleteItem, findItem, findNextItem, replaceItem, goToItem, selectAllItem, timeDateItem;
  private JMenuItem wordWrapItem, fontItem;
  
  private JMenuItem viewHelpItem, aboutNotepadItem;
  private JTextArea textArea;
  private JScrollPane scrollPane;
  private JPanel drawingPanel;
  private Graphics graphics;
  private int x1, y1, x2, y2;

  public Notepad2() {
    // Set up the menu bar
    menuBar = new JMenuBar();

    // Set up the File menu
    fileMenu = new JMenu("File");
    newItem = new JMenuItem("New");
    openItem = new JMenuItem("Open...");
    saveItem = new JMenuItem("Save");
    saveAsItem = new JMenuItem("Save As...");
    exitItem = new JMenuItem("Exit");
    fileMenu.add(newItem);
    fileMenu.add(openItem);
    fileMenu.add(saveItem);
    fileMenu.add(saveAsItem);
    fileMenu.addSeparator();
    fileMenu.add(exitItem);
    menuBar.add(fileMenu);

    // Set up the Edit menu
    editMenu = new JMenu("Edit");
    undoItem = new JMenuItem("Undo");
    cutItem = new JMenuItem("Cut");
    copyItem = new JMenuItem("Copy");
    pasteItem = new JMenuItem("Paste");
    deleteItem = new JMenuItem("Delete");
    findItem = new JMenuItem("Find...");
    findNextItem = new JMenuItem("Find Next");
    replaceItem = new JMenuItem("Replace...");
    goToItem = new JMenuItem("Go To...");
    // Select All
selectAllItem = new JMenuItem("Select All");
editMenu.add(undoItem);
editMenu.addSeparator();
editMenu.add(cutItem);
editMenu.add(copyItem);
editMenu.add(pasteItem);
editMenu.add(deleteItem);
editMenu.addSeparator();
editMenu.add(findItem);
editMenu.add(findNextItem);
editMenu.add(replaceItem);
editMenu.add(goToItem);
editMenu.addSeparator();
editMenu.add(selectAllItem);
menuBar.add(editMenu);

// Set up the Format menu
formatMenu = new JMenu("Format");
wordWrapItem = new JMenuItem("Word Wrap");
fontItem = new JMenuItem("Font...");
formatMenu.add(wordWrapItem);
formatMenu.add(fontItem);
menuBar.add(formatMenu);

// Set up the Help menu
helpMenu = new JMenu("Help");
viewHelpItem = new JMenuItem("View Help");
aboutNotepadItem = new JMenuItem("About Notepad");
helpMenu.add(viewHelpItem);
helpMenu.add(aboutNotepadItem);
menuBar.add(helpMenu);

// Set up the text area and scroll pane
textArea = new JTextArea();
scrollPane = new JScrollPane(textArea);
scrollPane.setPreferredSize(new Dimension(600, 400));

// Set up the drawing panel
drawingPanel = new JPanel();
drawingPanel.setPreferredSize(new Dimension(200, 400));
drawingPanel.setBackground(Color.WHITE);

// Add the menu bar, text area, and drawing panel to the frame
add(menuBar, BorderLayout.NORTH);
add(scrollPane, BorderLayout.CENTER);
add(drawingPanel, BorderLayout.EAST);

// Set up the listeners
newItem.addActionListener(this);
openItem.addActionListener(this);
saveItem.addActionListener(this);
saveAsItem.addActionListener(this);
exitItem.addActionListener(this);
undoItem.addActionListener(this);
cutItem.addActionListener(this);
copyItem.addActionListener(this);
pasteItem.addActionListener(this);
deleteItem.addActionListener(this);
findItem.addActionListener(this);
findNextItem.addActionListener(this);
replaceItem.addActionListener(this);
goToItem.addActionListener(this);
selectAllItem.addActionListener(this);
wordWrapItem.addActionListener(this);
fontItem.addActionListener(this);
viewHelpItem.addActionListener(this);
aboutNotepadItem.addActionListener(this);
textArea.addCaretListener(this);
drawingPanel.addMouseListener(this);
drawingPanel.addMouseMotionListener(this);

// Set up the frame
setTitle("Notepad");
setDefaultCloseOperation(EXIT_ON_CLOSE);
pack();
setLocationRelativeTo(null);
setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
// Handle menu item actions
if (e.getSource() == newItem) {
    // Code for new action goes here
    // Clear the text area
    textArea.setText("");



  } else if (e.getSource() == openItem) {
    // Code for Open... action goes here
    // Create a file chooser
    JFileChooser fileChooser = new JFileChooser();
    // Set the file chooser to open files
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    // Show the file chooser
    int result = fileChooser.showOpenDialog(this);
    // If the user clicked the Open button
    if (result == JFileChooser.APPROVE_OPTION) {
      // Get the selected file
      File file = fileChooser.getSelectedFile();
      // Open the file
      openFile(file);
    }
    
  } else if (e.getSource() == saveItem) {
    //function to save the file
        // method to save the file
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        // Set the file chooser to save files
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Show the file chooser
        int result = fileChooser.showSaveDialog(this);
        // If the user clicked the Save button
        if (result == JFileChooser.APPROVE_OPTION) {
          // Get the selected file
          File file = fileChooser.getSelectedFile();
          // Save the file without making any function calls
            try {
                // Create a file writer
                FileWriter fileWriter = new FileWriter(file);
                // Get the text from the text area
                String text = textArea.getText();
                // Write the text to the file
                fileWriter.write(text);
                // Close the file writer
                fileWriter.close();
            } catch (IOException ex) {
                // Display an error message
                JOptionPane.showMessageDialog(this, "Error saving file.");
            }

          
        

    };


  } else if (e.getSource() == saveAsItem) {
    // function to save the file as a new file without making any function calls
    // Create a file chooser
    JFileChooser fileChooser = new JFileChooser();
    // Set the file chooser to save files
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    // Show the file chooser
    int result = fileChooser.showSaveDialog(this);
    // If the user clicked the Save button
    if (result == JFileChooser.APPROVE_OPTION) {
      // Get the selected file
      File file = fileChooser.getSelectedFile();
      // Save the file without making any function calls
        try {
            // Create a file writer
            FileWriter fileWriter = new FileWriter(file);
            // Get the text from the text area
            String text = textArea.getText();
            // Write the text to the file
            fileWriter.write(text);
            // Close the file writer
            fileWriter.close();
        } catch (IOException ex) {
            // Display an error message
            JOptionPane.showMessageDialog(this, "Error saving file.");
        }


  } else if (e.getSource() == exitItem) {
    // function to exit the program without making any function calls
    // Exit the program
    System.exit(0);
    

  } else if (e.getSource() == undoItem) {
    // Code for Undo action goes here
    // Create an undo manager
    UndoManager undoManager = new UndoManager();
    // Add the undo manager to the text area
    textArea.getDocument().addUndoableEditListener((UndoableEditListener) undoManager);
    // Create an undo action
    Action undoAction = new AbstractAction("Undo") {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Undo the last edit
        undoManager.undo();
      }
    };
    
  } else if (e.getSource() == cutItem) {
    // Code for Cut action goes here
    // Cut the selected text
    textArea.cut();

  } else if (e.getSource() == copyItem) {
    // Code for Copy action goes here
    // Copy the selected text
    textArea.copy();

  } else if (e.getSource() == pasteItem) {
    // Code for Paste action goes 
    // Paste the selected text
    textArea.paste();

  } else if (e.getSource() == deleteItem) {
    // Code for Delete action goes here
    // Delete the selected text
    textArea.replaceSelection("");

  } else if (e.getSource() == findItem) {
    // Code for Find... action goes here
    // Create a Find dialog
    FindDialog findDialog = new FindDialog(this);
    // Show the Find dialog
    findDialog.setVisible(true);

  } else if (e.getSource() == findNextItem) {
    // Code for Find Next action goes here
    // add find next function to the find dialog
    findDialog.findNext();

  } else if (e.getSource() == replaceItem) {
    // Code for Replace... action goes here
    // Create a Replace dialog
    ReplaceDialog replaceDialog = new ReplaceDialog(this);
    // Show the Replace dialog
    replaceDialog.setVisible(true);

  } else if (e.getSource() == goToItem) {
    // Code for Go To... action goes here
    // Create a Go To dialog
    GoToDialog goToDialog = new GoToDialog(this);
    // Show the Go To dialog
    goToDialog.setVisible(true);

  } else if (e.getSource() == selectAllItem) {
    // Code for Select All action goes here
    // Select all the text
    textArea.selectAll();

  } else if (e.getSource() == wordWrapItem) {
    // Code for Word Wrap action goes here
    // Toggle word wrap
    textArea.setLineWrap(!textArea.getLineWrap());

  } else if (e.getSource() == fontItem) {
    // Code for Font... action goes here
    // Create a font chooser
    JFontChooser fontChooser = new JFontChooser();
    // Show the font chooser
    int result = fontChooser.showDialog(this);
    // If the user clicked the OK button
    if (result == JFontChooser.OK_OPTION) {
      // Get the selected font
      Font font = fontChooser.getSelectedFont();
      // Set the font of the text area
      textArea.setFont(font);
    }

  } else if (e.getSource() == viewHelpItem) {
    // Code for View Help action goes here
    // Create a Help dialog
    HelpDialog helpDialog = new HelpDialog(this);
    // Show the Help dialog
    helpDialog.setVisible(true);

  } else if (e.getSource() == aboutNotepadItem) {
    // Code for About Notepad action goes here
    // Create an About dialog
    AboutDialog aboutDialog = new AboutDialog(this);
    // Show the About dialog
    aboutDialog.setVisible(true);

  }
  }
  
  @Override
  public void caretUpdate(CaretEvent e) {
  // Code for updating the menu bar based on the current caret position goes here
  // Get the current caret position
    int caretPosition = textArea.getCaretPosition();
    // Get the line number
    int lineNumber = textArea.getLineOfOffset(caretPosition);
    // Get the column number
    int columnNumber = caretPosition - textArea.getLineStartOffset(lineNumber);
    // Update the status bar
    statusBar.setCaretPosition(lineNumber + 1, columnNumber + 1);

  }
  
  @Override
  public void mousePressed(MouseEvent e) {
  // Code for handling mouse press events in the drawing panel goes here

  //handle the mouse press event
    // Get the mouse position
    Point mousePosition = e.getPoint();
    // Get the current mouse mode
    MouseMode mouseMode = drawingPanel.getMouseMode();
    // If the mouse mode is Draw
    if (mouseMode == MouseMode.DRAW) {
      // Create a new shape
      Shape shape = new Shape();
      // Set the shape's color
      shape.setColor(drawingPanel.getShapeColor());
      // Set the shape's fill flag
      shape.setFill(drawingPanel.getShapeFill());
      // Set the shape's type
      shape.setType(drawingPanel.getShapeType());
      // Set the shape's start point
      shape.setStartPoint(mousePosition);
      // Set the shape's end point
      shape.setEndPoint(mousePosition);
      // Add the shape to the drawing panel
      drawingPanel.addShape(shape);
    }
    // If the mouse mode is Select
    else if (mouseMode == MouseMode.SELECT) {
      // Get the shape at the mouse position
      Shape shape = drawingPanel.getShapeAt(mousePosition);
      // If a shape was found
      if (shape != null) {
        // Set the selected shape
        drawingPanel.setSelectedShape(shape);
        // Set the shape's start point
        shape.setStartPoint(mousePosition);
      }
    }


  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
  // Code for handling mouse release events in the drawing panel goes here

  // handle the mouse release event
    // Get the mouse position
    Point mousePosition = e.getPoint();
    // Get the current mouse mode
    MouseMode mouseMode = drawingPanel.getMouseMode();
    // If the mouse mode is Draw
    if (mouseMode == MouseMode.DRAW) {
      // Get the last shape
      Shape shape = drawingPanel.getLastShape();
      // Set the shape's end point
      shape.setEndPoint(mousePosition);
    }
    // If the mouse mode is Select
    else if (mouseMode == MouseMode.SELECT) {
      // Get the selected shape
      Shape shape = drawingPanel.getSelectedShape();
      // If a shape was found
      if (shape != null) {
        // Set the shape's end point
        shape.setEndPoint(mousePosition);
      }
    }


  }
  
  @Override
  public void mouseDragged(MouseEvent e) {
  // Code for handling mouse drag events in the drawing panel goes here

  // handle the mouse drag event
    // Get the mouse position
    Point mousePosition = e.getPoint();
    // Get the current mouse mode
    MouseMode mouseMode = drawingPanel.getMouseMode();
    // If the mouse mode is Draw
    if (mouseMode == MouseMode.DRAW) {
      // Get the last shape
      Shape shape = drawingPanel.getLastShape();
      // Set the shape's end point
      shape.setEndPoint(mousePosition);
    }
    // If the mouse mode is Select
    else if (mouseMode == MouseMode.SELECT) {
      // Get the selected shape
      Shape shape = drawingPanel.getSelectedShape();
      // If a shape was found
      if (shape != null) {
        // Set the shape's end point
        shape.setEndPoint(mousePosition);
      }
    }


  }
  
  @Override
  public void mouseMoved(MouseEvent e) {
  // Code for handling mouse move events in the drawing panel goes here

  // handle the mouse move event
    // Get the mouse position
    Point mousePosition = e.getPoint();
    // Get the current mouse mode
    MouseMode mouseMode = drawingPanel.getMouseMode();
    // If the mouse mode is Select
    if (mouseMode == MouseMode.SELECT) {
      // Get the shape at the mouse position
      Shape shape = drawingPanel.getShapeAt(mousePosition);
      // If a shape was found
      if (shape != null) {
        // Set the cursor to the hand cursor
        drawingPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      } else {
        // Set the cursor to the default cursor
        drawingPanel.setCursor(Cursor.getDefaultCursor());
      }
    }


  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
  // Code for handling mouse click events in the drawing panel goes here

    // handle the mouse click event
        // Get the mouse position
        Point mousePosition = e.getPoint();
        // Get the current mouse mode
        MouseMode mouseMode = drawingPanel.getMouseMode();
        // If the mouse mode is Select
        if (mouseMode == MouseMode.SELECT) {
        // Get the shape at the mouse position
        Shape shape = drawingPanel.getShapeAt(mousePosition);
        // If a shape was found
        if (shape != null) {
            // Set the selected shape
            drawingPanel.setSelectedShape(shape);
        }
        }


  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
  // Code for handling mouse enter events in the drawing panel goes here

  // handle the mouse enter event
    // Get the mouse position
    Point mousePosition = e.getPoint();
    // Get the current mouse mode
    MouseMode mouseMode = drawingPanel.getMouseMode();
    // If the mouse mode is Select
    if (mouseMode == MouseMode.SELECT) {
      // Get the shape at the mouse position
      Shape shape = drawingPanel.getShapeAt(mousePosition);
      // If a shape was found
      if (shape != null) {
        // Set the cursor to the hand cursor
        drawingPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      } else {
        // Set the cursor to the default cursor
        drawingPanel.setCursor(Cursor.getDefaultCursor());
      }
    }

  }
  
  @Override
  public void mouseExited(MouseEvent e) {
  // Code for handling mouse exit events in the drawing panel goes here

    // handle the mouse exit event
        // Get the mouse position
        Point mousePosition = e.getPoint();
        // Get the current mouse mode
        MouseMode mouseMode = drawingPanel.getMouseMode();
        // If the mouse mode is Select
        if (mouseMode == MouseMode.SELECT) {
        // Get the shape at the mouse position
        Shape shape = drawingPanel.getShapeAt(mousePosition);
        // If a shape was found
        if (shape != null) {
            // Set the cursor to the hand cursor
            drawingPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            // Set the cursor to the default cursor
            drawingPanel.setCursor(Cursor.getDefaultCursor());
        }
        }
    

        
  }
  
  public static void main(String[] args) {
    new Notepad2();
  }

    private void openFile(File file) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  }
  
  


  class UndoManager {
    
    public static void main(String[] args) {
        // TODO code application logic here
        // Create a new JFrame container.
        JFrame jfrm = new JFrame("Undo/Redo");
        // Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());
        // Give the frame an initial size.
        jfrm.setSize(200, 120);
        // Terminate the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create an empty label.
        JLabel jlab = new JLabel();
        // Create an undo manager.
        UndoManager um = new UndoManager();
        // Create a text field.
        JTextField jtf = new JTextField(10);
        // Add an action listener for the text field.
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent le) {
                // Display the contents of the text field.
                jlab.setText("You pressed ENTER. Text is: " + jtf.getText());
            }
        });
        // Add the text field and label to the content pane.
        jfrm.add(jtf);
        jfrm.add(jlab);
        // Display the frame.
        jfrm.setVisible(true);
        

    }


}

