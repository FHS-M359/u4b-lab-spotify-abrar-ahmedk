public class Song {

    private String title;
    private String artist;
    private String album;
    private int duration;
    private int year;
    private String genre;

    public Song(String t, String art, String alb, int dur, int y, String gen) {
        title = t;
        artist = art;
        album = alb;
        duration = dur;
        year = y;
        genre = gen;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration(){return  duration; }

    public String toString() {
        return String.format("%-35s %-20s %-30s %-6d %-12s", title, artist, album, year, genre);
    }
}