package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.Set;

public class LoginSystem
{
    private Set<User> users;
    private OnlineStore store;

    LoginSystem(OnlineStore onlinestore)
    {
        users=new HashSet<>();
        store=onlinestore;
    }

    public void register(String user,String password)
    {
        User user1=new User(password,user);
        users.add(user1);
    }

    public boolean login(String user,String passsword)
    {
        for(User users:users)
        {
            if(users.getUsername().equals(user) && users.getPassword().equals(passsword))
            {
                System.out.println("You are now logged in!");
                store.addSession(user);
                return true;
            }
        }
        System.out.println("Credentials are wrong!");
        return false;
    }

    public boolean logout(String user)
    {
        for(User x:users)
            if(x.getUsername().equals(user)) {
                System.out.println("You are now logged out!");
                store.removeSession(user);
                return true;
            }
        System.out.println("No such user is logged in!");
        return false;
    }
}