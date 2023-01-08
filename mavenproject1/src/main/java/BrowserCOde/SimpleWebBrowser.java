package BrowserCOde;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SimpleWebBrowser extends JFrame {
  // The text field for entering a URL
  private JTextField urlField;

  // The main panel for rendering web pages
  private JEditorPane webPage;

  // Constructor for the browser
  public SimpleWebBrowser() {
    super("Simple Web Browser");

    // Create the components
    urlField = new JTextField();
    webPage = new JEditorPane();
    webPage.setEditable(false);

    // Add a listener for when the user enters a URL
    urlField.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        loadURL(e.getActionCommand());
      }
    });

    // Add a listener for when a link is clicked
    webPage.addHyperlinkListener(new HyperlinkListener() {
      public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
          loadURL(e.getURL().toString());
        }
      }
    });

    // Add the components to the frame
    add(urlField, BorderLayout.NORTH);
    add(new JScrollPane(webPage), BorderLayout.CENTER);

    // Set the size and show the frame
    setSize(640, 480);
    setVisible(true);
  }

  // Method to load a URL into the web page component
  private void loadURL(String url) {
    try {
      webPage.setPage(url);
      urlField.setText(url);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(this, "Error loading page", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  public static void main(String[] args) {
    new SimpleWebBrowser();
  }
}