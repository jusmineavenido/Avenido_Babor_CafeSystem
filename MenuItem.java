/**
 * Represents a general item sold in the campus cafe.
 * This abstract class is the parent of Beverage, Pastry, and Meal.
 * @author Avenido, Jusmine; Babor, Anlie Jane
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /** Creates an item with default values. */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Creates an item using the supplied details.
     * @param name item name
     * @param basePrice starting price
     * @param itemCode item identification code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /** Calculates the final price of the menu item. @return item price */
    public abstract double computePrice();

    /**
     * Returns the item's name and code.
     * @return item description
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /** @return item name */
    public String getName() { return name; }
    /** @param name new item name */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else System.out.println("Error: item name cannot be empty.");
    }
    /** @return starting price */
    public double getBasePrice() { return basePrice; }
    /** @param basePrice new starting price; negative values are rejected */
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) this.basePrice = basePrice;
        else System.out.println("Error: base price cannot be negative.");
    }
    /** @return item code */
    public String getItemCode() { return itemCode; }
    /** @param itemCode new item code */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) this.itemCode = itemCode;
        else System.out.println("Error: item code cannot be empty.");
    }
}
