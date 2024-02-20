package utils;

import components.ReservationPanel;
import models.Ticket;
import models.Trains;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AddingFile {

    public void init(JPanel p2, ArrayList<String[]> data) {
        for (Trains train : store.trains) {
            p2.add(new ReservationPanel(train.getFare(), train.getTo(), train.getFrom(), train.getTime()));
        }
        for (Ticket t : store.reservation) {
            System.out.println("tHIS");
            String[] a = {t.getTicket_date(), t.cus.customer_name, (t.train.getFrom().substring(0, 3).toUpperCase() + " to " + t.train.getTo().substring(0, 3)).toUpperCase(), t.getClass().getName().substring(7), "RS " + t.getPrice()};
            data.add(a);
        }
    }


    public static void fileWrite(ArrayList<Ticket> str, String fileName) throws Exception {
        Object[] a = new Object[str.size()];
        for (int i = 0; i < str.size(); i++) {
            a[i] = str.get(i);
        }
        try {
            File newTextFile = new File(fileName);

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(Arrays.toString(a));
            fw.close();
        } catch (IOException e) {
            throw new IOException(e);
        }

    }


    public static void fileReader(String fileName) throws Exception {
        try {
            FileReader fr = new FileReader(fileName);
            fr.close();
        } catch (IOException e) {
            throw new IOException(e);
        }

    }

    public static void addingTrains(ArrayList<Trains> str, String fileName) throws Exception {
        Trains[] a = new Trains[str.size()];
        for (int i = 0; i < str.size(); i++) {
            a[i] = str.get(i);
        }
        try {
            File newTextFile = new File(fileName);
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(Arrays.toString(a));
            fw.close();
        } catch (IOException e) {
            throw new IOException(e);
        }

    }

}