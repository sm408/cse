package TextEditorGUI.TryingShapes;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
class AboutDialog {

    AboutDialog(Notepad2 aThis) {
        // write about dialog code here

        // a dialog box to tell about the author

        // use the following message
        String message = "Name: Shubham Maurya";

        // use the following title
        String title = "About";

        // use the following icon
        ImageIcon icon = new ImageIcon("src/main/java/TextEditorGUI/TryingShapes/author.png");

        // close the dialog box when the user clicks on the OK button
        JOptionPane.showMessageDialog(aThis, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
        
        
        }

}
