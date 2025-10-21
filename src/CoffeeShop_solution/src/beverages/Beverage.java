package beverages;

// Abstrakt superklasse
public abstract class Beverage {
    protected String name;
    protected int sizeMl;
    protected double pricePerMl;

    public Beverage(String name, int sizeMl, double pricePerMl) {
        this.name = name;
        this.sizeMl = sizeMl;
        this.pricePerMl = pricePerMl;
    }

    public void printReceipt() {
        System.out.println("Drink: " + name);
        System.out.println("Size: " + sizeMl + " ml");
        System.out.println("Total: " + calculatePrice() + " DKK\n"); // We use implemented method
    }

    // polymorf metode
    public abstract double calculatePrice();
}