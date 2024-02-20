package screens;
import components.MyPanel;
import components.ReservationPanel;
import models.Ticket;
import models.Trains;
import utils.MyConstants;
import utils.store;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminScreen extends JFrame implements ActionListener {
    private final JPanel p1;
    private final JPanel p2;
    private final JPanel p3;
    private final JPanel p4;
    private final JPanel p5;
    JButton add;
    JButton logout;



    AdminScreen(){
        this.setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(7,7));
        this.getContentPane().setBackground(new Color(29, 29, 29));
        this.setResizable(false);


        //Layout
        p1 = new MyPanel(MyConstants.PRIMARY_COLOR,MyConstants.WIDTH,50);
        p1.setLayout(new FlowLayout(FlowLayout.RIGHT,15,10));
        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,10));
        p3 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,10));
        p4 = new JPanel();
        p5 = new JPanel();

        p2.setBackground(MyConstants.PRIMARY_COLOR);
        p3.setBackground(MyConstants.PRIMARY_COLOR);
        p4.setBackground(new Color(29, 29, 29));
        p5.setBackground(new Color(29, 29, 29));

        p3.setBorder(new EmptyBorder(0,10,0,0));
        p2.setBorder(new EmptyBorder(0,4,0,0));


        p2.setPreferredSize(new Dimension(MyConstants.WIDTH/5,70));
        p3.setPreferredSize(new Dimension(100,70));
        p4.setPreferredSize(new Dimension(1,1));
        p5.setPreferredSize(new Dimension(1,1));

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
        p1.add(MyConstants.lab("Home"));
        p1.add(MyConstants.lab("Stats"));
        p1.add(MyConstants.lab("Trains"));
        p1.add(logout);

        p1.setBorder(new EmptyBorder(5,10,13,10));

        //Table

        add= new JButton("Add Train");
        add.addActionListener(this);
        add.setFocusPainted(false);
        add.setPreferredSize(new Dimension((int)(MyConstants.WIDTH/5.1),40));
        add.setBackground(MyConstants.PRIMARY_COLOR);
        add.setForeground(Color.white);

        p3.add(MyConstants.lab("Reservation Requests"));
        p2.add(MyConstants.lab("Trains Details"));

        init();
        p2.add(add);


        this.setResizable(false);
        this.setVisible(true);

    }

    public void init(){
        for (Trains t: store.trains){
            p2.add(new ReservationPanel(t.getFare(),t.getTo(), t.getFrom(),t.getTime()));
        }
        for(Ticket res : store.reservation){
            p3.add(new UserDetail(res));
        }
    }

    public static void main(String[] args) {
        new AdminScreen();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == add){
        AddTrainForm f = new AddTrainForm();
        f.setVisible(true);
        this.setVisible(false);
        } else if(actionEvent.getSource() == logout) {
          LoginScreen f = new LoginScreen();
          f.setVisible(true);
          this.setVisible(false);
        }
    }
static class UserDetail extends JPanel implements ActionListener{
    public JButton proceed;
    public JButton decline;
    Ticket ticket;

    UserDetail(Ticket t){
        this.ticket = t;
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(775,90));

        JPanel prim = new JPanel(new FlowLayout(FlowLayout.LEFT,30,10));
        JPanel sub = new JPanel(new BorderLayout());
        prim.setPreferredSize(new Dimension(775,45));
        sub.setPreferredSize(new Dimension(775,45));
        prim.setBackground(MyConstants.SECONDARY_COLOR);
        sub.setBackground(MyConstants.MINOR_COLOR);

        this.add(prim,BorderLayout.NORTH);
        this.add(sub,BorderLayout.SOUTH);

        this.add(prim,BorderLayout.NORTH);
        this.add(sub,BorderLayout.SOUTH);


        prim.add( myLabel(t.cus.customer_name.toUpperCase()));
        prim.add( myLabel(t.cus.age + " years"));
        prim.add( myLabel(t.cus.customer_mobile));
        prim.add( myLabel("RS " + t.getPrice()));
        prim.add( myLabel(t.getTicket_date()));
        prim.add( myLabel(t.getClass().getName().substring(7).toUpperCase()));




        proceed = new JButton("More Details");
        decline = new JButton("Decline");
        proceed.setOpaque(false);
        decline.setOpaque(false);
        proceed.setBackground(MyConstants.PRIMARY_COLOR);
        decline.setBackground(MyConstants.PRIMARY_COLOR);
        decline.setForeground(Color.WHITE);
        proceed.setForeground(Color.WHITE);



        JPanel buttons = new JPanel();
        buttons.add(proceed);
//        buttons.add(decline);
        proceed.addActionListener(this);
        proceed.setFocusPainted(false);
        decline.setFocusPainted(false);
        buttons.setOpaque(false);
        buttons.setBorder(new EmptyBorder(5, 0, 0, 0));


        sub.setBorder(new EmptyBorder(0, 30, 0, 30));
        sub.add(myLabel(t.train.getFrom() +" to " + t.train.getTo()), BorderLayout.WEST);
        sub.add(buttons, BorderLayout.EAST);

    }
        public JLabel myLabel(String title){
            JLabel a = new JLabel(title);
            a.setFont(new Font("Consolas", Font.PLAIN, 17));
            a.setForeground(Color.white);
            return a;
        }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == proceed){
            ReservationDetails n = new ReservationDetails(ticket);
            n.setVisible(true);
        }
    }
}
}