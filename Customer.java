/**
 * Represents a customer who places cafe orders and earns loyalty points.
 * @author Avenido, Jusmine; Babor, Anlie Jane
 * @version 1.0
 */
public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    /** Creates a customer with default details. */
    public Customer() { this("Guest", false); }
    /**
     * Creates a non-student customer with the given name.
     * @param name customer name
     */
    public Customer(String name) { this(name, false); }
    /**
     * Creates a customer with a name and student status.
     * @param name customer name
     * @param student whether the customer is a student
     */
    public Customer(String name, boolean student) {
        setName(name);
        this.student = student;
        loyaltyPoints = 0;
    }

    /** @param points number of points to add directly */
    public void addPoints(int points) {
        if (points > 0) loyaltyPoints += points;
    }
    /** @param amountSpent amount spent in pesos; earns one point per 50 pesos */
    public void addPoints(double amountSpent) {
        if (amountSpent > 0) loyaltyPoints += (int) (amountSpent / 50);
    }

    /** @return customer name */
    public String getName() { return name; }
    /** @param name new customer name */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else System.out.println("Error: customer name cannot be empty.");
    }
    /** @return true if customer is a student */
    public boolean isStudent() { return student; }
    /** @param student new student status */
    public void setStudent(boolean student) { this.student = student; }
    /** @return current loyalty points */
    public int getLoyaltyPoints() { return loyaltyPoints; }
    /** @param loyaltyPoints new points; negative values are rejected */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) this.loyaltyPoints = loyaltyPoints;
        else System.out.println("Error: loyalty points cannot be negative.");
    }
}
