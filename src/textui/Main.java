package textui;

public class Main {

    public static void main(String[] args) {
        TextUI ui = new TextUI();
        ui.displayMessage("Welcome to the game");
        int noOfPlayers = ui.promptNumeric("How many players are you?");
        Game game = new Game("Yatzy", noOfPlayers);
        for(int i = 0; i < noOfPlayers; i++){
            game.registerPlayer();
        }
        game.displayPlayers();

    }
}
