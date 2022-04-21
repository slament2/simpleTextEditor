import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkAdress implements ActionListener {

    JTextArea textArea;

    public WorkAdress(JTextArea textArea){
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.insert("Piaskowa 6, 05-400, Otwock", textArea.getCaretPosition());
    }
}