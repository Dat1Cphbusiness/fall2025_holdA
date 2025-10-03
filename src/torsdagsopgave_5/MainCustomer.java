package torsdagsopgave_5;

import java.util.ArrayList;

public class MainCustomer {

    public static void main(String[] args) {
        Customer c = new Customer("Signe", "Kongsgaard", "kong");
        c.setFirstname("");
      //  System.out.println(c);
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(c);
        customers.add(new Customer("Sally", "Jensen", "sal"));
        customers.add(new Customer("Marley", "Jensen", "maly"));

        printCustomers(customers);
        c.setFirstname("Tine");

        printCustomers(customers);

        int count = Customer.getCounter();
        String name = c.getFirstname();

    }


    public static void printCustomers(ArrayList<Customer> customers){
        for(Customer cs: customers){
            System.out.println(cs);
        }
    }
}
