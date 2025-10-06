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
        if(score >= 0)
            this.score = score;
        else throw new IllegalArgumentException("Score can not be negative");
    }
    public void addToScore(int points){
        score += points;
    }

    public String toString(){
        return "Navn: " + name + ", score: " + score;
    }
}
