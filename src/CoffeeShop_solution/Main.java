package CoffeeShop_solution;

import CoffeeShop_solution.beverages.Beverage;
import CoffeeShop_solution.beverages.Coffee;
import CoffeeShop_solution.beverages.Smoothie;
import CoffeeShop_solution.beverages.Tea;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Coffee c = new Coffee("Latte", 250, 0.05, true);
        Smoothie s = new Smoothie("Berry Blast", 400, 0.04, true);
        Tea t1 = new Tea("Earl Grey", 300, 0.03, true);   // refill
        Tea t2 = new Tea("Green Tea", 300, 0.03, false);  // ny kop

        c.printReceipt(); //polymorf, fordi printRecipt kalder calculatePrice()
        s.printReceipt();
        t1.printReceipt();
        t2.printReceipt();

        //Ekstraopgave: Udskriv omsætning
        // Samme data som ovenfor, men vi lader ArrayList håndtere objektreferencer
        ArrayList<Beverage> orders = new ArrayList<>();
        orders.add(new Coffee("Latte", 250, 0.05, true));
        orders.add(new Smoothie("Berry Blast", 400, 0.04, true));
        orders.add(new Tea("Earl Grey", 300, 0.03, true));   // refill
        orders.add(new Tea("Green Tea", 300, 0.03, false));  // ny kop
        double totalRevenue = 0;

        for (Beverage b : orders) {
            b.printReceipt();
            totalRevenue += b.calculatePrice();
        }

        System.out.println("------------------------------");
        System.out.println("Total revenue: " + totalRevenue + " DKK");
    }
}