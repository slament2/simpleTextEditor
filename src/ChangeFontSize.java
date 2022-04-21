import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeFontSize implements ActionListener {

    int size;
    JTextArea textArea;
    JLabel label;

    public ChangeFontSize(int size, JTextArea textArea, JLabel label){
        this.size = size;
        this.textArea = textArea;
        this.label =label;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Font newFont = new Font("New Font", Font.BOLD, size);
        textArea.setFont(newFont);
        label.setText("fg "+ size);
    }
}
