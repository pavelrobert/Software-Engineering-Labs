package isp.lab3;

import isp.lab3.exercise5.VendingMachine;
import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class VendingMachineTest extends TestCase {

    public void testDisplayProducts() {
        String[] products = {"Pepsi", "Cola", "Fanta", "Mirinda", "Water"};
        int[] prices = {10,4,7,8,2};
        VendingMachine vMachine = new VendingMachine(products, prices);

        // output stream to capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        vMachine.displayProducts();

        String expectedOutput = "Available products: \n" +
                "Pepsi Id: 0 Price: 10\n" +
                "Cola Id: 1 Price: 4\n" +
                "Fanta Id: 2 Price: 7\n" +
                "Mirinda Id: 3 Price: 8\n" +
                "Water Id: 4 Price: 2\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    public void testInsertCoin() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.insertCoin(5);
        assertEquals(5, vendingMachine.getCredit());
        vendingMachine.insertCoin(10);
        assertEquals(15, vendingMachine.getCredit());
    }
    public void testSelectProduct() {
        String[] products = {"Pepsi", "Cola", "Fanta", "Mirinda", "Water"};
        int[] prices = {5,6,7,4,4};
        VendingMachine vendingMachine = new VendingMachine(products, prices);

        vendingMachine.insertCoin(10);
        assertEquals("You have purchased Cola.", vendingMachine.selectProduct(1));

        vendingMachine.insertCoin(1);
        assertEquals("Error. Insufficient credit", vendingMachine.selectProduct(2));

        assertEquals("Error. Product doesn't exist", vendingMachine.selectProduct(5));
    }
}
