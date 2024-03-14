package isp.lab6.exercise3;

import java.net.PasswordAuthentication;
import java.util.Comparator;
import java.util.Scanner;

public class UserInterface
{
    private OnlineStore store;
    private LoginSystem loginSyst;

    UserInterface()
    {
        store=new OnlineStore();
        loginSyst=new LoginSystem(store);
    }

    public static void menulogin()
    {
        System.out.println("========WELCOME========");
        System.out.println("Please input the index of the action you would like to do! Keep in mind that you can login only if you register first!\n");
        System.out.println("1.REGISTER");
        System.out.println("2.LOGIN");
        System.out.println("3.EXIT");
    }

    public static void menustore()
    {
        System.out.println("========WELCOME TO THE ONLINE STORE===========");
        System.out.println("Please input the index of the action you would like to do!\n");
        System.out.println("1.GET THE PRODUCT LIST");
        System.out.println("2.GET THE PRODUCT ORDERED BY PRICE");
        System.out.println("3.ADD A PRODUCT TO CART");
        System.out.println("4.CHECKOUT");
        System.out.println("5.LOGOUT");

    }

    public void loadinterface()
    {
        Scanner cin=new Scanner(System.in);
        menulogin();
        int opt1=cin.nextInt();
        int opt2;
        String user,password;
        while(true)
        {
            switch(opt1)
            {
                case 1:
                    System.out.println("Select a username:");
                    user=cin.next();
                    System.out.println("Select a password:");
                    password=cin.next();
                    loginSyst.register(user,password);
                    System.out.println("Account Created!");
                    break;
                case 2:
                    System.out.println("Input your user:");
                    user=cin.next();
                    System.out.println("Input your password:");
                    password=cin.next();
                    if(loginSyst.login(user,password)==true)
                    {
                        menustore();
                        opt2 = cin.nextInt();
                        boolean x = true;
                        while (x) {
                            switch (opt2) {
                                case 1:
                                    System.out.println(store.getProducts());
                                    break;
                                case 2:
                                    Comparator<Product> sortByPrice = Comparator.comparing(Product::getPrice);
                                    System.out.println(store.getProductsSorted(sortByPrice));
                                    break;
                                case 3:
                                    System.out.println("Input the item index:\n1 = PS5\n2 = Headset\n3 = Video Game\n4 = Controller\n");
                                    int item = cin.nextInt();
                                    item--;
                                    System.out.println("Input quantity:");
                                    int quant = cin.nextInt();
                                    Product test=store.getProducts().get(item);
                                    store.addToCart(user, test ,quant);
                                    break;
                                case 4:
                                    System.out.println(store.checkout(user));
                                    break;
                                case 5:
                                    System.out.println("Input logout username:");
                                    user=cin.next();
                                    x = false;
                                    loginSyst.logout(user);
                                    break;
                                case 6:
                                    x=false;
                                    break;
                                default:
                                    System.out.println("There is no such option!Please input a valid option!");
                                    break;
                            }
                            menustore();
                            opt2 = cin.nextInt();
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("There is no such option!Please input a valid option!");
            }
            menulogin();
            opt1=cin.nextInt();
        }

    }
}