/**
 * Represents a baked item that may be warmed for an extra fee.
 * @author Avenido, Jusmine; Babor, Anlie Jane
 * @version 1.0
 */
public class Pastry extends MenuItem {
    private boolean warmed;

    /** Creates a pastry that is not warmed. */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Creates a pastry with the supplied details.
     * @param name pastry name
     * @param basePrice starting price
     * @param itemCode item code
     * @param warmed whether the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /** @return price including the warming fee when applicable */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add 10 pesos only when the pastry is warmed.
        if (warmed) price += 10;
        return price;
    }

    /** @return item description with warming status */
    @Override
    public String getDescription() {
        return super.getDescription() + (warmed ? " (Warmed)" : "");
    }

    /** @return true if the pastry is warmed */
    public boolean isWarmed() { return warmed; }
    /** @param warmed whether the pastry should be warmed */
    public void setWarmed(boolean warmed) { this.warmed = warmed; }
}
