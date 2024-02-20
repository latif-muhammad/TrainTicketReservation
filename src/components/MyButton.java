package components;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyButton extends JPanel {
    public MyButton(String title, Color a){
        JButton myButton = new JButton(title);
        myButton.setBackground(a);
        myButton.setBorder(new RoundBtn(105));
        myButton.getBorder();
        this.add(myButton);

    }
}
 class RoundBtn implements Border
{
    private int r;
    public RoundBtn(int r) {
        this.r = r;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}