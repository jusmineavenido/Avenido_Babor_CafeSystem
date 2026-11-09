/**
 * Runs the Campus Cafe Ordering System and demonstrates its OOP features.
 * @author Avenido, Jusmine; Babor, Anlie Jane
 * @version 1.0
 */
public class CafeApp {
    /** Starts the cafe ordering demonstration. @param args command-line arguments */
    public static void main(String[] args) {
        // Create customers using different overloaded constructors.
        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        // Create items using parameterized constructors.
        Beverage latte = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);
        Pastry cookie = new Pastry("Cookie", 30, "P-02", false);

        Order order1 = new Order("1001", ana);
        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(adobo);
        order1.addItem(cookie); // Demonstrates the three-item limit.
        order1.printReceipt();

        // Demonstrate a setter rejecting invalid data before accepting valid data.
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);
        hotChocolate.setSize("M");

        // Demonstrate the default Meal constructor and its setters.
        Meal tapa = new Meal();
        tapa.setName("Beef Tapa");
        tapa.setBasePrice(130);
        tapa.setItemCode("M-02");

        Order order2 = new Order("1002", ben);
        order2.addItem(hotChocolate);
        order2.addItem(tapa);
        order2.printReceipt(20);
    }
}
