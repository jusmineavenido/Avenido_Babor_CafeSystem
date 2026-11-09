/**
 * Represents a rice meal that can be upsized and served with extra sides.
 * @author Avenido, Jusmine; Babor, Anlie Jane
 * @version 1.0
 */
public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    /** Creates a regular meal with no extra sides. */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Creates a meal with the supplied details.
     * @param name meal name
     * @param basePrice starting price
     * @param itemCode item code
     * @param upsized whether the meal is upsized
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /** @return price including upsize and extra-side charges */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Upsizing adds 20 pesos.
        if (upsized) price += 20;
        return price + (12 * extraSides);
    }

    /** @return item description including upsize status and extra sides */
    @Override
    public String getDescription() {
        return super.getDescription() + (upsized ? " Upsized" : " Regular") + ", " + extraSides + (extraSides == 1 ? " side" : " sides");
    }

    /** @return true if the meal is upsized */
    public boolean isUpsized() { return upsized; }
    /** @param upsized whether the meal is upsized */
    public void setUpsized(boolean upsized) { this.upsized = upsized; }
    /** @return number of extra sides */
    public int getExtraSides() { return extraSides; }
    /** @param extraSides new number of extra sides; negative values are rejected */
    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) this.extraSides = extraSides;
        else System.out.println("Error: extra sides cannot be negative.");
    }
}
