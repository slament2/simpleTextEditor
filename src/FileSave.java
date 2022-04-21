import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class FileSave implements ActionListener {

    JTextArea textArea;
    JFileChooser fileChooser;
    JFrame frame;
    JLabel label;

    public FileSave( JFileChooser fileChooser, JTextArea textArea, JFrame frame, JLabel label){
        this.textArea = textArea;
        this.fileChooser = fileChooser;
        this.frame = frame;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(fileChooser.getSelectedFile() == null){
                fileChooser.showSaveDialog(null);
            }

            FileWriter fw = new FileWriter(fileChooser.getSelectedFile().getAbsolutePath());
            textArea.write(fw);
            fw.close();

            frame.setTitle(fileChooser.getSelectedFile().getName());

            label.setText("saved");


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
