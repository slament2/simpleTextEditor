import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBackgroundColor implements ActionListener {

    Color c;
    JTextArea textArea;
    JLabel label;

    public ChangeBackgroundColor(Color c, JTextArea textArea, JLabel label){
        this.c = c;
        this.textArea = textArea;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.setBackground(c);
        label.setIcon(new MyIcon(c));
    }
}