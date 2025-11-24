package databaser.music.solution;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database("jdbc:sqlite:data/music.sqlite");

        System.out.println("=== OPGAVE 1: Albums fra 1998 ===");
        List<String> albums1998 = db.getAlbumsByYear(1998);
        albums1998.forEach(System.out::println);

        System.out.println("\n=== OPGAVE 2: Bruger med username 'jazzfan_anna' ===");
        User jazzFan = db.getUserByUsername("jazzfan_anna");
        System.out.println(jazzFan);

        System.out.println("\n=== OPGAVE 3: Sange fra album_id 6 ===");
        List<Song> songsAlbum6 = db.getSongsByAlbumId(6);
        songsAlbum6.forEach(s -> System.out.println(s.getId() + ": " + s.getTitle()));

        System.out.println("\n=== OPGAVE 4: Playlists for user_id 2 ===");
        List<String> playlistsUser2 = db.getPlaylistsByUserId(2);
        playlistsUser2.forEach(System.out::println);

        System.out.println("\n=== OPGAVE 5: Album med album_id 15 ===");
        Album album15 = db.getAlbumById(15);
        System.out.println(album15);

        System.out.println("\n=== OPGAVE 6: Username for user_id 4 ===");
        String username4 = db.getUsernameById(4);
        System.out.println(username4);

        System.out.println("\n=== OPGAVE 7: Alle albums sorteret efter år (ældste først) ===");
        List<Album> sortedAlbumsAsc = db.getAllAlbumsSortedByYear();
        sortedAlbumsAsc.forEach(a -> System.out.println(a.getReleaseYear() + ": " + a.getTitle()));

        System.out.println("\n=== OPGAVE 8: Alle brugere sorteret alfabetisk ===");
        List<User> sortedUsers = db.getAllUsersSortedByUsername();
        sortedUsers.forEach(u -> System.out.println(u.getUsername()));

        System.out.println("\n=== OPGAVE 9: Alle albums sorteret efter år (nyeste først) ===");
        List<Album> sortedAlbumsDesc = db.getAllAlbumsSortedByYearDesc();
        sortedAlbumsDesc.forEach(a -> System.out.println(a.getReleaseYear() + ": " + a.getTitle()));

        System.out.println("\n=== OPGAVE 10: Albums fra 1971 med 'Blue' i titlen ===");
        List<Album> albums1971Blue = db.getAlbumsByYearAndTitle(1971, "Blue");
        albums1971Blue.forEach(a -> System.out.println(a.getTitle()));

        System.out.println("\n=== OPGAVE 11: Sange fra album_id 3 med song_id > 23 ===");
        List<Song> songsAlbum3 = db.getSongsByAlbumAndIdGreaterThan(3, 23);
        songsAlbum3.forEach(s -> System.out.println(s.getId() + ": " + s.getTitle()));

        System.out.println("\n=== OPGAVE 12: Playlists for user_id 1 med playlist_id < 3 ===");
        List<Playlist> playlistsUser1 = db.getPlaylistsByUserAndIdLessThan(1, 3);
        playlistsUser1.forEach(p -> System.out.println(p.getId() + ": " + p.getName()));

        System.out.println("\n=== OPGAVE 13: Albums fra enten 1984 eller 2015 ===");
        List<Album> albums1984or2015 = db.getAlbumsByTwoYears(1984, 2015);
        albums1984or2015.forEach(a -> System.out.println(a.getReleaseYear() + ": " + a.getTitle()));

        System.out.println("\n=== OPGAVE 14: Brugere 'pop_princess' eller 'rocknroll_pete' ===");
        List<User> twoUsers = db.getUsersByTwoUsernames("pop_princess", "rocknroll_pete");
        twoUsers.forEach(u -> System.out.println(u.getUsername()));

        System.out.println("\n=== OPGAVE 15: Sange fra album_id 1 eller 10 ===");
        List<Song> songsTwoAlbums = db.getSongsByTwoAlbums(1, 10);
        songsTwoAlbums.forEach(s -> System.out.println(s.getTitle()));

        System.out.println("\n=== OPGAVE 16: Indsæt ny bruger 'indie_lover' ===");
        boolean inserted = db.insertUser("indie_lover");
        System.out.println("Bruger indsat: " + inserted);

        System.out.println("\n=== OPGAVE 17: Opdater album_id 5 til år 1978 ===");
        boolean updated = db.updateAlbumYear(5, 1978);
        System.out.println("Album opdateret: " + updated);
        // Verificer
        Album album5 = db.getAlbumById(5);
        System.out.println("Album 5 nu: " + album5.getTitle() + " (" + album5.getReleaseYear() + ")");

        System.out.println("\n=== OPGAVE 18: Slet bruger med user_id 5 ===");
        boolean deleted = db.deleteUser(5);
        System.out.println("Bruger slettet: " + deleted);

        System.out.println("\n=== OPGAVE 19: Sange med deres album titler (JOIN) ===");
        List<String> songsWithAlbums = db.getSongsWithAlbumTitles();
        songsWithAlbums.stream().limit(10).forEach(System.out::println);
        System.out.println("... (viser kun første 10)");

        System.out.println("\n=== OPGAVE 20: Playlists med brugernavne (JOIN) ===");
        List<String> playlistsWithUsers = db.getPlaylistsWithUsernames();
        playlistsWithUsers.forEach(System.out::println);

        System.out.println("\n=== OPGAVE 21: Sange i genre 'Rock' (JOIN) ===");
        List<String> rockSongs = db.getSongsByGenre("Rock");
        rockSongs.stream().limit(10).forEach(System.out::println);
        System.out.println("... (viser kun første 10)");

        System.out.println("\n=== ALLE TESTS GENNEMFØRT ===");
    }
}