package isp.lab4.exercise4;
import java.util.Scanner;
public class User {
    private String username;
    private String password;
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public boolean login() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String enteredUsername = s.nextLine();
        System.out.println("Enter a password: ");
        String enteredPassword = s.nextLine();
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }
}
