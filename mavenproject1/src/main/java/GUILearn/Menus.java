package GUILearn;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultEditorKit.CutAction;

class saveFrame extends JFrame implements ActionListener{
JPanel panel = new JPanel();
JPanel labelpanel = new JPanel();
JButton savebutton = new JButton("Save");
JButton dontsave = new JButton("Dont Save");
JLabel savelabel = new JLabel("Are you sure you want to close?");                                                     
public saveFrame(){
setSize(400,100);
setLocation(500, 300);
setTitle("Saving...");
labelpanel.add(savelabel);
panel.add(savebutton);
panel.add(dontsave);
Container cpane = getContentPane();
cpane.add(panel, "South");
cpane.add(labelpanel, "Center");
setVisible(true);
savebutton.addActionListener(this);
dontsave.addActionListener(this);
}
public void actionPerformed(ActionEvent evt){
    Object source = evt.getSource();
    if(source == savebutton){
        System.exit(0);
    }
    else if(source == dontsave){
        System.exit(0);
    }

}

}
class replaceFrame extends JFrame implements ActionListener{
JButton find = new JButton("Find");
JButton replace = new JButton("Replace");
JTextField replacetext = new JTextField("Enter text to replace", 20);
JTextField findtext = new JTextField("Enter text to find", 20);
replaceFrame(){
    setSize(400, 100);
    setLocation(500, 300);
    setTitle("Replace");
    JPanel panel = new JPanel();
    panel.add(find);
    panel.add(findtext);
    panel.add(replace);
    panel.add(replacetext);
    Container cpane = getContentPane();
    cpane.add(panel, "Center");
    setVisible(true);
    find.addActionListener(this);
    replace.addActionListener(this);

}

public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    String command = evt.getActionCommand();
    String search = find.getText();
    String replacing = replacetext.getText();
    int n = MenuFrame.textarea.getText().indexOf(search);
    if(command.equals("Find")){
        MenuFrame.textarea.select(n,n+search.length());
    }
    if(command.equals("Replace")){
        MenuFrame.textarea.replaceRange(replacing, n, n+search.length());
    }

}
}


class MenuFrame extends JFrame implements ActionListener, MouseListener{
static  JTextArea textarea = new JTextArea();
static JMenuBar menubar = new JMenuBar();
JMenu file = new JMenu("File");
JMenu edit = new JMenu("Edit");
JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
JMenuItem Paste = new JMenuItem(new DefaultEditorKit.PasteAction());
JMenuItem copyAction = new JMenuItem(new DefaultEditorKit.CopyAction());
JMenuItem cutAction = new JMenuItem(new DefaultEditorKit.CutAction());
JMenuItem pasteAction = new JMenuItem(new DefaultEditorKit.PasteAction());
JMenu search = new JMenu("Search");
JMenuItem open = new JMenuItem("Open");
JMenuItem close = new JMenuItem("Close");
JMenuItem quit = new JMenuItem("Quit");
JMenuItem find  = new JMenuItem("Find");
JMenuItem replace = new JMenuItem("Replace");
JMenu font = new JMenu("Font");
JCheckBoxMenuItem bold = new JCheckBoxMenuItem("Bold");
JCheckBoxMenuItem italic = new JCheckBoxMenuItem("Italic");
JPopupMenu popup;


public MenuFrame(){
    Container cpane = getContentPane();
    cpane.add(textarea);
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    int screenheight = d.height;
    int screenwidth = d.width;
    setSize(screenwidth, screenheight);
    JPanel panel = new JPanel();
    ImageIcon closeicon = new ImageIcon("bin/close.png");
    ImageIcon openicon = new ImageIcon("bin/open.png");
    ImageIcon quiticon = new ImageIcon("bin/quit.jpeg");
    ImageIcon findicon = new ImageIcon("bin/find.png");
    ImageIcon replaceicon = new ImageIcon("bin/replace.png");
    ImageIcon boldicon = new ImageIcon("bin/bold.png");
    ImageIcon italicicon = new ImageIcon("bin/italic.png");
    ImageIcon copyicon = new ImageIcon("bin/copy.png");
    ImageIcon cuticon = new ImageIcon("bin/cut.png");
    ImageIcon pasteicon = new ImageIcon("bin/paste.png");
    Border matte = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK);
    Border etched = BorderFactory.createEtchedBorder();
    popup = new JPopupMenu();

    copy.setText("Copy");
    cut.setText("Cut");
    Paste.setText("Paste");
    copy.setIcon(copyicon);
    cut.setIcon(cuticon);
    Paste.setIcon(pasteicon);

    copyAction.setText("Copy");
    cutAction.setText("Cut");
    pasteAction.setText("Paste");
    copyAction.setIcon(copyicon);
    cutAction.setIcon(cuticon);
    pasteAction.setIcon(pasteicon);

    popup.add(cut);
    popup.addSeparator();
    popup.add(copy);
    popup.addSeparator();
    popup.add(Paste);
    popup.addSeparator();
    popup.add(find);
    popup.addSeparator();
    popup.add(replace);

    edit.add(cutAction);
    edit.addSeparator();
    edit.add(copyAction);
    edit.addSeparator();
    edit.add(pasteAction);

    find.setIcon(findicon);
    replace.setIcon(replaceicon);
    close.setIcon(closeicon);
    menubar = new JMenuBar();
    textarea = new JTextArea("He has achieved success.", d.width, d.height);
    JScrollPane scroll = new JScrollPane(textarea);
    cpane.add(scroll);
    open = new JMenuItem("Open", openicon);
    close = new JMenuItem("Close", closeicon);
    quit = new JMenuItem("Quit", quiticon);
    find = new JMenuItem("Find", findicon);
    replace = new JMenuItem("Replace", replaceicon);
    bold = new JCheckBoxMenuItem("Bold", boldicon);
    italic = new JCheckBoxMenuItem("Italic", italicicon);
    textarea.setLineWrap(true);
    file.add(open);
    file.addSeparator();
    file.add(close);
    file.addSeparator();
    file.add(quit);
    menubar.add(file);
    menubar.add(edit);
    menubar.add(search);
    menubar.add(font);
    search.add(find);
    search.addSeparator();
    search.add(replace);
    font.add(bold);
    font.addSeparator();
    font.add(italic);
    copy.setEnabled(false);
    cut.setEnabled(false);
    Paste.setEnabled(false);
    find.addActionListener(this);
    italic.addActionListener(this);
    bold.addActionListener(this);
    quit.addActionListener(this);
    close.addActionListener(this);
    find.addActionListener(this);
    replace.addActionListener(this);
    cut.addActionListener(this);
    copy.addActionListener(this);
    Paste.addActionListener(this);
    cut.addMouseListener(this);     
    textarea.addMouseListener(this);
    copy.addMouseListener(this);
    Paste.addMouseListener(this);
    textarea.setComponentPopupMenu(popup);
    file.setBackground(Color.BLACK);
    edit.setBackground(Color.BLACK);
    search.setBackground(Color.BLACK);
    font.setBackground(Color.BLACK);
    panel.add(menubar);
    menubar.setBorder(matte);
    menubar.setBackground(Color.BLACK);
    textarea.setBorder(etched);
}
public void actionPerformed(ActionEvent evt){
    Object source = evt.getSource();
    String command = evt.getActionCommand();
    String s = textarea.getSelectedText();
    Font f = new Font("Italic", Font.ITALIC, 13);
    Font f2 = new Font("Bold", Font.BOLD, 13);

    if(italic.isSelected()){            
        textarea.setFont(f);
    }
    if(bold.isSelected()){
        textarea.setFont(f2);
    }
    if(bold.isSelected() && italic.isSelected()){
        textarea.setFont(f);
        textarea.setFont(f2);
    }
    if(command.equals("Quit"))
            System.exit(0);
    if(command.equals("Close")){
        JFrame frame = new saveFrame();
        frame.setVisible(true);
    }
    if(source == find){
        JFrame frame = new FindFrame();
        frame.setVisible(true);
    }
    if(command.equals("Replace")){
        JFrame frame2 = new replaceFrame();
        frame2.setVisible(true);
    }
}

public void mouseClicked(MouseEvent e) {
    boolean s = textarea.getSelectedText() != null;
    if(s){
        copy.setEnabled(true);
        cut.setEnabled(true);
        Paste.setEnabled(true);

    }
}


public void mouseEntered(MouseEvent e) {

}


public void mouseExited(MouseEvent e) {

}


public void mousePressed(MouseEvent e) {

}


public void mouseReleased(MouseEvent e) {

}
class FindFrame extends JFrame implements ActionListener{
    JButton find = new JButton("Find");
    JTextField findtext = new JTextField("Find What", 20);
    FindFrame(){
        setSize(400, 100);
        setLocation(500, 300);
        setTitle("Find...");
        JPanel panel = new JPanel();
        panel.add(find);
        panel.add(findtext);
        Container cpane = getContentPane();
        cpane.add(panel, "Center");
        setVisible(true);
        find.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        String command = evt.getActionCommand();
        String search = findtext.getText();
        int n = textarea.getText().indexOf(search);
        if(source == find){
            MenuFrame.textarea.select(n,n+search.length());
        }
    }
}
}


public class Menus {
public static void main(String [] args){ 
    JFrame frame = new MenuFrame();
    frame.setJMenuBar(MenuFrame.menubar);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

}
