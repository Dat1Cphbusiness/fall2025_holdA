package gameio;

public class Main {
    static TextUI ui = new TextUI();
    public static void main(String[] args) {
        ui.displayMessage("Welcome to the game");
        String input = ui.promptText("New game (n) or load game (l)?");
        if(input.equals("n")){
            newGame();
        }
        else{
            loadGame();
        }
    }

    public static void loadGame(){
        String input = ui.promptText("What is the name of your game?");
        Game game = new Game();
        game.loadGame(input);
    }

    public static void newGame(){
        int noOfPlayers = ui.promptNumeric("How many players are you?");
        Game game = new Game("Yatzy", noOfPlayers);
        for(int i = 0; i < noOfPlayers; i++){
            game.registerPlayer();
        }
        game.displayPlayers();
    }
}
