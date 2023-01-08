package FinalProject;

/**
 *
 * Name: Shubham Maurya 
 * Roll No.: 2010110615 
 * Course: CSD213
 * Description: It is a simple notepad program that mimics the functions of a windows notepad app.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.border.TitledBorder;

public class Notepad extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu, findMenu, wordCount;
    private JMenuItem newFile, openFile, saveFile, saveAsFile, exit;
    private JMenuItem cut, copy, paste, selectAll, find, replace;
    private JMenuItem showWordCount;
    private JPanel drawingPanel, mainPane;
    private JButton clearButton;
    private Point startPoint, endPoint;
    private boolean isDrawing = false;

    public Notepad() {
// initialize the text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Calibri", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(new TitledBorder("Writing Pane"));

//Copy code
        // initialize the menu bar
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        findMenu = new JMenu("FindMenu");
        wordCount = new JMenu("Word Count");

        // initialize menu items
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        saveAsFile = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        find = new JMenuItem("Find");
        replace = new JMenuItem("Replace");
        showWordCount = new JMenuItem("Count");

        // add action listeners
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        saveAsFile.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        find.addActionListener(this);
        replace.addActionListener(this);
        showWordCount.addActionListener(this);

        // add menu items to the menu
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveAsFile);
        fileMenu.add(exit);
        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(selectAll);
        findMenu.add(find);
        findMenu.add(replace);
        wordCount.add(showWordCount);

        // add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(findMenu);
        menuBar.add(wordCount);

        //frehand draw panel code
        mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout(1, 2));
        mainPane.setBorder(new TitledBorder("Freehand Drawing Pane"));

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

        //Adding mouse event listener to the drawing pane
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

        // defining the clear button
        clearButton = new JButton("Clear");
        clearButton.addActionListener((ActionEvent e) -> {
            drawingPanel.repaint();
        });

        // Adding drawing pane and clear button to the main drawing pane
        mainPane.add(drawingPanel, BorderLayout.CENTER);
        mainPane.add(clearButton, BorderLayout.SOUTH);

        // setting up the main frame
        add(textArea);
        add(mainPane);
        setJMenuBar(menuBar);

        // set frame properties
        GridLayout mainLayout = new GridLayout(0, 2, 5, 5);
        setTitle("Notepad");
        setSize(1400, 600);
        setLayout(mainLayout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// handle menu item actions
        if (e.getSource() == newFile) {
// clear the text area
            textArea.setText("");

        } else if (e.getSource() == openFile) {
// open a file and load its contents into the text area
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = "";
                    StringBuilder sb = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    textArea.setText(sb.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == saveFile) {
// save the contents of the text area to a file
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(textArea.getText());
                    writer.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == saveAsFile) {
// save the contents of the text area to a different file
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(textArea.getText());
                    writer.flush();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == exit) {
// exit the application
            System.exit(0);
        } else if (e.getSource() == cut) {
// cut the selected text
            textArea.cut();
        } else if (e.getSource() == copy) {
// copy the selected text
            textArea.copy();
        } else if (e.getSource() == paste) {
// paste the text from clipboard
            textArea.paste();
        } else if (e.getSource() == selectAll) {
// select all the text
            textArea.selectAll();
        } else if (e.getSource() == find) {
// show a dialog to find a word in the text area
            String word = JOptionPane.showInputDialog(this, "Enter the word to find:");
            if (word != null) {
                int startIndex = textArea.getText().indexOf(word);
                if (startIndex != -1) {
                    int endIndex = startIndex + word.length();
                    textArea.select(startIndex, endIndex);
                } else {
                    JOptionPane.showMessageDialog(this, "Word not found");
                }
            }
        } else if (e.getSource() == showWordCount) {
// show a dialog with word and character count in the text area

            String text = textArea.getText();
            text = text.trim();
            String words[] = text.split("\\s");
            JOptionPane.showMessageDialog(this, "Words: " + words.length + "\nCharacters: " + text.length());

        } else if (e.getSource() == replace) {
// show a dialog to replace a word in the text area
            String findWord = JOptionPane.showInputDialog(this, "Enter the word to find:");
            if (findWord != null) {
                int startIndex = textArea.getText().indexOf(findWord);
                if (startIndex != -1) {
                    int endIndex = startIndex + findWord.length();
                    textArea.select(startIndex, endIndex);
                    String replaceWord = JOptionPane.showInputDialog(this, "Enter the word to replace:");
                    if (replaceWord != null) {
                        textArea.replaceRange(replaceWord, startIndex, endIndex);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Word not found");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }
}
