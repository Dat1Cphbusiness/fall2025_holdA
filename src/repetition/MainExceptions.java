package repetition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainExceptions {

    public static void main(String[] args) {

        // RuntimeExceptions
        Passenger p1 = null;
        // NullPointerException
        // p1.setName("Signe");
        int[] numbers = new int[4];
        // ArrayIndexOutOfBoundsException
        // int i = numbers[5];

        // Vi tjekker i koden. Vi koder os altså ud af RuntimeExceptions
        if(p1 != null){
            p1.setName("Sally");
        }

        // Checked Exception. Hvad vil du gøre, hvis det fejler?
        try {
            Scanner scan = new Scanner(new File("data/coffees.txt"));
            System.out.println("Vi fandt filen");
        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke");
        }


    }
}
