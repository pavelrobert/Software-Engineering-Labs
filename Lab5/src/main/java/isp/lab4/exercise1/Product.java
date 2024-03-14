package isp.lab4.exercise1;

public class Product {
    private String productId;
    private String name;
    private double price;
    private ProductCategory productCategory;
    private Customer customer;

    public String getProductId(){
        return productId;
    }
    public void setProductId(String productId){
        this.productId = productId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public ProductCategory getProductCategory(){
        return productCategory;
    }
    public void setProductCategory(ProductCategory productCategory){
        this.productCategory = productCategory;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    Product(String productId, String name, double price, ProductCategory productCategory, Customer customer){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
        this.customer = customer;
    }
    @Override
    public String toString(){
        return "Specifications of this product: " + this.productId + " - " + this.name + " - " + this.price + " - " + this.productCategory + " - " + this.customer;
    }
}
