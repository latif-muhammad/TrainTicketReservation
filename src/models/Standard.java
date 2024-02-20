package models;

public class Standard extends Ticket{
    public Standard(int ticket_id, String ticket_date, Trains train, Customer cus, double price) {
        super(ticket_id, ticket_date, train, cus, price);
    }
}
