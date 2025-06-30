package songs_playlist_manager;

import java.util.Scanner;

public class PlaylistManager {
    public static void main(String[] args) {
        PlaylistService service = new PlaylistService();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        System.out.println("Welcome to LinkedList Playlist Manager");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add song to end");
            System.out.println("2. Add song to start");
            System.out.println("3. Play next song");
            System.out.println("4. Play previous song");
            System.out.println("5. Delete current song");
            System.out.println("6. View full playlist");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter song name: ");
                    String song = scanner.nextLine();
                    service.addSongAtEnd(song);
                }
                case 2 -> {
                    System.out.print("Enter song name: ");
                    String song = scanner.nextLine();
                    service.addSongAtStart(song);
                }
                case 3 -> System.out.println("Now playing: " + service.playNextSong());
                case 4 -> System.out.println("Now playing: " + service.playPreviousSong());
                case 5 -> service.deleteCurrentSong();
                case 6 -> service.viewPlaylist();
                case 7 -> {
                    running = false;
                    System.out.println("Exiting Playlist Manager.");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
