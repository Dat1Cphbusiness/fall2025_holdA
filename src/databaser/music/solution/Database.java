package databaser.music.solution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private String url;

    public Database(String url){
        this.url = url;
    }

    // Opgave 1: Find titlen på alle albums der blev udgivet i 1998
    public List<String> getAlbumsByYear(int year){
        List<String> albums = new ArrayList<>();
        String sql = "SELECT title FROM Albums WHERE releaseyear = " + year;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                String title = resultSet.getString("title");
                albums.add(title);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return albums;
    }

    // Opgave 2: Find alle oplysninger om brugeren med username 'jazzfan_anna'
    public User getUserByUsername(String username){
        User user = null;
        String sql = "SELECT * FROM Users WHERE username = '" + username + "'";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            if(resultSet.next()){
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("username");
                String membership = resultSet.getString("membership");
                String password = resultSet.getString("password");
                int member_since = resultSet.getInt("member_since");
                user = new User(id, name, password, membership, member_since);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return user;
    }

    // Opgave 3: Find song_id og title på alle sange der tilhører album med album_id 6
    public List<Song> getSongsByAlbumId(int albumId){
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT song_id, title FROM Songs WHERE album_id = " + albumId;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int songId = resultSet.getInt("song_id");
                String title = resultSet.getString("title");
                // Bruger null/0 for manglende data
                songs.add(new Song(songId, title, null, 0, null));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return songs;
    }

    // Opgave 4: Find name på alle playlists der tilhører bruger med user_id 2
    public List<String> getPlaylistsByUserId(int userId){
        List<String> playlists = new ArrayList<>();
        String sql = "SELECT name FROM Playlists WHERE user_id = " + userId;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                String name = resultSet.getString("name");
                playlists.add(name);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return playlists;
    }

    // Opgave 5: Find alle oplysninger om albummet med album_id 15
    public Album getAlbumById(int albumId){
        Album album = null;
        String sql = "SELECT * FROM Albums WHERE album_id = " + albumId;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            if(resultSet.next()){
                int id = resultSet.getInt("album_id");
                String title = resultSet.getString("title");
                int releaseYear = resultSet.getInt("releaseyear");
                album = new Album(id, title, releaseYear);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return album;
    }

    // Opgave 6: Find username på brugeren med user_id 4
    public String getUsernameById(int userId){
        String username = null;
        String sql = "SELECT username FROM Users WHERE user_id = " + userId;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            if(resultSet.next()){
                username = resultSet.getString("username");
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return username;
    }

    // Opgave 7: Vis alle albums sorteret efter releaseyear (ældste først)
    public List<Album> getAllAlbumsSortedByYear(){
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM Albums ORDER BY releaseyear ASC";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int id = resultSet.getInt("album_id");
                String title = resultSet.getString("title");
                int releaseYear = resultSet.getInt("releaseyear");
                albums.add(new Album(id, title, releaseYear));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return albums;
    }

    // Opgave 8: Vis alle brugere sorteret alfabetisk efter username
    public List<User> getAllUsersSortedByUsername(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users ORDER BY username ASC";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("username");
                String membership = resultSet.getString("membership");
                String password = resultSet.getString("password");
                int member_since = resultSet.getInt("member_since");
                users.add(new User(id, name, password, membership, member_since));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return users;
    }

    // Opgave 9: Vis alle albums sorteret efter releaseyear (nyeste først)
    public List<Album> getAllAlbumsSortedByYearDesc(){
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM Albums ORDER BY releaseyear DESC";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int id = resultSet.getInt("album_id");
                String title = resultSet.getString("title");
                int releaseYear = resultSet.getInt("releaseyear");
                albums.add(new Album(id, title, releaseYear));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return albums;
    }

    // Opgave 10: Find alle albums der blev udgivet i 1971 og har 'Blue' i titlen
    public List<Album> getAlbumsByYearAndTitle(int year, String titlePart){
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM Albums WHERE releaseyear = " + year + " AND title = '" + titlePart + "'";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int id = resultSet.getInt("album_id");
                String title = resultSet.getString("title");
                int releaseYear = resultSet.getInt("releaseyear");
                albums.add(new Album(id, title, releaseYear));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return albums;
    }

    // Opgave 11: Find alle sange der tilhører album_id 3 og har song_id større end 23
    public List<Song> getSongsByAlbumAndIdGreaterThan(int albumId, int minSongId){
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM Songs WHERE album_id = " + albumId + " AND song_id > " + minSongId;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int songId = resultSet.getInt("song_id");
                String title = resultSet.getString("title");
                songs.add(new Song(songId, title, null, 0, null));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return songs;
    }

    // Opgave 12: Find alle playlists der tilhører user_id 1 og har playlist_id mindre end 3
    public List<Playlist> getPlaylistsByUserAndIdLessThan(int userId, int maxPlaylistId){
        List<Playlist> playlists = new ArrayList<>();
        String sql = "SELECT * FROM Playlists WHERE user_id = " + userId + " AND playlist_id < " + maxPlaylistId;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int playlistId = resultSet.getInt("playlist_id");
                String name = resultSet.getString("name");
                playlists.add(new Playlist(playlistId, name));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return playlists;
    }

    // Opgave 13: Find alle albums der blev udgivet i enten 1984 eller 2015
    public List<Album> getAlbumsByTwoYears(int year1, int year2){
        List<Album> albums = new ArrayList<>();
        String sql = "SELECT * FROM Albums WHERE releaseyear = " + year1 + " OR releaseyear = " + year2;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int id = resultSet.getInt("album_id");
                String title = resultSet.getString("title");
                int releaseYear = resultSet.getInt("releaseyear");
                albums.add(new Album(id, title, releaseYear));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return albums;
    }

    // Opgave 14: Find alle brugere der hedder enten 'pop_princess' eller 'rocknroll_pete'
    public List<User> getUsersByTwoUsernames(String username1, String username2){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users WHERE username = '" + username1 + "' OR username = '" + username2 + "'";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("username");
                String membership = resultSet.getString("membership");
                String password = resultSet.getString("password");
                int member_since = resultSet.getInt("member_since");
                users.add(new User(id, name, password, membership, member_since));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
            System.out.println(e.getMessage());
        }
        return users;
    }

    // Opgave 15: Find alle sange der tilhører enten album_id 1 eller album_id 10
    public List<Song> getSongsByTwoAlbums(int albumId1, int albumId2){
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM Songs WHERE album_id = " + albumId1 + " OR album_id = " + albumId2;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                int songId = resultSet.getInt("song_id");
                String title = resultSet.getString("title");
                songs.add(new Song(songId, title, null, 0, null));
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return songs;
    }

    // Opgave 16: Tilføj en ny bruger med username 'indie_lover'
    public boolean insertUser(String username){
        String sql = "INSERT INTO Users (username) VALUES ('" + username + "')";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()){
            int rowsAffected = statement.executeUpdate(sql);
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Vi kan ikke indsætte i databasen");
            return false;
        }
    }

    // Opgave 17: Opdater albummet med album_id 5 så releaseyear bliver 1978
    public boolean updateAlbumYear(int albumId, int newYear){
        String sql = "UPDATE Albums SET releaseyear = " + newYear + " WHERE album_id = " + albumId;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()){
            int rowsAffected = statement.executeUpdate(sql);
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Vi kan ikke opdatere databasen");
            return false;
        }
    }

    // Opgave 18: Slet brugeren med user_id 5
    public boolean deleteUser(int userId){
        String sql = "DELETE FROM Users WHERE user_id = " + userId;
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()){
            int rowsAffected = statement.executeUpdate(sql);
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Vi kan ikke slette fra databasen");
            return false;
        }
    }

    // Opgave 19: Find alle sange med deres album titel (JOIN)
    public List<String> getSongsWithAlbumTitles(){
        List<String> results = new ArrayList<>();
        String sql = "SELECT Songs.title AS song_title, Albums.title AS album_title " +
                "FROM Songs JOIN Albums ON Songs.album_id = Albums.album_id";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                String songTitle = resultSet.getString("song_title");
                String albumTitle = resultSet.getString("album_title");
                results.add(songTitle + " - " + albumTitle);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return results;
    }

    // Opgave 20: Find alle playlists med brugernavnet på ejeren (JOIN)
    public List<String> getPlaylistsWithUsernames(){
        List<String> results = new ArrayList<>();
        String sql = "SELECT Playlists.name AS playlist_name, Users.username " +
                "FROM Playlists JOIN Users ON Playlists.user_id = Users.user_id";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                String playlistName = resultSet.getString("playlist_name");
                String username = resultSet.getString("username");
                results.add(playlistName + " - " + username);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return results;
    }

    // Opgave 21: Find alle sange i genre 'Rock' med sangens titel (JOIN)
    public List<String> getSongsByGenre(String genre){
        List<String> songs = new ArrayList<>();
        String sql = "SELECT Songs.title FROM Genres_Songs " +
                "JOIN Songs ON Genres_Songs.song_id = Songs.song_id " +
                "WHERE Genres_Songs.genre = '" + genre + "'";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                String title = resultSet.getString("title");
                songs.add(title);
            }
        } catch (SQLException e) {
            System.out.println("Vi kan ikke få fat i databasen");
        }
        return songs;
    }


}