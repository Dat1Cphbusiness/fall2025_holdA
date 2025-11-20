-- Opgave 1: Find titlen på alle albums der blev udgivet i 1998
SELECT title FROM Albums WHERE releaseyear = 1998;

-- Opgave 2: Find alle oplysninger om brugeren med username 'jazzfan_anna'
SELECT * FROM Users WHERE username = 'jazzfan_anna';

-- Opgave 3: Find song_id og title på alle sange der tilhører album med album_id 6
SELECT song_id, title FROM Songs WHERE album_id = 6;

-- Opgave 4: Find name på alle playlists der tilhører bruger med user_id 2
SELECT name FROM Playlists WHERE user_id = 2;

-- Opgave 5: Find titlerne på alle albums
SELECT title FROM Albums;

-- Opgave 6: Find username på brugeren med user_id 4
SELECT username FROM Users WHERE user_id = 4;

-- Opgave 7: Vis alle albums sorteret efter releaseyear (ældste først)
SELECT * FROM Albums ORDER BY releaseyear ASC;

-- Opgave 8: Vis alle brugere sorteret alfabetisk efter username
SELECT * FROM Users ORDER BY username ASC;

-- Opgave 9: Vis titel og længde på alle sange fra album med album_id 3 sorteret efter title
SELECT title, duration FROM Songs WHERE album_id = 3 ORDER BY title;

-- Opgave 10: Find alle albums der blev udgivet i 1971 og hvor titlen starter med 'B'
SELECT * FROM Albums WHERE releaseyear = 1971 AND title LIKE 'B%';

-- Opgave 11: Find alle sange der tilhører album_id 5 og varer kortere end 200 sekunder
SELECT * FROM Songs WHERE album_id = 5 AND duration < 200;

-- Opgave 12: Find brugernavn på alle brugere som har PREMIUM medlemsskab og som blev medlem efter 2021
SELECT username FROM Users WHERE membership = 'PREMIUM' AND member_since > 2021;

-- Opgave 13: Find alle albums der blev udgivet i enten 1984 eller 2015
SELECT * FROM Albums WHERE releaseyear = 1984 OR releaseyear = 2015;

-- Opgave 14: Find brugernavn på alle brugere der har BASIC eller PREMIUM medlemsskab
SELECT username FROM Users WHERE membership = 'BASIC' OR membership = 'PREMIUM';

-- Opgave 15: Find titel og album_id på alle sange der tilhører enten album_id 1 eller album_id 10
SELECT * FROM Songs WHERE album_id = 1 OR album_id = 10;

-- Opgave 16: Tilføj en ny bruger med username 'indie_lover', med BASIC medlemskab. Brugeren er medlem siden 2025.
-- Find selv på et password.
INSERT INTO Users (username, membership, member_since, password) VALUES ('indie_lover', 'BASIC', 2025, 'rememberthis');

-- Opgave 17: Opdater brugeren blues_bobby's password til 'bellbottom'
UPDATE Users SET password = 'bellbottom' WHERE username = 'blues_bobby';

-- Opgave 18: Slet brugeren med user_id 5
DELETE FROM Users WHERE user_id = 5;

-- Opgave 19: Find alle sange med deres album titel (brug JOIN mellem Songs og Albums)
SELECT Songs.title AS song_title, Albums.title AS album_title
FROM Songs
         JOIN Albums ON Songs.album_id = Albums.album_id;

-- Opgave 20: Find alle playlists med brugernavnet på ejeren (brug JOIN mellem Playlists og Users)
SELECT Playlists.name AS playlist_name, Users.username
FROM Playlists
         JOIN Users ON Playlists.user_id = Users.user_id;

-- Opgave 21: Find alle sange i genre 'Rock' med sangens titel (brug JOIN mellem Genres_Songs og Songs)
SELECT Songs.title, Genres_Songs.genre
FROM Genres_Songs
         JOIN Songs ON Genres_Songs.song_id = Songs.song_id
WHERE Genres_Songs.genre = 'Rock';