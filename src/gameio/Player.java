package gameio;

public class Player {

    private String name;
    private int score;

    public Player(String name){
        this.name = name;
        score = 0;
    }

    public Player (String name, int score){
        this.name = name;
        this.score = score;
    }
    public void addToScore(int points){
        score += points;
    }

    public String toString(){
        return "Navn: " + name + ", score: " + score;
    }
}
