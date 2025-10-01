package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("data/players.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen fandtes ikke");
        }

    }

}
