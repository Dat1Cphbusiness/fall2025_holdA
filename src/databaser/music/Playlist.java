package databaser.music;

import java.util.ArrayList;

public class Playlist {
    private int id;
    private String name;
    private ArrayList<Song> songs = new ArrayList<>();

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Playlist(String name) {
        this(0, name);
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public void removeSong(Song song){
        songs.remove(song);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
