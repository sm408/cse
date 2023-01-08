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
import javax.swing.text.*;

public class Notepad3 extends JFrame implements ActionListener {
    JTextArea jta;
    JMenuBar mb;
    JMenu editMenu;
    JMenuItem findItem, replaceItem;
    JScrollPane jsp;
    JLabel statusBar;
    int startIndex = 0;

    Notepad3() {
        super("Notepad");
        jta = new JTextArea();
        jta.setFont(new Font("Arial", Font.BOLD, 16));
        jsp = new JScrollPane(jta);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(jsp, BorderLayout.CENTER);

        // Create Status Bar
        statusBar = new JLabel(" 0 Character(s) - 0 Word(s)");
        statusBar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        statusBar.setFont(new Font("Arial", Font.PLAIN, 12));
        add(statusBar, BorderLayout.SOUTH);

        // Create Menu Bar
        mb = new JMenuBar();
        editMenu = new JMenu("Edit");
        findItem = new JMenuItem("Find");
        findItem.addActionListener(this);
        editMenu.add(findItem);
        replaceItem = new JMenuItem("Replace");
        replaceItem.addActionListener(this);
        editMenu.add(replaceItem);
        mb.add(editMenu);
        setJMenuBar(mb);

        // Add DocumentListener
        jta.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateStatusBar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateStatusBar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateStatusBar();
            }
        });

        setVisible(true);
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == findItem) {
            String findWord = JOptionPane.showInputDialog("Enter Word to Find");
            String content = jta.getText();
            int index = content.indexOf(findWord, startIndex);
            if (index >= 0) {
                startIndex = index + findWord.length();
                jta.setCaretPosition(startIndex);
                jta.select(index, startIndex);
            } else {
                startIndex = 0;
                JOptionPane.showMessageDialog(this, "Word Not Found");
            }
        } else if (e.getSource() == replaceItem) {
            String findWord = JOptionPane.showInputDialog("Enter Word to Find");
            String content = jta.getText();
            int index = content.indexOf(findWord, startIndex);
            if (index >= 0) {
                startIndex = index + findWord.length();
                jta.setCaretPosition(startIndex);
                jta.select(index, startIndex);
                String replaceWord = JOptionPane.showInputDialog("Enter Word to Replace");
                jta.replaceSelection(replaceWord);
            } else {
                startIndex = 0;
                JOptionPane.showMessageDialog(this, "Word Not Found");
            }
        }
    }

    public void updateStatusBar() {
        int totalCharacters = jta.getText().length();
        int totalWords = jta.getText().split("\\s+").length;
        statusBar.setText(totalCharacters + " Character(s) - " + totalWords + " Word(s)");
    }

    public static void main(String[] args) {
        new Notepad();
    }
}
