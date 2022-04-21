import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(

                () -> {
                    JFrame frame = new JFrame();
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.setPreferredSize(new Dimension(640,480));
                    frame.setTitle("Text Editor - bez tytułu");
                    frame.setLocation(200,200);
                    frame.setLayout(new BorderLayout());
                    frame.setResizable(false);

                    JFileChooser fileChooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "txt");
                    fileChooser.setFileFilter(filter);
                    fileChooser.setDialogTitle("Choose your file");
                    fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

                    JPanel panel = new JPanel();
                    panel.setLayout(new BorderLayout());
                    frame.add(panel, BorderLayout.CENTER);
                    JTextArea textArea = new JTextArea();
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    panel.add(scrollPane);

                    JPanel panel2 = new JPanel();
                    SpringLayout springLayout = new SpringLayout();
                    panel2.setLayout(springLayout);
                    panel2.setPreferredSize(new Dimension(frame.getWidth(), (int) (frame.getHeight()*0.45)));
                    frame.add(panel2, BorderLayout.PAGE_END);

                    JLabel foregroundLabel = new JLabel("fg " + textArea.getFont().getSize());
                    foregroundLabel.setIcon(new MyIcon(textArea.getForeground()));
                    panel2.add(foregroundLabel);

                    JLabel backgroundLabel= new JLabel("bg");
                    backgroundLabel.setIcon(new MyIcon(textArea.getBackground()));
                    panel2.add(backgroundLabel);

                    JLabel status = new JLabel("new ");
                    panel2.add(status);

                    springLayout.putConstraint(SpringLayout.WEST, foregroundLabel, 25, SpringLayout.SOUTH, backgroundLabel);
                    springLayout.putConstraint(SpringLayout.WEST, status, (int) (frame.getWidth()*3.45), SpringLayout.SOUTH, foregroundLabel);

                    JMenuBar menuBar = new JMenuBar();
                    frame.setJMenuBar(menuBar);

                    JMenu fileMenu = new JMenu("File");
                    menuBar.add(fileMenu);

                    JMenuItem Open = new JMenuItem("Open");
                    Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
                    AddMenuItem(fileMenu, Open, new FileOpen(fileChooser, textArea, frame, status));
                    JMenuItem Save = new JMenuItem("Save");
                    Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
                    AddMenuItem(fileMenu, Save, new FileSave(fileChooser, textArea, frame, status));
                    JMenuItem SaveAs = new JMenuItem("Save as");
                    SaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
                    AddMenuItem(fileMenu, SaveAs, new FileSaveAs(fileChooser, textArea, frame, status));

                    JSeparator separator = new JSeparator();
                    separator.setForeground(Color.RED);
                    separator.setBackground(Color.RED);
                    fileMenu.add(separator);

                    JMenuItem exitItem = new JMenuItem("Exit");
                    exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
                    AddMenuItem(fileMenu, exitItem, new FileExit());

                    JMenu editMenu = new JMenu("Edit");
                    menuBar.add(editMenu);
                    JMenu addressMenu = new JMenu("Adresy");
                    editMenu.add(addressMenu);

                    JMenuItem workItem = new JMenuItem("Praca");
                    workItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
                    AddMenuItem(addressMenu, workItem, new WorkAdress(textArea));
                    JMenuItem houseItem = new JMenuItem("Dom");
                    houseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
                    AddMenuItem(addressMenu, houseItem, new HomeAddress(textArea));
                    JMenuItem schoolItem = new JMenuItem("Szkoła");
                    schoolItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
                    AddMenuItem(addressMenu, schoolItem, new SchoolAddress(textArea));

                    JMenu options = new JMenu("Options");
                    JMenu foreground = new JMenu("Foreground");
                    JMenu background = new JMenu("Background");
                    JMenu fontSize = new JMenu("Font size");
                    menuBar.add(options);
                    options.add(foreground);
                    options.add(background);
                    options.add(fontSize);

                    JRadioButtonMenuItem green = new JRadioButtonMenuItem("Green");
                    green.setIcon(new MyIcon(Color.GREEN));
                    JRadioButtonMenuItem orange = new JRadioButtonMenuItem("Orange");
                    orange.setIcon(new MyIcon(Color.orange));
                    JRadioButtonMenuItem black = new JRadioButtonMenuItem("Black");
                    black.setIcon(new MyIcon(Color.BLACK));
                    JRadioButtonMenuItem red = new JRadioButtonMenuItem("Red");
                    red.setIcon(new MyIcon(Color.RED));
                    JRadioButtonMenuItem white = new JRadioButtonMenuItem("White");
                    white.setIcon(new MyIcon(Color.WHITE));
                    JRadioButtonMenuItem yellow = new JRadioButtonMenuItem("Yellow");
                    yellow.setIcon(new MyIcon(Color.YELLOW));
                    JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Blue");
                    blue.setIcon(new MyIcon(Color.BLUE));
                    JRadioButtonMenuItem green1 = new JRadioButtonMenuItem("Green");
                    green1.setIcon(new MyIcon(Color.GREEN));
                    JRadioButtonMenuItem orange1 = new JRadioButtonMenuItem("Orange");
                    orange1.setIcon(new MyIcon(Color.orange));
                    JRadioButtonMenuItem black1 = new JRadioButtonMenuItem("Black");
                    black1.setIcon(new MyIcon(Color.BLACK));
                    JRadioButtonMenuItem red1 = new JRadioButtonMenuItem("Red");
                    red1.setIcon(new MyIcon(Color.RED));
                    JRadioButtonMenuItem white1 = new JRadioButtonMenuItem("White");
                    white1.setIcon(new MyIcon(Color.WHITE));
                    JRadioButtonMenuItem yellow1 = new JRadioButtonMenuItem("Yellow");
                    yellow1.setIcon(new MyIcon(Color.YELLOW));
                    JRadioButtonMenuItem blue1 = new JRadioButtonMenuItem("Blue");
                    blue1.setIcon(new MyIcon(Color.BLUE));

                    AddMenuItem(foreground, green, new ChangeForegroundColor(Color.GREEN, textArea, foregroundLabel));
                    AddMenuItem(foreground, orange, new ChangeForegroundColor(Color.ORANGE, textArea, foregroundLabel));
                    AddMenuItem(foreground, black, new ChangeForegroundColor(Color.black, textArea, foregroundLabel));
                    AddMenuItem(foreground, red, new ChangeForegroundColor(Color.RED, textArea, foregroundLabel));
                    AddMenuItem(foreground, white, new ChangeForegroundColor(Color.WHITE, textArea, foregroundLabel));
                    AddMenuItem(foreground, yellow, new ChangeForegroundColor(Color.YELLOW, textArea, foregroundLabel));
                    AddMenuItem(foreground, blue, new ChangeForegroundColor(Color.BLUE, textArea, foregroundLabel));
                    AddMenuItem(background, green1, new ChangeBackgroundColor(Color.GREEN, textArea, backgroundLabel));
                    AddMenuItem(background, orange1, new ChangeBackgroundColor(Color.ORANGE,textArea, backgroundLabel));
                    AddMenuItem(background, black1, new ChangeBackgroundColor(Color.black,textArea, backgroundLabel));
                    AddMenuItem(background, red1, new ChangeBackgroundColor(Color.RED,textArea, backgroundLabel));
                    AddMenuItem(background, white1, new ChangeBackgroundColor(Color.WHITE, textArea, backgroundLabel));
                    AddMenuItem(background, yellow1, new ChangeBackgroundColor(Color.YELLOW, textArea, backgroundLabel));
                    AddMenuItem(background, blue1, new ChangeBackgroundColor(Color.BLUE, textArea, backgroundLabel));

                    JRadioButtonMenuItem eight = new JRadioButtonMenuItem("8 pts");
                    eight.setFont(new Font("", Font.BOLD, 8));
                    JRadioButtonMenuItem ten = new JRadioButtonMenuItem("10 pts");
                    ten.setFont(new Font("", Font.BOLD, 10));
                    JRadioButtonMenuItem twelve = new JRadioButtonMenuItem("12 pts");
                    twelve.setFont(new Font("", Font.BOLD, 12));
                    JRadioButtonMenuItem fourteen = new JRadioButtonMenuItem("14 pts");
                    fourteen.setFont(new Font("", Font.BOLD, 14));
                    JRadioButtonMenuItem eighteen = new JRadioButtonMenuItem("18 pts");
                    eighteen.setFont(new Font("", Font.BOLD, 18));
                    JRadioButtonMenuItem twenty = new JRadioButtonMenuItem("20 pts");
                    twenty.setFont(new Font("", Font.BOLD, 20));
                    JRadioButtonMenuItem twentyFour = new JRadioButtonMenuItem("24 pts");
                    twentyFour.setFont(new Font("", Font.BOLD, 24));

                    AddMenuItem(fontSize, eight, new ChangeFontSize(8, textArea, foregroundLabel) );
                    AddMenuItem(fontSize, ten, new ChangeFontSize(10, textArea, foregroundLabel) );
                    AddMenuItem(fontSize, twelve, new ChangeFontSize(12, textArea, foregroundLabel));
                    AddMenuItem(fontSize, fourteen, new ChangeFontSize(14, textArea, foregroundLabel));
                    AddMenuItem(fontSize, eighteen, new ChangeFontSize(18, textArea, foregroundLabel) );
                    AddMenuItem(fontSize, twenty, new ChangeFontSize(20, textArea, foregroundLabel));
                    AddMenuItem(fontSize, twentyFour, new ChangeFontSize(24, textArea, foregroundLabel));

                    frame.pack();
                }
        );
    }

    public static void AddMenuItem(JMenu menu, JMenuItem item, ActionListener AL){
        menu.add(item);
        item.addActionListener(AL);
    }

}


