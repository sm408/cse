package TextEditorGUI;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.text.StyledDocument;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.DefaultEditorKit.CutAction;
import javax.swing.text.DefaultEditorKit.CopyAction;
import javax.swing.text.DefaultEditorKit.PasteAction;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.StyledEditorKit.ItalicAction;
import javax.swing.text.StyledEditorKit.UnderlineAction;
import javax.swing.text.StyledEditorKit.FontSizeAction;
import javax.swing.text.StyledEditorKit.FontFamilyAction;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.util.List;
import java.util.Vector;
import java.util.Arrays;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledEditorKit.AlignmentAction;

/*
 * A text editor program with basic edit and format functions.
 */
public class MyEditor {

    private JFrame frame__;
    private JTextPane editor__;
    private JComboBox<String> fontSizeComboBox__;
    private JComboBox<String> textAlignComboBox__;
    private JComboBox<String> fontFamilyComboBox__;
    private File file__;

    private static final String MAIN_TITLE = "My Editor - ";
    private static final String DEFAULT_FONT_FAMILY = "SansSerif";
    private static final int DEFAULT_FONT_SIZE = 18;
    private static final List<String> FONT_LIST = Arrays.asList(new String[]{"Arial", "Calibri", "Cambria", "Courier New", "Comic Sans MS", "Dialog", "Georgia", "Helevetica", "Lucida Sans", "Monospaced", "Tahoma", "Times New Roman", "Verdana"});
    private static final String[] FONT_SIZES = {"Font Size", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30"};
    private static final String[] TEXT_ALIGNMENTS = {"Text Align", "Left", "Center", "Right", "Justified"};

    private JMenuItem selectAll, find, replace;

    public static void main(String[] args)
            throws Exception {

        UIManager.put("TextPane.font",
                new Font(DEFAULT_FONT_FAMILY, Font.PLAIN, DEFAULT_FONT_SIZE));
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new MyEditor().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {

        frame__ = new JFrame();
        setFrameTitleWithExtn("New file");
        editor__ = new JTextPane();
        JScrollPane editorScrollPane = new JScrollPane(editor__);

        editor__.setDocument(getNewDocument());

        EditButtonActionListener editButtonActionListener
                = new EditButtonActionListener();

        JButton cutButton = new JButton(new CutAction());
        cutButton.setHideActionText(true);
        ImageIcon cut = new ImageIcon("icons/cut.png", "Cut");
        cutButton.setText("Cut");
        cutButton.addActionListener(editButtonActionListener);
        JButton copyButton = new JButton(new CopyAction());
        copyButton.setHideActionText(true);
        copyButton.setText("Copy");
        copyButton.addActionListener(editButtonActionListener);
        JButton pasteButton = new JButton(new PasteAction());
        pasteButton.setHideActionText(true);
        pasteButton.setText("Paste");
        pasteButton.addActionListener(editButtonActionListener);

        JButton boldButton = new JButton(new BoldAction());
        boldButton.setHideActionText(true);
        boldButton.setText("Bold");
        boldButton.addActionListener(editButtonActionListener);
        JButton italicButton = new JButton(new ItalicAction());
        italicButton.setHideActionText(true);
        italicButton.setText("Italic");
        italicButton.addActionListener(editButtonActionListener);
        JButton underlineButton = new JButton(new UnderlineAction());
        underlineButton.setHideActionText(true);
        underlineButton.setText("Underline");
        underlineButton.addActionListener(editButtonActionListener);

        textAlignComboBox__ = new JComboBox<String>(TEXT_ALIGNMENTS);
        textAlignComboBox__.setEditable(false);
        textAlignComboBox__.addItemListener(new TextAlignItemListener());

        fontSizeComboBox__ = new JComboBox<String>(FONT_SIZES);
        fontSizeComboBox__.setEditable(false);
        fontSizeComboBox__.addItemListener(new FontSizeItemListener());

        Vector<String> editorFonts = getEditorFonts();
        editorFonts.add(0, "Font Family");
        fontFamilyComboBox__ = new JComboBox<String>(editorFonts);
        fontFamilyComboBox__.setEditable(false);
        fontFamilyComboBox__.addItemListener(new FontFamilyItemListener());

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.add(boldButton);
        panel1.add(italicButton);
        panel1.add(underlineButton);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(cutButton);
        panel1.add(copyButton);
        panel1.add(pasteButton);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(textAlignComboBox__);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(fontFamilyComboBox__);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(fontSizeComboBox__);

        JPanel toolBarPanel = new JPanel();
        //toolBarPanel.setLayout(new BoxLayout(toolBarPanel, BoxLayout.PAGE_AXIS));
        toolBarPanel.add(panel1);

        JPanel textEditorPanel = new JPanel();
        textEditorPanel.setLayout(new BorderLayout(5, 5));
        textEditorPanel.add(toolBarPanel, BorderLayout.NORTH);
        textEditorPanel.add(editorScrollPane, BorderLayout.CENTER);

        //adding all the components created to the obj window
        JPanel panel = new JPanel();

        JPanel drawingPanel = new JPanel();
        drawingPanel.setSize(300, 300);
        drawingPanel.setVisible(true);
        drawingPanel.setBorder(new TitledBorder("Drawing Pane"));

        JPanel panel3 = new JPanel();
        panel3.add(new RectangleDraw());

        drawingPanel.add(panel3);

        JPanel all = new JPanel();
        all.setLayout(new BorderLayout(10, 10));

        all.add(panel, BorderLayout.NORTH);
        all.add(drawingPanel, BorderLayout.CENTER);

        frame__.setLayout(new BorderLayout(10, 10));
        frame__.add(textEditorPanel, BorderLayout.CENTER);
        frame__.add(all, BorderLayout.EAST);

//		frame__.add(toolBarPanel, BorderLayout.NORTH);
//		frame__.add(editorScrollPane, BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenu editMenu = new JMenu("Edit");

        JMenuItem newItem = new JMenuItem("New");
        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.addActionListener(new NewFileListener());
        JMenuItem openItem = new JMenuItem("Open...");
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.addActionListener(new OpenFileListener());
        JMenuItem saveItem = new JMenuItem("Save (...)");
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.addActionListener(new SaveFileListener());
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        selectAll = new JMenuItem("Select All");
        find = new JMenuItem("Find");
        replace = new JMenuItem("Replace");

        selectAll.addItemListener(new selectAllListener());
        find.addItemListener(new findListener());
        replace.addItemListener(new replaceListener());

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        fileMenu.add(newItem);
        fileMenu.addSeparator();
        fileMenu.add(openItem);
        fileMenu.add(saveItem);

        editMenu.add(selectAll);
        editMenu.add(find);
        editMenu.add(replace);

        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        frame__.setJMenuBar(menuBar);

        frame__.setSize(1500, 800);
        frame__.setLocation(15, 10);
        frame__.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame__.setVisible(true);

        editor__.requestFocusInWindow();
    }

    private void setFrameTitleWithExtn(String titleExtn) {

        frame__.setTitle(MAIN_TITLE + titleExtn);
    }

    private StyledDocument getNewDocument() {

        StyledDocument doc = new DefaultStyledDocument();
        return doc;
    }

    /*
	 * Returns a collection of Font names that are available from the
	 * system fonts and are matched with the desired font list (FONT_LIST).
     */
    private Vector<String> getEditorFonts() {

        String[] availableFonts
                = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        Vector<String> returnList = new Vector<>();

        for (String font : availableFonts) {

            if (FONT_LIST.contains(font)) {

                returnList.add(font);
            }
        }

        return returnList;
    }

    private class EditButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            editor__.requestFocusInWindow();
        }
    }

//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == selectAll) {
//// select all the text
//            editor__.selectAll();
//        } else if (e.getSource() == find) {
//// show a dialog to find a word in the text area
//            String word = JOptionPane.showInputDialog(this, "Enter the word to find:");
//            if (word != null) {
//                int startIndex = editor__.getText().indexOf(word);
//                if (startIndex != -1) {
//                    int endIndex = startIndex + word.length();
//                    editor__.select(startIndex, endIndex);
//                } else {
//                    JOptionPane.showMessageDialog(this, "Word not found");
//                }
//            }
//        } else if (e.getSource() == replace) {
//// show a dialog to replace a word in the text area
//            String findWord = JOptionPane.showInputDialog(this, "Enter the word to find:");
//            if (findWord != null) {
//                int startIndex = editor__.getText().indexOf(findWord);
//                if (startIndex != -1) {
//                    int endIndex = startIndex + findWord.length();
//                    editor__.select(startIndex, endIndex);
//                    String replaceWord = JOptionPane.showInputDialog(this, "Enter the word to replace:");
//                    if (replaceWord != null) {
//                        editor__.replaceRange(replaceWord, startIndex, endIndex);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "Word not found");
//                }
//            }
//        }
//    }
    private class selectAllListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            // select all the text
            editor__.requestFocusInWindow();
            editor__.selectAll();
        }
    }
    
    private class findListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            // select all the text
            // show a dialog to find a word in the text area
            String word = JOptionPane.showInputDialog(this, "Enter the word to find:");
            if (word != null) {
                int startIndex = editor__.getText().indexOf(word);
                if (startIndex != -1) {
                    int endIndex = startIndex + word.length();
                    editor__.select(startIndex, endIndex);
                }
            }
        }
    }
    
    private class replaceListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            // select all the text
            
            editor__.selectAll();
        }
    }

    private class TextAlignItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if ((e.getStateChange() != ItemEvent.SELECTED)
                    || (textAlignComboBox__.getSelectedIndex() == 0)) {

                return;
            }

            String alignmentStr = (String) e.getItem();
            int newAlignment = textAlignComboBox__.getSelectedIndex() - 1;
            // New alignment is set based on these values defined in StyleConstants:
            // ALIGN_LEFT 0, ALIGN_CENTER 1, ALIGN_RIGHT 2, ALIGN_JUSTIFIED 3
            textAlignComboBox__.setAction(new AlignmentAction(alignmentStr, newAlignment));
            textAlignComboBox__.setSelectedIndex(0); // initialize to (default) select
            editor__.requestFocusInWindow();
        }
    } // TextAlignItemListener

    private class FontSizeItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if ((e.getStateChange() != ItemEvent.SELECTED)
                    || (fontSizeComboBox__.getSelectedIndex() == 0)) {

                return;
            }

            String fontSizeStr = (String) e.getItem();
            int newFontSize = 0;

            try {
                newFontSize = Integer.parseInt(fontSizeStr);
            } catch (NumberFormatException ex) {

                return;
            }

            fontSizeComboBox__.setAction(new FontSizeAction(fontSizeStr, newFontSize));
            fontSizeComboBox__.setSelectedIndex(0); // initialize to (default) select
            editor__.requestFocusInWindow();
        }
    } // FontSizeItemListener

    private class FontFamilyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if ((e.getStateChange() != ItemEvent.SELECTED)
                    || (fontFamilyComboBox__.getSelectedIndex() == 0)) {

                return;
            }

            String fontFamily = (String) e.getItem();
            fontFamilyComboBox__.setAction(new FontFamilyAction(fontFamily, fontFamily));
            fontFamilyComboBox__.setSelectedIndex(0); // initialize to (default) select
            editor__.requestFocusInWindow();
        }
    } // FontFamilyItemListener

    private StyledDocument getEditorDocument() {

        StyledDocument doc = (DefaultStyledDocument) editor__.getDocument();
        return doc;
    }

    private class NewFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            initEditorAttributes();
            editor__.setDocument(getNewDocument());
            file__ = null;
            setFrameTitleWithExtn("New file");
        }

        private void initEditorAttributes() {

            AttributeSet attrs1 = editor__.getCharacterAttributes();
            SimpleAttributeSet attrs2 = new SimpleAttributeSet(attrs1);
            attrs2.removeAttributes(attrs1);
            editor__.setCharacterAttributes(attrs2, true);
        }
    }

    private class OpenFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            file__ = chooseFile();

            if (file__ == null) {

                return;
            }

            readFile(file__);
            setFrameTitleWithExtn(file__.getName());
        }

        private File chooseFile() {

            JFileChooser chooser = new JFileChooser();

            if (chooser.showOpenDialog(frame__) == JFileChooser.APPROVE_OPTION) {

                return chooser.getSelectedFile();
            } else {
                return null;
            }
        }

        private void readFile(File file) {

            StyledDocument doc = null;

            try ( InputStream fis = new FileInputStream(file);  ObjectInputStream ois = new ObjectInputStream(fis)) {

                doc = (DefaultStyledDocument) ois.readObject();
            } catch (FileNotFoundException ex) {

                JOptionPane.showMessageDialog(frame__, "Input file was not found!");
                return;
            } catch (ClassNotFoundException | IOException ex) {

                throw new RuntimeException(ex);
            }

            editor__.setDocument(doc);
        }

    }

    private class SaveFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (file__ == null) {

                file__ = chooseFile();

                if (file__ == null) {

                    return;
                }
            }

            DefaultStyledDocument doc = (DefaultStyledDocument) getEditorDocument();

            try ( OutputStream fos = new FileOutputStream(file__);  ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(doc);
            } catch (IOException ex) {

                throw new RuntimeException(ex);
            }

            setFrameTitleWithExtn(file__.getName());
        }

        private File chooseFile() {

            JFileChooser chooser = new JFileChooser();

            if (chooser.showSaveDialog(frame__) == JFileChooser.APPROVE_OPTION) {

                return chooser.getSelectedFile();
            } else {
                return null;
            }
        }
    }
}

class ResizeRectangle extends JPanel {

    private final int SIZE = 8;
    //Below are 3 points, points[0] and [1] and top-left and bottom-right of the shape.
    // points[2] is the center of the shape
    private final Rectangle2D[] points = {new Rectangle2D.Double(50, 50, SIZE, SIZE),
        new Rectangle2D.Double(150, 100, SIZE, SIZE),
        new Rectangle2D.Double(100, 75, SIZE, SIZE)};
    Rectangle2D s = new Rectangle2D.Double();

    ShapeResizeHandler ada = new ShapeResizeHandler();

    public ResizeRectangle() {
        addMouseListener(ada);
        addMouseMotionListener(ada);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for (Rectangle2D point : points) {
            g2.fill(point);
        }
        s.setFrame(points[0].getCenterX(), points[0].getCenterY(),
                Math.abs(points[1].getCenterX() - points[0].getCenterX()),
                Math.abs(points[1].getCenterY() - points[0].getCenterY()));
        g2.draw(s);
    }

    class ShapeResizeHandler extends MouseAdapter {

        private final Point2D[] lastPoints = new Point2D[3];
        private int pos = -1;

        @Override
        public void mousePressed(MouseEvent event) {
            Point p = event.getPoint();

            for (int i = 0; i < points.length; i++) {
                if (points[i].contains(p)) {
                    pos = i;
                    // initialize preDrag points
                    for (int j = 0; j < 3; j++) {
                        lastPoints[j] = new Point2D.Double(points[j].getX(), points[j].getY());
                    }
                    return;
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            pos = -1;
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            if (pos == -1) {
                return;
            }
            if (pos != 2) { //if 2, it's a shape drag
                points[pos].setRect(event.getPoint().x, event.getPoint().y, points[pos].getWidth(),
                        points[pos].getHeight());
                int otherEnd = (pos == 1) ? 2 : 1; //Get the end other than what is being dragged (top-left or bottom-right)
                //Get the x,y of the centre of the line joining the 2 new diagonal vertices, which will be new points[2]
                double newPoint2X = points[otherEnd].getX() + (points[pos].getX() - points[otherEnd].getX()) / 2;
                double newPoint2Y = points[otherEnd].getY() + (points[pos].getY() - points[otherEnd].getY()) / 2;
                points[2].setRect(newPoint2X, newPoint2Y, points[2].getWidth(), points[2].getHeight());
            } else { //Shape drag, 1,2,3 points/marker rects need to move equal amounts
                Double deltaX = event.getPoint().x - lastPoints[2].getX();
                Double deltaY = event.getPoint().y - lastPoints[2].getY();
                for (int j = 0; j < 3; j++) {
                    points[j].setRect((lastPoints[j].getX() + deltaX), (lastPoints[j].getY() + deltaY), points[j].getWidth(),
                            points[j].getHeight());
                }

            }
            repaint();
        }
    }
}

class RectangleDraw extends JPanel {

    private static final int PREF_W = 500;
    private static final int PREF_H = 650;
    private static final Color TEMP_RECT_COLOR = Color.LIGHT_GRAY;
    private static final Color SHAPE_COLOR = Color.RED;
    private Rectangle tempRect = null;
    private List<Shape> shapes = new ArrayList<>();

    public RectangleDraw() {
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // draw the temporary rectangle if not null
        if (tempRect != null) {
            g2.setColor(TEMP_RECT_COLOR);
            g2.draw(tempRect);
        }
        // draw all the rectangles in the list
        g2.setColor(SHAPE_COLOR);
        for (Shape shape : shapes) {
            g2.draw(shape);
        }
    }

    // size the GUI to my specification
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    // My mouse listener and mouse motion listener
    private class MyMouse extends MouseAdapter {

        private Point p1; // start point

        @Override
        public void mousePressed(MouseEvent e) {
            p1 = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // create temporary rectangle
            tempRect = createRectangle(e);
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            tempRect = null; // null temp rectangle and
            // add rectangle to List
            shapes.add(createRectangle(e));
            repaint();
        }

        // create a rectangle from start point and current point
        private Rectangle createRectangle(MouseEvent e) {
            Point p2 = e.getPoint();
            int x = Math.min(p1.x, p2.x);
            int y = Math.min(p1.y, p2.y);
            int w = Math.abs(p1.x - p2.x);
            int h = Math.abs(p1.y - p2.y);
            Rectangle rect = new Rectangle(x, y, w, h);
            return rect;
        }
    }
}
