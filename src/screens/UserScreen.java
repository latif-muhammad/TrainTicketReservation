package screens;
import components.MyPanel;
import components.ReservationPanel;
import models.Ticket;
import models.Trains;
import utils.AddingFile;
import utils.MyConstants;
import utils.store;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserScreen extends JFrame implements ActionListener {
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel p3;
    private final JPanel p4;
    private final JPanel p5;

    private JTable reservationTable;
    JButton add;
    JButton logout;

    JPanel subPanel;

    ArrayList<Object> data = new ArrayList<>();
    DefaultTableModel tableModel;

    String[] column={"","","","",""};

    UserScreen(String userName){
        System.out.println("RESERVATON  " + store.reservation);

        this.setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(7,7));
        this.getContentPane().setBackground(new Color(29, 29, 29));
        this.setTitle("Welcome " + userName);


        //Layout
        p1 = new MyPanel(MyConstants.PRIMARY_COLOR,MyConstants.WIDTH,50);
        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,10));
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        p2.setBackground(MyConstants.PRIMARY_COLOR);
        p3.setBackground(MyConstants.PRIMARY_COLOR);
        p4.setBackground(MyConstants.PRIMARY_COLOR);
        p5.setBackground(MyConstants.PRIMARY_COLOR);
        p2.setBorder(new EmptyBorder(0,4,0,0));

        p2.setPreferredSize(new Dimension(MyConstants.WIDTH/5,70));
        p3.setPreferredSize(new Dimension(100,70));
        p4.setPreferredSize(new Dimension(10,10));
        p5.setPreferredSize(new Dimension(5,5));

        this.add(p1,BorderLayout.NORTH);
        this.add(p2,BorderLayout.WEST);
        this.add(p3,BorderLayout.CENTER);
        this.add(p4,BorderLayout.EAST);
        this.add(p5,BorderLayout.SOUTH);



        logout = new JButton("Logout");
        logout.addActionListener(this);
        logout.setFocusPainted(false);
        logout.setBackground(MyConstants.PRIMARY_COLOR);
        logout.setForeground(Color.white);

        //navbar
        p1.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));
        p1.add(MyConstants.lab("Home"));
        p1.add(MyConstants.lab("Stats"));
        p1.add(MyConstants.lab("Trains"));
        p1.add(logout);
        p1.setBorder(new EmptyBorder(5,10,13,10));

        p3.add(MyConstants.lab("Your Reservations"));
        add= new JButton("Add Reservations");
        add.addActionListener(this);
        add.setFocusPainted(false);
        add.setPreferredSize(new Dimension((int)(MyConstants.WIDTH/5.1),40));
        add.setBackground(MyConstants.PRIMARY_COLOR);
        add.setForeground(Color.white);
        p2.add(MyConstants.lab("Available Trains"));
        init();
        p2.add(add);

        this.setResizable(false);
        this.setVisible(true);

    }

    public void creatingTable() {

        p3.setLayout(new FlowLayout());
        tableModel = new DefaultTableModel(column, 0);
        reservationTable = new JTable(tableModel);
        reservationTable.setDefaultEditor(Object.class, null);
        reservationTable.setBackground(MyConstants.PRIMARY_COLOR);
        reservationTable.setFillsViewportHeight(true);
        reservationTable.setShowVerticalLines(false);

        // Sub-Table panel
        subPanel  = new JPanel();
        subPanel.setPreferredSize(new Dimension(750,MyConstants.HEIGHT));
        subPanel.setLayout(new GridLayout());
        subPanel.add(reservationTable);

        p3.add(subPanel);
        reservationTable.setForeground(new Color(186,210,208));
        reservationTable.setIntercellSpacing(new Dimension(40,30));
        reservationTable.setRowHeight(50);
        reservationTable.setFont(new Font("", Font.PLAIN, 16));

        for (Object i:data){ tableModel.addRow((Object[]) i);}


    }

    public void init() {
        for (Trains train : store.trains){
            p2.add(new ReservationPanel(train.getFare(),train.getTo(),train.getFrom(),train.getTime()));
        }
        for (Ticket t : store.reservation){
            System.out.println("tHIS");
            String[] a = {t.getTicket_date(), t.cus.customer_name, (t.train.getFrom().substring(0,3).toUpperCase() + " to " + t.train.getTo().substring(0,3)).toUpperCase(),t.getClass().getName().substring(7), "RS " + t.getPrice()};
            data.add(a);
        }
        creatingTable();

    }

    public static void main(String[] args) {
        new UserScreen("");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == add){
            ReservationForm frame = new ReservationForm();
            frame.setVisible(true);
            this.setVisible(false);
        } else {
            LoginScreen f = new LoginScreen();
            try {
                AddingFile.fileWrite(store.reservation, "reservations.txt");
                AddingFile.addingTrains(store.trains, "trains.txt");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            f.setVisible(true);
            this.setVisible(false);
        }

    }
}
