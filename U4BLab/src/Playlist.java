import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Playlist {

    private ArrayList<Song> songs;

    public Playlist() {
        songs = new ArrayList<Song>();
    }

    // Read file
    public void readFile(String fileName) {

        try {
            Scanner file = new Scanner(new File(fileName));

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] parts = line.split(",");

                Song s = new Song(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), parts[5]);

                songs.add(s);
            }

            file.close();

        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }

    // Display all songs
    public void displayAll() {
        System.out.println(String.format("%-35s %-20s %-30s %-6s %-12s", "Title", "Artist", "Album", "Year", "Genre"));
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (Song s : songs) {
            System.out.println(s);
        }
    }

    // Search by genre (Linear Search)
    public void searchGenre(String genre) {
        boolean foundSong = false;
        System.out.println(String.format("%-35s %-20s %-30s %-6s %-12s", "Title", "Artist", "Album", "Year", "Genre"));
        System.out.println("---------------------------------------------------------------------------------------------------------");

        for (Song s : songs) {
            if (s.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(s);
                foundSong = true;
            }
        }

        if (!foundSong) {
            System.out.println("No songs found in that genre.");
        }
    }

    // Selection Sort by Artist (A-Z)
    public void sortArtistAZ() {
        for (int i = 0; i < songs.size() - 1; i++) {
            int min = i;

            for (int j = i + 1; j < songs.size(); j++) {
                if (songs.get(j).getArtist().compareToIgnoreCase(songs.get(min).getArtist()) < 0) {
                    min = j;
                }
            }

            Song temp = songs.get(i);
            songs.set(i, songs.get(min));
            songs.set(min, temp);
        }
    }

    public void sortArtistZA() {
        sortArtistAZ();   //  sort A-Z

        // reverse
        for (int i = 0; i < songs.size()/2; i++) {
            Song temp = songs.get(i);
            songs.set(i, songs.get(songs.size()-1 - i));
            songs.set(songs.size() - 1 - i, temp);
        }
    }
    public void sortYearOldNew() {
        for(int i = 1; i < songs.size(); i++) {
            Song key = songs.get(i);
            int j = i - 1;


            while(j >= 0 && songs.get(j).getYear() > key.getYear()) {
                songs.set(j + 1, songs.get(j));
                j--;
            }
            songs.set(j + 1, key);
        }
    }
    public void sortYearNewOld() {
        sortYearOldNew();   // sort Old-New

        // reverse
        for (int i = 0; i < songs.size() / 2; i++) {
            Song temp = songs.get(i);
            songs.set(i, songs.get(songs.size() - 1 - i));
            songs.set(songs.size() - 1 - i, temp);
        }
    }
    }