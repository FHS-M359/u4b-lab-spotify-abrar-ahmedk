import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

// This class stores and manages a list of songs
public class Playlist {

    // ArrayList to store Song objects
    private ArrayList<Song> songs;

    // Constructor initializes the ArrayList
    public Playlist() {
        songs = new ArrayList<Song>();
    }

    // Method to read songs from a file
    public void readFile(String fileName) {

        try {
            // Open file using Scanner
            Scanner file = new Scanner(new File(fileName));

            // Read each line in the file
            while (file.hasNextLine()) {
                String line = file.nextLine();

                // Split the line by commas
                String[] parts = line.split(",");

                // Create a new Song object from file data
                Song s = new Song(parts[0], parts[1], parts[2],
                        Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]),
                        parts[5]);

                // Add song to ArrayList
                songs.add(s);
            }

            file.close();

        } catch (Exception e) {
            // If file cannot be read
            System.out.println("Error reading file");
        }
    }

    // Method to display all songs in the playlist
    public void displayAll() {
        System.out.println(String.format("%-35s %-20s %-30s %-6s %-12s", "Title", "Artist", "Album", "Year", "Genre"));
        System.out.println("---------------------------------------------------------------------------------------------------------");

        // Loop through each song and print it
        for (Song s : songs) {
            System.out.println(s);
        }
    }

    // Linear search to find songs by genre
    public void searchGenre(String genre) {

        boolean foundSong = false;

        System.out.println(String.format("%-35s %-20s %-30s %-6s %-12s", "Title", "Artist", "Album", "Year", "Genre"));
        System.out.println("---------------------------------------------------------------------------------------------------------");

        // Loop through songs and check genre
        for (Song s : songs) {
            if (s.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(s);
                foundSong = true;
            }
        }

        // If no songs match the genre
        if (!foundSong) {
            System.out.println("No songs found in that genre.");
        }
    }

    // Selection Sort by Artist (A-Z)
    public void sortArtistAZ() {

        for (int i = 0; i < songs.size() - 1; i++) {

            int min = i;

            for (int j = i + 1; j < songs.size(); j++) {

                // Compare artist names alphabetically
                if (songs.get(j).getArtist().compareToIgnoreCase(songs.get(min).getArtist()) < 0) {
                    min = j;
                }
            }

            // Swap songs
            Song temp = songs.get(i);
            songs.set(i, songs.get(min));
            songs.set(min, temp);
        }
    }

    // Sort artists Z-A by reversing A-Z sort
    public void sortArtistZA() {

        sortArtistAZ();   // first sort A-Z

        // reverse the list
        for (int i = 0; i < songs.size()/2; i++) {

            Song temp = songs.get(i);
            songs.set(i, songs.get(songs.size()-1 - i));
            songs.set(songs.size() - 1 - i, temp);
        }
    }

    // Insertion Sort by Year (Oldest to Newest)
    public void sortYearOldNew() {

        for(int i = 1; i < songs.size(); i++) {

            Song key = songs.get(i);
            int j = i - 1;

            // Move songs with greater year forward
            while(j >= 0 && songs.get(j).getYear() > key.getYear()) {

                songs.set(j + 1, songs.get(j));
                j--;
            }

            songs.set(j + 1, key);
        }
    }

    // Sort year Newest to Oldest by reversing Old-New
    public void sortYearNewOld() {

        sortYearOldNew();   // sort Old-New

        // reverse the list
        for (int i = 0; i < songs.size() / 2; i++) {

            Song temp = songs.get(i);
            songs.set(i, songs.get(songs.size() - 1 - i));
            songs.set(songs.size() - 1 - i, temp);
        }
    }
}