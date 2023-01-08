package TextEditorGUI;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.datatransfer.*;

public class trial extends JFrame implements ActionListener, WindowListener {
	
	JTextArea jta=new JTextArea();
	File fnameContainer;
	
	public trial(){

		Font fnt=new Font("Arial",Font.PLAIN,15);
		Container con=getContentPane();
		
		JMenuBar jmb=new JMenuBar();
		JMenu jmfile = new JMenu("File");
		JMenu jmedit = new JMenu("Edit");
		JMenu jmhelp = new JMenu("Help");
		
		con.setLayout(new BorderLayout());
		//trying to add scrollbar
		JScrollPane sbrText = new JScrollPane(jta);
		sbrText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sbrText.setVisible(true);
		
		
		jta.setFont(fnt);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		
		con.add(sbrText);

		createMenuItem(jmfile,"New");
		createMenuItem(jmfile,"Open");
		createMenuItem(jmfile,"Save");
		jmfile.addSeparator();
		createMenuItem(jmfile,"Exit");
		
		createMenuItem(jmedit,"Cut");
		createMenuItem(jmedit,"Copy");
		createMenuItem(jmedit,"Paste");
		
		createMenuItem(jmhelp,"About Notepad");
		
		jmb.add(jmfile);
		jmb.add(jmedit);
		jmb.add(jmhelp);
		
		setJMenuBar(jmb);
		setIconImage(Toolkit.getDefaultToolkit().getImage("notepad.gif"));
		addWindowListener(this);
		setSize(500,500);
		setTitle("Untitled.txt - Notepad");
				
		setVisible(true);
	
	}

	public void createMenuItem(JMenu jm,String txt){
		JMenuItem jmi=new JMenuItem(txt);
		jmi.addActionListener(this);
		jm.add(jmi);
	}
	
        @Override
	public void actionPerformed(ActionEvent e){	
		JFileChooser jfc;
            jfc = new JFileChooser();
		
            switch (e.getActionCommand()) {
                case "New" -> {
                    //new
                    this.setTitle("Untitled.txt - Notepad");
                    jta.setText("");
                    fnameContainer=null;
                }
                case "Open" ->                     {
                        //open
                        int ret=jfc.showDialog(null,"Open");
                        if(ret == JFileChooser.APPROVE_OPTION)
                        {
                            try{
                                File fyl=jfc.getSelectedFile();
                                OpenFile(fyl.getAbsolutePath());
                                this.setTitle(fyl.getName()+ " - Notepad");
                                fnameContainer=fyl;
                            }catch(IOException ers){}
                        }
                    }
                case "Save" ->                     {
                        //save
                        if(fnameContainer != null){
                            jfc.setCurrentDirectory(fnameContainer);
                            jfc.setSelectedFile(fnameContainer);
                        }
                        else {
                            //jfc.setCurrentDirectory(new File("."));
                            jfc.setSelectedFile(new File("Untitled.txt"));
                        }
                        int ret=jfc.showSaveDialog(null);
                        if(ret == JFileChooser.APPROVE_OPTION){
                            try{
                                
                                File fyl=jfc.getSelectedFile();
                                SaveFile(fyl.getAbsolutePath());
                                this.setTitle(fyl.getName()+ " - Notepad");
                                fnameContainer=fyl;
                                
                            }catch(IOException ers2){}
                        }
                    }
                case "Exit" -> //exit
                    Exiting();
                case "Copy" -> //copy
                    jta.copy();
                case "Paste" -> //paste
                    jta.paste();
                case "About Notepad" -> //about
                    JOptionPane.showMessageDialog(this,"Created by: Ferdinand Silva (http://ferdinandsilva.com)","Notepad",JOptionPane.INFORMATION_MESSAGE);
                case "Cut" -> jta.cut();
                default -> {
                }
            }
	}
	
	public void OpenFile(String fname) throws IOException {	
            try ( //open file code here
                    BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream(fname)))) {
                String l;
                //clear the textbox
                jta.setText("");
                
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
                
                while((l=d.readLine())!= null) {
                    jta.setText(jta.getText()+l+"\r\n");
                }
                
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
	}
	
	public void SaveFile(String fname) throws IOException {
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
            try (DataOutputStream o = new DataOutputStream(new FileOutputStream(fname))) {
                o.writeBytes(jta.getText());
            }		
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
    /**
     *
     * @param e
     */
    @Override
	public void windowDeactivated(WindowEvent e){}

    /**
     *
     * @param e
     */
    @Override
	public void windowActivated(WindowEvent e){}

    /**
     *
     * @param e
     */
    @Override
	public void windowDeiconified(WindowEvent e){}

    /**
     *
     * @param e
     */
    @Override
 	public void windowIconified(WindowEvent e){}

    /**
     *
     * @param e
     */
    @Override
	public void windowClosed(WindowEvent e){}
	
        @Override
	public void windowClosing(WindowEvent e) {
		Exiting();
	}
	
        @Override
	public void windowOpened(WindowEvent e){}
	
	public void Exiting() {
		System.exit(0);
	}
	
	public static void main (String[] args) {
		trial notp=new trial();	
	}
			
}
