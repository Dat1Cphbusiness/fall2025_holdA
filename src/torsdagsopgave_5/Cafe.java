package torsdagsopgave_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {
    private ArrayList<String> coffeeMenu;
    public Cafe() {
        coffeeMenu = new ArrayList<>();
    }
    public ArrayList<String> getCoffeeMenu() {
        return coffeeMenu;
    }
    public void loadMenuData() {
        try {
            File file = new File("coffees.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                coffeeMenu.add(scan.nextLine());
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Check path and filename");
        }
    }
}
