/**
 * Connects a customer to a maximum of three menu items and calculates the bill.
 * @author Avenido, Jusmine; Babor, Anlie Jane
 * @version 1.0
 */
public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Creates an order for a customer.
     * @param orderId order identification number
     * @param customer customer who placed the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /**
     * Adds an item to the first available slot.
     * @param item menu item to add
     * @return true if added; otherwise false
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return false;
        } else if (itemCount >= 3) {
            System.out.println("Order is full. Cannot add " + item.getName() + " [" + item.getItemCode() + "].");
            return false;
        } else if (item1 == null) item1 = item;
        else if (item2 == null) item2 = item;
        else item3 = item;
        itemCount++;
        return true;
    }

    /** @return sum of the prices of all items in the order */
    public double computeSubtotal() {
        double subtotal = 0;
        if (item1 != null) subtotal += item1.computePrice();
        if (item2 != null) subtotal += item2.computePrice();
        if (item3 != null) subtotal += item3.computePrice();
        return subtotal;
    }

    /** @return total after the student discount, if applicable */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        // Students receive a 10 percent discount.
        if (customer != null && customer.isStudent()) return subtotal * 0.90;
        else return subtotal;
    }

    /**
     * Calculates the total after student discount and voucher deduction.
     * @param voucher voucher amount to subtract
     * @return final total, never below zero
     */
    public double computeTotal(double voucher) {
        double total = computeTotal() - Math.max(0, voucher);
        if (total < 0) return 0;
        else return total;
    }

    /** Prints the receipt and updates the customer's loyalty points. */
    public void printReceipt() {
        double subtotal = computeSubtotal();
        double total = computeTotal();
        double discount = subtotal - total;
        System.out.println("Order #" + orderId + " — " + customer.getName() + (customer.isStudent() ? " (Student)" : ""));
        printItem(item1);
        printItem(item2);
        printItem(item3);
        System.out.printf(" Subtotal: %.2f%n", subtotal);
        if (customer.isStudent()) System.out.printf(" Student discount (10%%): -%.2f%n", discount);
        System.out.printf(" TOTAL: %.2f%n", total);
        customer.addPoints(total);
        System.out.println(" Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println();
    }

    /** @param item item to print, if present */
    private void printItem(MenuItem item) {
        if (item != null) System.out.printf(" %s ............ %.2f%n", item.getDescription(), item.computePrice());
    }

    /** Prints a receipt using a voucher and updates loyalty points. */
    public void printReceipt(double voucher) {
        double subtotal = computeSubtotal();
        double discountedTotal = computeTotal();
        double total = computeTotal(voucher);
        double discount = subtotal - discountedTotal;
        System.out.println("Order #" + orderId + " — " + customer.getName() + (customer.isStudent() ? " (Student)" : ""));
        printItem(item1);
        printItem(item2);
        printItem(item3);
        System.out.printf(" Subtotal: %.2f%n", subtotal);
        if (customer.isStudent()) System.out.printf(" Student discount (10%%): -%.2f%n", discount);
        System.out.printf(" Voucher: -%.2f%n", Math.min(Math.max(voucher, 0), discountedTotal));
        System.out.printf(" TOTAL: %.2f%n", total);
        customer.addPoints(total);
        System.out.println(" Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println();
    }
}
