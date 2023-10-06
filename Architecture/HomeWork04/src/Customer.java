import java.util.Date;
import java.util.List;

public class Customer {
    public int id;
    public CashProvider cash;
    public List<Ticket> tickets;

    public Customer(int id, List<Ticket> tickets, long numberCard) {
        this.id = id;
        this.tickets = tickets;
        cash = new CashProvider(numberCard, false);
    }
    
    public boolean buyTicket(Ticket ticket) {
        System.out.println("Покупка билета...");
        return true;
    }
    
    public List<Ticket> searchTicket(Date date, int rootNumber) {
        System.out.println("Поиск билетов...");
        List<Ticket> tickets = new List<>();
        for (Ticket ticket: TicketProvider.getTicket(rootNumber)) {
            if (ticket.date.equals(date)) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }
}
