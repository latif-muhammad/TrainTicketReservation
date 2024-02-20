package components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TField extends JTextField {
    public TField(int width, String text){
        this.setText(text);
        this.setPreferredSize(new Dimension(width,45));
        this.setBorder(new EmptyBorder(0,20,0,0));
        this.setFont(new Font("Consolas", Font.PLAIN, 15));
    }

}