import java.util.Scanner;

public class SpotifyTester {

    public static final int SORT_ARTIST_AZ = 1;
    public static final int SORT_ARTIST_ZA = 2;
    public static final int SEARCH_GENRE = 5;
    public static final int DISPLAY = 6;
    public static final int QUIT = 7;

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        playlist.readFile("C:\\AbrarCSA\\spotify_unique_years_artists.txt");

        Scanner keyboard = new Scanner(System.in);

        int choice = 0;


        while (choice != QUIT) {

            printMenu();

            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter a number between 1 and 7.");
                continue;
            }

            if (choice == SORT_ARTIST_AZ) {
                playlist.sortArtistAZ();
                System.out.println("Sorted by artist (A -> Z)");
                playlist.displayAll();
            }
            else if (choice == SORT_ARTIST_ZA) {
                playlist.sortArtistZA();
                System.out.println("Sorted by artist (Z -> A)");
                playlist.displayAll();
            }

            else if (choice == SEARCH_GENRE) {
                System.out.print("Enter genre: ");
                String genre = keyboard.nextLine();
                playlist.searchGenre(genre);
            }
            else if (choice == DISPLAY) {
                playlist.displayAll();
            }
            else if (choice == QUIT) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        keyboard.close();
    }

    public static void printMenu() {
        System.out.println("\n=== Spotify Menu ===");
        System.out.println("1- Sort by artist (A -> Z)");
        System.out.println("2- Sort by artist (Z -> A)");
       // System.out.println("3- Sort by year (oldest -newest)");
       // System.out.println("4- Sort by year (newest -oldest)");
        System.out.println("5- Search by genre");
        System.out.println("6- Display all songs");
        System.out.println("7- Quit");
        System.out.print("Enter choice: ");
    }
}