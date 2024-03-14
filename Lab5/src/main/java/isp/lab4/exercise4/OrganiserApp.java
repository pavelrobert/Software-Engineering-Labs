package isp.lab4.exercise4;
import java.util.*;
class OrganiserApp {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31;1m";
    public static final String ANSI_GREEN = "\u001B[32;1m";
    public static final String ANSI_YELLOW = "\u001B[33;1m";
    UserApp userApp;
    TicketsManager ticketsManager;
    OrganiserApp(UserApp userApp, TicketsManager ticketsManager){
        this.userApp = userApp;
        this.ticketsManager = ticketsManager;
    }

    public void checkin() {
        if (ticketsManager.validateTicket(userApp.getTicket())) {
            System.out.println("You are checking the ticket "+ANSI_YELLOW+userApp.returnticket()+ANSI_RESET+".");
            System.out.println("The ticket " +ANSI_GREEN+ userApp.returnticket() +ANSI_RESET +" is valid.");
        } else {
            System.out.println("The ticket " +ANSI_RED+ userApp.returnticket()+ ANSI_RESET+" is not valid.");
        }

    }

    public Ticket scanTicket(User user) {
        // In a real app, this method might use QR code scanning or NFC to read the ticket ID
        UUID ticketId = UUID.randomUUID();
        return new Ticket(ticketId);
    }
}
