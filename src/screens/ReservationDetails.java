package screens;

import models.Customer;
import models.Ticket;
import models.Trains;
import utils.MyConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ReservationDetails extends JFrame {
    ReservationDetails(Ticket t){
        this.setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout(7,7));
        this.getContentPane().setBackground(new Color(29, 29, 29));
        this.setTitle("Reservation Details of " + t.getCus().customer_name.toUpperCase());

        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        p.setBackground(new Color(29, 29, 29));
        p.setBorder(new EmptyBorder(20,20,20,20));

        this.add(p);
        p.add(MyConstants.lab("Reservation Details of " + t.getCus().customer_name.toUpperCase()));

        Customer cs = t.cus;
        Trains tr = t.train;

        String[][] data = {
                { "Passenger Name", cs.customer_name },
                { "Age", cs.age},
                { "Phone No", cs.customer_mobile},
                {"TrainId", ""+tr.getTrainId()},
                {"Train Type", tr.getTrainType()},
                {"From", tr.getFrom()},
                {"To", tr.getTo()},
                {"Time",t.getTicket_date()},
                {"Ticket Id", "" + t.getTicket_id()},
                {"Ticket Type", t.getClass().getName().substring(7).toUpperCase()},
                {"Ticket Price", "" + t.getPrice()},

        };
        JTable j;

        // Column Names
        String[] columnNames = { " ", " "};

        j = new JTable(data, columnNames);
        j.setPreferredSize(new Dimension(1000,800));

        j.setDefaultEditor(Object.class, null);
        j.setBackground(new Color(29, 29, 29));
        j.setFillsViewportHeight(true);
        j.setShowVerticalLines(false);
        p.add(j);

        j.setForeground(new Color(186,210,208));
        j.setIntercellSpacing(new Dimension(100,30));
        j.setRowHeight(50);
        j.setFont(new Font("", Font.PLAIN, 16));

        this.setVisible(true);
    }

}
