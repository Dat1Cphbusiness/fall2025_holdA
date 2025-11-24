package databaser.music;

public class Main {

    private static final String URL = "jdbc:sqlite:data/music.sqlite";
    public static void main(String[] args) {

        Database database = new Database(URL);
        if(!database.connect()){
            System.out.println("Vi kan ikke få fat i databasen");
            return;
        }
        User user = database.getUserById(1);
        System.out.println(user);


    }

}
