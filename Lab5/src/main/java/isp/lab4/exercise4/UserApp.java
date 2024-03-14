package isp.lab4.exercise4;
import java.util.UUID;
public class UserApp {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32;1m";
    public static final String ANSI_YELLOW = "\u001B[33;1m";
    private User user;
    private TicketsManager ticketsManager;
    private PaymentGateway paymentGateway;
    private boolean paymentSuccessful; // new field
    UUID id = UUID.randomUUID();
    Ticket ticket = new Ticket(id);

    public UserApp(User user, TicketsManager ticketsManager, PaymentGateway paymentGateway) {
        this.user = user;
        this.ticketsManager = ticketsManager;
        this.paymentGateway = paymentGateway;
        paymentSuccessful = paymentGateway.processPayment(true);

    }
    public void buyTicket() {
        if (paymentSuccessful && user.login()) {
            Ticket newticket = ticketsManager.generateTicket();
            ticket = newticket;
            System.out.println();
            System.out.println("Ticket purchased with id " + ANSI_GREEN+ newticket.getId()+ANSI_RESET+";");
        } else {
            System.out.println();
            System.err.println("Wrong username or password. Payment failed.");
            System.exit(0);

        }
    }

    public void viewTicket() {
        System.out.println();
        System.out.println("Username: "+user.getUsername()+".");
        System.out.println("Ticket id: " + ANSI_YELLOW +ticket.getId()+ANSI_RESET+".");
        System.out.println();
    }
    public UUID returnticket(){
        return ticket.getId();
    }
    public Ticket getTicket(){
        return ticket;
    }


}