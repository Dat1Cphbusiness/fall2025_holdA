package databaser.music;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private String url;
    public Database(String url){
        this. url = url;
    }

    public ArrayList<Album> getAlbuAlbums_PlaylistsmsByYear(int year){
        ArrayList<Album> albums = new ArrayList<>();
        String sql = "SELECT album_id, title FROM Albums WHERE releaseyear = " + year;
        try(Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while(resultSet.next()){
                int id = resultSet.getInt("album_id");
                String title = resultSet.getString("title");
                albums.add(new Album(id,title,year));
            }
        }
        catch(SQLException e){
            System.out.println("Fejl i adgang til database");
            System.out.println(e.getMessage());
        }
        return albums;
    }


   public User getUserById(int id){
        User user = null;
        String sql = "SELECT * FROM Users WHERE user_id = " + id;
        try (Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            if(resultSet.next()){
                String name = resultSet.getString("username");
                String membership = resultSet.getString("membership");
                String password = resultSet.getString("password");
                int member_since = resultSet.getInt("member_since");
                user = new User(id, name, password, membership, member_since);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
            System.out.println(e.getMessage());
        }
        return user;
    }


}
