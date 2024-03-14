package isp.lab6.exercise3;

import java.util.*;

public class OnlineStore
{
    private List<Product> products;
    private Map<String,ActiveSession> session;

    OnlineStore()
    {
        products=new ArrayList<Product>();
        Product p1=new Product("PS5",3500);
        Product p2=new Product("Headset",300);
        Product p3=new Product("Video Game",50);
        Product p4=new Product("Controller",400);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        session=new HashMap<String,ActiveSession>();
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public List<Product> getProductsSorted(Comparator<Product> sortCriteria)
    {
        List<Product> product=new ArrayList<Product>();
        product=products;
        product.sort(sortCriteria);
        return product;
    }

    void addSession(String username)
    {
        ActiveSession user=new ActiveSession(username);
        session.put(username,user);
    }

    void removeSession(String username)
    {
        ActiveSession user=new ActiveSession(username);
        session.remove(username,user);
    }

    public void addToCart(String user,Product product,int quantity)
    {
        session.get(user).addToCart(product,quantity);
    }

    public String checkout(String user)
    {
        int sum=0;
        Map<Product,Integer> products1=session.get(user).getShoppingCart();
        for(Product i:products1.keySet())
        {
            sum += i.getPrice() * products1.get(i);
        }
        return "User:"+user+"\nCurrent Items:"+session.get(user).getShoppingCart()+"\nTotal:"+sum+"RON";
    }

}
