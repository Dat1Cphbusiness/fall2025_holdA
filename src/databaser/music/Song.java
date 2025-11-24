package databaser.music;

public class Song {
    private int id;
    private String title;
    private Album album;
    private int duration;
    private Genre genre;

    public Song(int id, String title, Album album, int duration, Genre genre) {
        this.id = id;
        this.title = title;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
    }

    public Song(String title, Album album, int duration, Genre genre) {
        this(0, title, album, duration, genre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
