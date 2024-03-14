package isp.lab4.exercise4;
import java.util.UUID;
public class TicketsManager {
    Ticket ticket;
    public Ticket generateTicket(){
        UUID id = UUID.randomUUID();
        return new Ticket(id);
    }
    public boolean validateTicket(Ticket ticket){
        return true;
    }
    public Ticket getTicket(){
        return ticket;
    }
}
