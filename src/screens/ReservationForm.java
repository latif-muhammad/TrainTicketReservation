package screens;
import components.TField;
import models.*;
import utils.MyConstants;
import utils.store;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class ReservationForm extends JFrame implements ActionListener {

    private JPanel formContainer;
    JButton submit;

    TField name;
    TField age;
    TField mobileNumber;

    TField day;
    TField month;
    TField year;

    JLabel incorrect = new JLabel("");

    String[] ticketOptions = {"Standard", "Luxury","Super-Luxury"};
    String[] trainOptions = {"from - to", "to - from"};
    static ArrayList<String> trains = new  ArrayList<>();

    JComboBox<String> ticketType;
    JComboBox<ArrayList<String>> train;

    ReservationForm(){
        init();
        formContainer = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
        this.setSize(1000,700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,40));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(29, 29, 29));

        //inner square
        formContainer.setBackground(MyConstants.PRIMARY_COLOR);
        formContainer.setPreferredSize(new Dimension((int) (MyConstants.WIDTH/2.6),(int)(MyConstants.HEIGHT/2)));
        this.add(formContainer);
        formContainer.setBorder(new EmptyBorder(10, 30, 30, 50));

        JLabel lo = new JLabel("Book your Train");
        lo.setFont(new Font("Consolas", Font.PLAIN, 40));
        lo.setForeground(Color.WHITE);
        formContainer.add(lo);

        name = new TField(650, "Passenger Name");
        age = new TField(324,"Age");
        mobileNumber = new TField(324,"Phone Number");
        day = new TField(210,"9");
        month = new TField(210,"May");
        year = new TField(210,"2022");

        ticketType = new JComboBox<>(ticketOptions);
        ticketType.setPreferredSize(new Dimension(324,5));


        train = new JComboBox(trains.toArray());
        train.setPreferredSize(new Dimension(324,45));


        submit = new JButton("Make Reservation");
        submit.setPreferredSize(new Dimension(650,45));
        submit.addActionListener(this);


        JPanel container = new JPanel(new BorderLayout());
        container.setPreferredSize(new Dimension(650,50));
        container.add(age,BorderLayout.WEST);
        container.add(mobileNumber,BorderLayout.EAST);
        container.setOpaque(false);

        JPanel dateContainer = new JPanel(new FlowLayout(FlowLayout.CENTER,6,7));
        dateContainer.setPreferredSize(new Dimension(650,50));
        dateContainer.add(day);
        dateContainer.add(month);
        dateContainer.add(year);
        dateContainer.setOpaque(false);

        JPanel trainCon = new JPanel(new BorderLayout());
        trainCon.setPreferredSize(new Dimension(650,50));
        trainCon.add(train,BorderLayout.WEST);
        trainCon.add(ticketType,BorderLayout.EAST);
        trainCon.setOpaque(false);


        incorrect.setFont(new Font("Consolas", Font.PLAIN, 18));
        incorrect.setForeground(Color.white);

        formContainer.add(name);
        formContainer.add(container);
        formContainer.add(dateContainer);
        formContainer.add(trainCon);
        formContainer.add(submit);
        formContainer.add(incorrect);


        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ReservationForm();
    }

    static void init(){
        System.out.println(store.trains);
        for(Trains i: store.trains){
            if(!trains.contains(i.getFrom() + " to " + i.getTo()))trains.add(i.getFrom() + " to " + i.getTo());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{

            int a  =Integer.parseInt(age.getText());
            if(a>0){
            Customer c = new Customer(name.getText(),mobileNumber.getText(),age.getText());
            double price;
            String dat = day.getText() + " " + month.getText().substring(0,3) + " " + year.getText();
            for (Trains t : store.trains){
                String tf =  t.getFrom() + " to " + t.getTo();
                if(Objects.equals(train.getSelectedItem(), tf)){
                    price = Double.parseDouble(t.getFare());
                    System.out.println(dat);
                    Ticket tic;
                    if (ticketType.getSelectedItem() == "Luxury"){
                        price += (price * 0.3);
                        tic = new Luxury((int) (Math.random()*100), dat, t,c,price);

                    }
                    else if(ticketType.getSelectedItem() == "Super-Luxury"){
                        price += price;
                        tic = new SuperLuxury((int) (Math.random()*100), dat, t,c,price);

                    }else{
                        tic = new Standard((int) (Math.random()*100), dat, t,c,price);
                    }

                    store.reservation.add(tic);
                    break;
                }
            }
            UserScreen f = new UserScreen(MyConstants.userName);
            f.setVisible(true);
            this.setVisible(false);}else{
                incorrect.setText("Age Can't be negative");
            }
        }catch (Exception err){
            incorrect.setText("Invalid Input, Please put the correct input");
        }
    }
}