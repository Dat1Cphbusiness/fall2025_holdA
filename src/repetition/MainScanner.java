package repetition;

import java.io.File;
import java.util.Scanner;

public class MainScanner {

    public static void main(String[] args) {
        // Scanner der læser fra konsol
        Scanner scanFromConsole = new Scanner(System.in);
        // Scanner der læser fra fil
        //Scanner scanFromFile = new Scanner(new File("data/coffees.txt"));


        //Her bruger vi en af Scanners metoder
        String input = scanFromConsole.nextLine();
    }
}
