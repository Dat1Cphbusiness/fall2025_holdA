package beverages;

// Subklasse 2
public class Smoothie extends Beverage {
    private boolean hasProtein;


    public Smoothie(String name, int sizeMl, double pricePerMl, boolean hasProtein) {
        super(name, sizeMl, pricePerMl);
        this.hasProtein = hasProtein;
    }

    @Override
    public double calculatePrice() {
        double price = sizeMl * pricePerMl;
        if (hasProtein) price += 10;
        return price;
    }
}
