import java.util.Scanner;

// Main class that runs the Spotify playlist program
public class SpotifyTester {

    // Constants for menu choices
    public static final int SORT_ARTIST_AZ = 1;
    public static final int SORT_ARTIST_ZA = 2;
    public static final int SORT_OLD_NEW = 3;
    public static final int SORT_NEW_OLD = 4;
    public static final int SEARCH_GENRE = 5;
    public static final int DISPLAY = 6;
    public static final int QUIT = 7;

    public static void main(String[] args) {

        // Create playlist object
        Playlist playlist = new Playlist();

        // Read songs from the file and add them to the playlist
        playlist.readFile("F:\\Abrar\\u4b-lab-spotify-abrar-ahmedk\\U4BLab\\spotify_unique_years_artists.txt");

        // Scanner to read user input from keyboard
        Scanner keyboard = new Scanner(System.in);

        int choice = 0;

        // Keep showing menu until user chooses QUIT
        while (choice != QUIT) {

            // Print the menu options
            printMenu();

            // Try to read the user input
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (Exception e) {
                // If input is not a number
                System.out.println("Invalid Input. Please enter a number between 1 and 7.");
            }

            // Sort artists A to Z
            if (choice == SORT_ARTIST_AZ) {
                playlist.sortArtistAZ();
                System.out.println("Sorted by artist (A -> Z)");
                playlist.displayAll();
            }

            // Sort artists Z to A
            else if (choice == SORT_ARTIST_ZA) {
                playlist.sortArtistZA();
                System.out.println("Sorted by artist (Z -> A)");
                playlist.displayAll();
            }

            // Search songs by genre
            else if (choice == SEARCH_GENRE) {
                System.out.print("Enter genre: ");
                String genre = keyboard.nextLine();
                playlist.searchGenre(genre);
            }

            // Sort songs by year (oldest to newest)
            else if (choice == SORT_OLD_NEW) {
                playlist.sortYearOldNew();
                System.out.println("3- Sort by year (oldest -newest)");
                playlist.displayAll();
            }

            // Sort songs by year (newest to oldest)
            else if (choice == SORT_NEW_OLD) {
                playlist.sortYearNewOld();
                System.out.println("4- Sort by year (newest -oldest)");
                playlist.displayAll();
            }

            // Display all songs
            else if (choice == DISPLAY) {
                playlist.displayAll();
            }

            // Exit the program
            else if (choice == QUIT) {
                System.out.println("Goodbye!");
            }

            // If the user enters an invalid menu number
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        // Close scanner to prevent memory leak
        keyboard.close();
    }

    // Method that prints the menu options
    public static void printMenu() {
        System.out.println("\n=== Spotify Menu ===");
        System.out.println("1- Sort by artist (A -> Z)");
        System.out.println("2- Sort by artist (Z -> A)");
        System.out.println("3- Sort by year (oldest -newest)");
        System.out.println("4- Sort by year (newest -oldest)");
        System.out.println("5- Search by genre");
        System.out.println("6- Display all songs");
        System.out.println("7- Quit");
        System.out.print("Enter choice: ");
    }
}
