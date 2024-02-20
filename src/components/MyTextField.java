package components;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends TextField {
    MyTextField(String placeHolder){
        this.setPreferredSize(new Dimension(550,45));
        this.setText("     " + placeHolder);
    }
}
