import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class FileSaveAs implements ActionListener {

    JFileChooser fileChooser;
    JTextArea textArea;
    JFrame frame;
    JLabel label;

    public FileSaveAs(JFileChooser fileChooser, JTextArea textArea, JFrame frame, JLabel label){
        this.fileChooser = fileChooser;
        this.textArea = textArea;
        this.frame = frame;
        this.label = label;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(fileChooser.showSaveDialog(null)==fileChooser.APPROVE_OPTION){
                FileWriter fw = new FileWriter(fileChooser.getSelectedFile().getAbsolutePath());
                textArea.write(fw);
                fw.close();

                frame.setTitle(fileChooser.getSelectedFile().getName());

                label.setText("saved");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
