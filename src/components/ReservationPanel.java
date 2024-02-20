package components;
import utils.MyConstants;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ReservationPanel extends JPanel {
    String ticketPrice;

    public ReservationPanel(String ticketPrice, String to, String from, String time){
        this.setPreferredSize(new Dimension((int)(MyConstants.WIDTH/5.1),85));
        this.setLayout(new BorderLayout());

        JPanel primaryPanel = new JPanel(new BorderLayout());
        primaryPanel.setBackground(MyConstants.SECONDARY_COLOR);
        primaryPanel.setPreferredSize(new Dimension(20,55));
        primaryPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(primaryPanel,BorderLayout.NORTH);
        //content
        JPanel icon = new JPanel(new FlowLayout(FlowLayout.CENTER));
        icon.setOpaque(false);
        icon.add(MyConstants.lab("To"));
        primaryPanel.add(MyConstants.lab(to.substring(0,3).toUpperCase()), BorderLayout.EAST);
        primaryPanel.add(icon, BorderLayout.CENTER);
        primaryPanel.add(MyConstants.lab(from.substring(0,3).toUpperCase()), BorderLayout.WEST);




        //Sub panels
        JPanel subPanel = new JPanel(new BorderLayout());
        subPanel.setBackground(MyConstants.MINOR_COLOR);
        subPanel.setPreferredSize(new Dimension(50,30));
        subPanel.setBorder(new EmptyBorder(0,10,0,10));
        subPanel.add(MyConstants.lab(time),BorderLayout.WEST);
        subPanel.add(MyConstants.lab("RS " + ticketPrice + ""),BorderLayout.EAST);

        this.add(subPanel,BorderLayout.SOUTH);
        this.setOpaque(false);




    }

}
