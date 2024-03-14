package isp.lab3.exercise5;
import java.util.Scanner;
import java.util.Scanner;

public class VendingMachine {
    String[] products;
    int[] prices;
    int credit = 0;

    public VendingMachine() {
    }

    public int getCredit(){
        return credit;
    }

    public VendingMachine(String[] products, int[] prices){
        this.products = products;
        this.prices = prices;
    }

    public void displayProducts(){
        System.out.print("Available products: \n");
        for(int i=0; i<products.length; i++){
            System.out.print(products[i]+" Id: "+i + " Price: "+prices[i]);
            System.out.print("\n");
        }
    }

    public void insertCoin(int value){
        credit += value;
    }

    public String selectProduct(int id){
        if(id >= products.length) return "Error. Product doesn't exist";
        if (credit < prices[id]) return "Error. Insufficient credit";
        credit -= prices[id];
        return "You have purchased " + products[id] + ".";
    }

    public void displayCredit(){
        System.out.println("Current available credit: " + credit);
    }

    public void userMenu(){
        System.out.println("*******************************");
        System.out.println("MENU OF THE VENDING MACHINE: ");
        System.out.println("Choose your option: ");
        System.out.println("1: Display products");
        System.out.println("2: Insert coins");
        System.out.println("3: Select product");
        System.out.println("4: Display current credit");
        System.out.println("5: Exit");
        System.out.println("******************************");
    }

    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void setPrice(int id, int price){
        prices[id] = price;
    }

    public static void main(String[] args){
        String[] products = {"Pepsi", "Cola", "Fanta", "Mirinda", "Water"};
        int[] prices = {5,6,7,4,4};
        VendingMachine vMachine = new VendingMachine(products,prices);
        int option;
        do {
            System.out.println();
            vMachine.userMenu();
            System.out.print("Your option: ");
            option = vMachine.readInt();
            System.out.println();
            switch (option) {
                case 1:
                    vMachine.displayProducts();
                    break;
                case 2:
                    System.out.println("Enter nr. of coins: ");
                    int coinsNr = vMachine.readInt();
                    vMachine.insertCoin(coinsNr);
                    break;
                case 3:
                    System.out.println("Enter id: ");
                    int id = vMachine.readInt();
                    System.out.println(vMachine.selectProduct(id));
                    break;
                case 4:
                    vMachine.displayCredit();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Incorrect option!");
                    break;
            }
        }while (option != 5);
    }
}

