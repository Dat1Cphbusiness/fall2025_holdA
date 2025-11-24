package CoffeeShop_solution.beverages;

// Subklasse 1
public class Coffee extends Beverage {
    private boolean hasMilk;


    public Coffee(String name, int sizeMl, double pricePerMl, boolean hasMilk) {
        super(name, sizeMl, pricePerMl);
        this.hasMilk = hasMilk;
    }


    @Override
    public double calculatePrice() {
        double price = sizeMl * pricePerMl;
        if (hasMilk) price += 5; // mælk koster ekstra
        return price;
    }
}

