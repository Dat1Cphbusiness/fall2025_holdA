package repetition;

import java.awt.*;

public class MainTravel {

    public static void main(String[] args) {
        // objekter af klassen Passenger
        Passenger p1 = new Passenger("Signe", 1234, 51);
        Passenger p2 = new Passenger("Laura", 3456, 25);
        Passenger p3 = new Passenger("Marie", 4567, 72);
        Passenger p4 = new Passenger("Sally", 9);

        // prøver at ændre objektet p1's name, men det er private
        // p1.name = "Kurt";

        // Vi kalder en metode PÅ et objekt - her p1. Det er ikke ligegyldigt hvem
        // der ændrer navn.
        System.out.println(p1.getName());
        p1.setName("Kurt");
        System.out.println(p1.getName());

        // Java kode vs. Processing kode. New er ikke altid nødvendigt i Processing
        // Rectangle rect = new Rectangle();
        // rect(29, 48, 45,45);



    }
}
