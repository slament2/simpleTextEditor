import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolAddress implements ActionListener {

    JTextArea textArea;

    public SchoolAddress(JTextArea textArea){
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.insert("Koszykowa 86, 02-008 Warszawa", textArea.getCaretPosition());
    }
}