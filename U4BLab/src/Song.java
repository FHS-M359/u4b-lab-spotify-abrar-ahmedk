// This class represents a single Song object
public class Song {

    // Instance variables for song information
    private String title;
    private String artist;
    private String album;
    private int duration;
    private int year;
    private String genre;

    // Constructor to initialize a song object
    public Song(String t, String art, String alb, int dur, int y, String gen) {
        title = t;
        artist = art;
        album = alb;
        duration = dur;
        year = y;
        genre = gen;
    }

    // Getter method to return artist name
    public String getArtist() {
        return artist;
    }

    // Getter method to return year
    public int getYear() {
        return year;
    }

    // Getter method to return genre
    public String getGenre() {
        return genre;
    }

    // toString method formats the song information when printed
    public String toString() {
        return String.format("%-35s %-20s %-30s %-6d %-12s", title, artist, album, year, genre);
    }
}