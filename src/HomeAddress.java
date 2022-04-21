import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAddress implements ActionListener {

    JTextArea textArea;

    public HomeAddress(JTextArea textArea){
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.insert("Ogrodowa 7a, 05-400 Otwock", textArea.getCaretPosition());
    }
}
