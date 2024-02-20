package models;

public class Ticket {
    private int ticket_id;
    private String ticket_date;
    public Customer cus;
    private double price;
    public Trains train;


    public Ticket(int ticket_id, String ticket_date, Trains train, Customer cus, double price){
        this.price = price;
        this.ticket_id= ticket_id;
        this.ticket_date=ticket_date;
        this.train = train;
        this.cus = cus;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public String getTicket_date() {
        return ticket_date;
    }

    public Customer getCus() {
        return cus;
    }

    public double getPrice() {
        return price;
    }

    public Trains getTrain() {
        return train;
    }


}
