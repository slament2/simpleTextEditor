import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

public class FileOpen implements ActionListener {

    JFileChooser fileChooser;
    JTextArea textArea;
    JFrame frame;
    JLabel label;

    public FileOpen(JFileChooser fileChooser, JTextArea textArea, JFrame frame, JLabel label) {
        this.fileChooser = fileChooser;
        this.textArea = textArea;
        this.frame = frame;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(fileChooser.showOpenDialog(null) == fileChooser.APPROVE_OPTION){
                FileReader fr = new FileReader(fileChooser.getSelectedFile().getAbsolutePath());
                textArea.read(fr, null);
                fr.close();

                label.setText("saved");
                frame.setTitle(fileChooser.getSelectedFile().getName());
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
