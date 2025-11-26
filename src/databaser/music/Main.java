package databaser.music;

import java.util.ArrayList;

public class Main {

    private static final String URL = "jdbc:sqlite:data/music.sqlite";

    public static void main(String[] args) {

        Database database = new Database(URL);
        ArrayList<Album> albums = database.getAlbumsByYear(1971);
        for(Album a: albums){
            System.out.println(a);
        }

       /* User user = database.getUserById(1);
        System.out.println(user);*/



    }

}
