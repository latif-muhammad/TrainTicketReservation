package screens;
import models.Trains;
import models.User;
import utils.MyConstants;
import utils.store;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginScreen extends JFrame implements ActionListener {
    private JPanel formContainer;
    JButton submit;

    JTextField a;
    JPasswordField b;
    JLabel incorrect = new JLabel("");
    LoginScreen(){
        formContainer = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
        this.setSize(900,700);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,40));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(29, 29, 29));
        this.setTitle("Login To Your Account");

        //inner square
        formContainer.setBackground(MyConstants.SECONDARY_COLOR);
        formContainer.setPreferredSize(new Dimension((int) (MyConstants.WIDTH/2.9),(int)(MyConstants.HEIGHT/1.9)));
        this.add(formContainer);
        formContainer.setBorder(new EmptyBorder(120, 70, 70, 50));

        JLabel lo = new JLabel("Login");
        lo.setForeground(Color.white);
        lo.setFont(new Font("Consolas", Font.PLAIN, 40));
        formContainer.add(lo);

        a= new JTextField();
        b= new JPasswordField();

        submit = new JButton("Login");
        submit.setForeground(Color.WHITE);
        submit.setBackground(MyConstants.SECONDARY_COLOR);
        submit.setOpaque(false);
        submit.setPreferredSize(new Dimension(550,45));
        submit.addActionListener(this);
        submit.setFocusPainted(false);

        a.setPreferredSize(new Dimension(550,45));
        b.setPreferredSize(new Dimension(550,45));
        a.setText("Username");
        b.setText("password");
        a.setBorder(new EmptyBorder(0,20,0,0));
        b.setBorder(new EmptyBorder(0,20,0,0));


        incorrect.setFont(new Font("Consolas", Font.PLAIN, 18));
        incorrect.setForeground(Color.white);


        formContainer.add(a);
        formContainer.add(b);
        formContainer.add(submit);
        formContainer.add(incorrect);


        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        Trains t1 = new Trains(1221, "Bullet", "Karachi", "Lahore", "12:30", "300",100,10,10);
        Trains t2 = new Trains(1212, "Normal", "Lahore", "Multan", "2:30", "500",100,10,10);
        store.trains.add(t1);
        store.trains.add(t2);

        User babar = new User(1,"babar","1234","03155221122","abc road", "Customer");
        User admin = new User(2,"admin","1234","03155221122","abc road", "admin");
        store.users.add(babar);
        store.users.add(admin);

        new LoginScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User customer = store.users.get(0);
        User admin = store.users.get(1);
        String user = a.getText();
        boolean custm = (Objects.equals(user, customer.user_name) && Objects.equals(b.getText(), customer.getPassword()));
        boolean adm = (Objects.equals(user, admin.user_name) && Objects.equals(b.getText(), admin.getPassword()));

        if (custm){
            MyConstants.userName = customer.getUser_name().toUpperCase();
            UserScreen f = new UserScreen(customer.getUser_name().toUpperCase());
            f.setVisible(true);
            this.setVisible(false);
        } else if (adm) {
            MyConstants.userName = customer.getUser_name().toUpperCase();
            AdminScreen f = new AdminScreen();
            f.setVisible(true);
            this.setVisible(false);

        }else {
            incorrect.setText("username or password not correct");
        }

    }
}
