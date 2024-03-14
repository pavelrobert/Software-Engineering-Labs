package isp.lab4.exercise4;


public class Exercise4 {
    public static void main(String[] args) {

        PaymentGateway paymentGateway = new PaymentGateway(true);
        TicketsManager ticketsManager = new TicketsManager();
        User user = new User("user", "user");
        UserApp userApp = new UserApp(user, ticketsManager, paymentGateway);

        Organiser organiser = new Organiser("admin", "admin");
        OrganiserApp organiserApp = new OrganiserApp(userApp, ticketsManager);

        userApp.buyTicket();
        userApp.viewTicket();
        organiserApp.checkin();

    }
}
