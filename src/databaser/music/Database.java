package databaser.music;

import java.sql.*;

public class Database {

    private String url;

    public Database(String url){
        this. url = url;
    }

    public Connection connect(){
        try {
            Connection connection = DriverManager.getConnection(url);
            return connection;
        } catch (SQLException e) {
            System.out.println("Fejl ved connection");
        }
        return null;
    }

    public User getUserById(int id){
        User user = null;
        String sql = "SELECT * FROM Users WHERE user_id = " + id;
        try (Connection connection = DriverManager.getConnection(url)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
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


}
