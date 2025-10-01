package textui;

public class Player {

    private String name;
    private int score;

    public Player(String name){
        this.name = name;
        score = 0;
    }

    public void addToScore(int points){
        score += points;
    }

    public String toString(){
        return "Navn: " + name + ", score: " + score;
    }
}
