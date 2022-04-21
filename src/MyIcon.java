import java.awt.*;

public class MyIcon implements javax.swing.Icon {

    Color c;

    public MyIcon(Color c){
        this.c =c;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(this.c);
        g.fillOval(this.getIconHeight()/2-3, this.getIconWidth()/2-3, this.getIconWidth(), this.getIconHeight());
    }

    @Override
    public int getIconWidth() {
        return 12;
    }

    @Override
    public int getIconHeight() {
        return 12;
    }
}
