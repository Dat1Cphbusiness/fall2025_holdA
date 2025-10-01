package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static  void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        File file = new File("data/players.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String result = scanner.nextLine();
                String[] tokens = result.split(",");
                String name = tokens[0];
                int score = Integer.parseInt(tokens[1]);
                Player p = new Player(name, score);
                players.add(p);
            }

            Player p = players.get(0);
            p.setScore(15);
            Player p2 = players.get(1);
            p2.setName("Hans");

            FileWriter filewriter = new FileWriter("data/players.txt");
            for(Player pl: players){
                filewriter.write(pl.getName() + "," + pl.getScore());
            }


        }
        catch (FileNotFoundException e) {
            System.out.println("Filen fandtes ikke");
        }
        catch (IOException e) {
            System.out.println("Kan ikke skrive til filen");
        }

    }

}
