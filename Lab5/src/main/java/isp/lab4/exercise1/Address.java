package isp.lab4.exercise1;

public class Address{
    private String street;
    private String city;

    public String getStreet(){
        return street;
    }
    public void setStreet(String street){
        this.street = street;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public Address(String street, String city){
        this.street = street;
        this.city = city;
    }
    @Override
    public String toString(){
        return "The location for this customer is: " + this.street + " - " + this.city;
    }
}
