package gameio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private String name;
    private int noOfPlayers;
    private ArrayList<Player> players;
    TextUI ui;

    public Game(String name, int noOfPlayers){
        this.name = name;
        this.noOfPlayers = noOfPlayers;
        players = new ArrayList();
        ui = new TextUI();
    }

    public Game(){
        players = new ArrayList<>();
        ui = new TextUI();
    }

    public void loadGame2(String name) throws FileNotFoundException{
        File file = new File(name + ".txt");
        Scanner scanner = null;
        scanner = new Scanner(file);
        while(scanner.hasNext()) {
            String result = scanner.nextLine();
            String[] tokens = result.split(",");
            String playername = tokens[0];
            int score = Integer.parseInt(tokens[1]);
            Player p = new Player(playername, score);
            players.add(p);
        }
    }


    public void loadGame(String name){
        File file = new File("data/" + name + ".txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while(scanner.hasNext()) {
                String result = scanner.nextLine();
                String[] tokens = result.split(",");
                String playername = tokens[0];
                int score = Integer.parseInt(tokens[1]);
                Player p = new Player(playername, score);
                players.add(p);
            }
        } catch(NumberFormatException e){
            ui.displayMessage("data i filen er i forkert format");
        }
        catch (FileNotFoundException e) {
           String input = ui.promptText("Spillet findes ikke. Prøv igen");
            loadGame(input);

        }



    }

    public void registerPlayer(){
        if(players.size() >= noOfPlayers) {
            ui.displayMessage("No more room for players");
        }
        else {
            String userName = ui.promptText("Please enter your name");
            createPlayer(userName);
        }
    }

    private void createPlayer(String userName){
        Player player = new Player(userName);
        players.add(player);
    }

    public void displayPlayers(){
        ui.displayMessage("Players:");
        for(Player p:players){
            String s = p.toString();
            ui.displayMessage(s);
            // ui.displayMessage(p.toString());
        }
    }

}
