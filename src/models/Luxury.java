package models;

public class Luxury extends Ticket{
    public Luxury(int ticket_id, String ticket_date, Trains train, Customer cus, double price) {
        super(ticket_id, ticket_date, train, cus, price);
    }
}
