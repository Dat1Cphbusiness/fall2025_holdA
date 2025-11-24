package CoffeeShop_solution.beverages;

public class Tea extends Beverage {
    private boolean isRefill;

    public Tea(String name, int sizeMl, double pricePerMl, boolean isRefill) {
        super(name, sizeMl, pricePerMl);
        this.isRefill = isRefill;
    }

    public double calculatePrice() {
        double price = sizeMl * pricePerMl;
        if (isRefill) {
            price *= 0.8; // 20% rabat
        }
        return price;
    }
}