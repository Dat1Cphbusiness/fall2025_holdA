package textui;

import java.util.ArrayList;

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
