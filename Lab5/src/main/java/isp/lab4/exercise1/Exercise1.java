package isp.lab4.exercise1;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Exercise1 {

    public static void main(String[] args) {
        Address address1 = new Address("Str. Daicoviciu", "Cluj");
        Address address2 = new Address("Str. Obs", "Cluj");

        Customer customer1 = new Customer("No.1", "Robert","0730874832",address2);
        Customer customer2 = new Customer("No.2", "Dani", "0746273846",address1);

        Product p1 = new Product("1","Teddy Bear",13.45,ProductCategory.TOYS,customer1);
        Product p2 = new Product("2","Toy Car", 20.80,ProductCategory.TOYS,customer1);
        Product p3 = new Product("3","Make-Up Set", 75,ProductCategory.BEAUTY,customer2);
        Product p4 = new Product("4", "PS5",3500,ProductCategory.ELECTRONICS,customer1);
        Product p5 = new Product("5","Hoodie",60,ProductCategory.FASHION,customer2);
        Product p6 = new Product("6","T-Shirt",35,ProductCategory.FASHION,customer1);

        Order order1 = new Order();
        Order order2 = new Order();

        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.addProduct(p4);
        order1.addProduct(p6);

        order2.addProduct(p3);
        order2.addProduct(p5);

        System.out.println("\n" + "Order of customer " + customer1.getName());
        ArrayList<Product> products1 = order1.getProducts();
        for(Product product : products1){
            System.out.println(product.getName() + " costs " + product.getPrice() + " $");
        }
        System.out.println("\n" + "Order of customer " + customer2.getName());
        ArrayList<Product> products2 = order2.getProducts();
        for(Product product : products2){
            System.out.println(product.getName() + " costs " + product.getPrice() + " $");
        }
    }
}
