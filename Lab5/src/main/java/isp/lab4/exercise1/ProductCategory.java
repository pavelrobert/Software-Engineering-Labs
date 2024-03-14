package isp.lab4.exercise1;

/**
 * @author Radu Miron
 */
public enum ProductCategory {
    ELECTRONICS("Electronics & Gadgets", 70),
    FASHION("Fashion", 50),
    HOME_AND_GARDEN("Home and Garden", 30),
    BEAUTY("Beauty Products", 20),
    TOYS("Toys", 40);

    private String displayName;
    final private int noOfItems;

    ProductCategory(String displayName, int noOfItems) {
        this.displayName = displayName;
        this.noOfItems = noOfItems;
    }

    @Override
    public String toString() {
        return this.displayName + " - No. of items: " + this.noOfItems;
    }
}
