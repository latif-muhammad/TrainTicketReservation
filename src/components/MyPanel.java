package components;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel(Color color, int width, int height){
        this.setBackground(color);
        this.setPreferredSize(new Dimension(width,height));
    }

}
