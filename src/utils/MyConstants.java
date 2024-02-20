package utils;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class MyConstants {
    public static Color PRIMARY_COLOR = new Color(34,37,45);
    public static Color SECONDARY_COLOR = new Color(21,26,36);
    public static Color MINOR_COLOR = new Color(51,48,55);


    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) screenSize.getWidth(), HEIGHT = (int) screenSize.getHeight();

    //date
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static final Date date = new Date();
    public static final String dates = formatter.format(date);

    public static  String userName = "babar";
    public static  String password = "1234";

    public static JLabel lab(String txt){
        JLabel a = new JLabel(txt);
        a.setFont(new Font("Consolas", Font.PLAIN, 16));
        a.setForeground(Color.white);
        return a;
    }

    public static JLabel lab2(String txt){
        JLabel a = new JLabel(txt);
        a.setFont(new Font("Consolas", Font.PLAIN, 20));
        a.setForeground(Color.white);
        return a;
    }

}
