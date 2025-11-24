package databaser.music;

public class Main {

    private static final String URL = "jdbc:sqlite:data/music.sqlite";

    public static void main(String[] args) {

        Database database = new Database(URL);
        User user = database.getUserById(1);
        System.out.println(user);

    }

}
