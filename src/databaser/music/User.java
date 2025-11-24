package databaser.music;

import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private String membership;
    private int memberSince;
    private ArrayList<Playlist> playLists = new ArrayList<>();

    public User(int id, String username, String password, String membership, int memberSince) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.membership = membership;
        this.memberSince = memberSince;
    }

    public User(String username, String password, String membership, int memberSince) {
        this(0, username, password, membership, memberSince);
    }

    public void addPlayList(Playlist playlist){
        playLists.add(playlist);
    }

    public void removePlaylist(Playlist playlist){
        playLists.remove(playlist);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public int getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(int memberSince) {
        this.memberSince = memberSince;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", membership='" + membership + '\'' +
                ", memberSince=" + memberSince +
                ", playLists=" + playLists +
                '}';
    }
}
