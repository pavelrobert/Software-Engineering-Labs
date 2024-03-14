package isp.lab4.exercise4;
import java.util.UUID;
public class Ticket {
    private UUID id;
    public Ticket(UUID id){
        this.id = id;
    }
    public UUID getId(){
        return id;
    }
}
