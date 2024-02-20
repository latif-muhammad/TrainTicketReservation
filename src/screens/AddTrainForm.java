package screens;
import components.TField;
import models.Trains;
import utils.MyConstants;
import utils.store;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTrainForm extends JFrame implements ActionListener {
    TField trainID;
    TField trainType;
    TField from;
    TField to;
    TField fare;
    TField time;
    TField luxSeats;
    TField strdSeats;
    TField superLuxSeats;

    JButton submit;
    JLabel error = new JLabel("");;


    private JFrame formFrame;
    private JPanel formContainer;

    AddTrainForm(){
        formFrame = new JFrame();
        formContainer = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
        formFrame.setSize(1000,700);
        formFrame.setLayout(new FlowLayout(FlowLayout.CENTER,0,40));
        formFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formFrame.getContentPane().setBackground(new Color(29, 29, 29));

        //inner square
        formContainer.setBackground(MyConstants.PRIMARY_COLOR);
        formContainer.setPreferredSize(new Dimension((int) (MyConstants.WIDTH/2.6),(int)(MyConstants.HEIGHT/2)));
        formFrame.add(formContainer);
        formContainer.setBorder(new EmptyBorder(10, 30, 30, 50));

        JLabel lo = new JLabel("Add Train");
        lo.setFont(new Font("Consolas", Font.PLAIN, 30));
        lo.setForeground(Color.WHITE);
        formContainer.add(lo);


        trainID = new TField(324,"Train ID");
        trainType = new TField(324,"Train Type");
        from = new TField(324,"Departure City");
        to = new TField(324,"Arrival City");
        fare = new TField(324,"Fare");
        time = new TField(324,"Departure time");
        strdSeats = new TField(190,"Standard Seats");
        luxSeats = new TField(190,"Luxury seats");
        superLuxSeats = new TField(190,"Super Luxury seats");





        JPanel container = new JPanel(new BorderLayout());
        container.setPreferredSize(new Dimension(650,50));
        container.add(trainID,BorderLayout.WEST);
        container.add(trainType,BorderLayout.EAST);
        container.setOpaque(false);


        JPanel subContainer = new JPanel(new BorderLayout());
        subContainer.setPreferredSize(new Dimension(650,50));
        subContainer.add(from,BorderLayout.WEST);
        subContainer.add(to,BorderLayout.EAST);
        subContainer.setOpaque(false);

        JPanel subContainer2 = new JPanel(new BorderLayout());
        subContainer2.setPreferredSize(new Dimension(650,50));
        subContainer2.add(time,BorderLayout.WEST);
        subContainer2.add(fare,BorderLayout.EAST);
        subContainer2.setOpaque(false);


        JPanel subContainer3 = new JPanel(new BorderLayout(2,0));
        subContainer3.setPreferredSize(new Dimension(650,50));
        subContainer3.add(strdSeats,BorderLayout.WEST);
        subContainer3.add(luxSeats,BorderLayout.CENTER);
        subContainer3.add(superLuxSeats,BorderLayout.EAST);
        subContainer3.setOpaque(false);



        submit = new JButton("Add Train");
        submit.setPreferredSize(new Dimension(650,45));
        submit.addActionListener(this);


        error.setFont(new Font("Consolas", Font.PLAIN, 18));
        error.setForeground(Color.white);

        formContainer.add(container);
        formContainer.add(subContainer);
        formContainer.add(subContainer2);
        formContainer.add(subContainer3);
        formContainer.add(submit);
        formContainer.add(error);



        formFrame.setResizable(false);
        formFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new AddTrainForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Trains train = new Trains(Integer.parseInt(trainID.getText()),trainType.getText(),from.getText(),to.getText(),time.getText(),fare.getText(),Integer.parseInt(strdSeats.getText()),Integer.parseInt(luxSeats.getText()),Integer.parseInt(superLuxSeats.getText()));
            store.trains.add(train);
            AdminScreen s = new AdminScreen();
            this.setVisible(false);
            s.setVisible(true);
        }catch (Exception err){
            error.setText("Incorrect Input, Please put the correct Input");
        }
    }
}
