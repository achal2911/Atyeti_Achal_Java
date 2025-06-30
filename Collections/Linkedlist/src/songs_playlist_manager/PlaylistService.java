package songs_playlist_manager;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlaylistService {
    private final LinkedList<String> playlist = new LinkedList<>();
    private ListIterator<String> iterator = playlist.listIterator();
    private String currentSong = null;

    public void addSongAtStart(String song) {
        playlist.addFirst(song);
        resetIterator();
        System.out.println("Song added to Start: " + song);
    }

    public void addSongAtEnd(String song) {
        playlist.addLast(song);
        resetIterator();
        System.out.println("Song added to end: " + song);

    }

    public String playNextSong() {
        if (iterator.hasNext()) {
            currentSong = iterator.next();
        } else {
            currentSong = "End of playlist";
        }
        return currentSong;

    }

    public String playPreviousSong() {
        if (iterator.hasPrevious()) {
            currentSong = iterator.previous();
        } else {
            currentSong = "End of playlist";
        }
        return currentSong;
    }

    public void deleteCurrentSong() {
        if (currentSong != null && playlist.contains(currentSong)) {
            iterator.remove();
            System.out.println("Removed song: " + currentSong);
            currentSong = null;
        } else {
            System.out.println("No song to delete.");
        }

    }

    public void viewPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("Playlist:");
            playlist.forEach(song -> System.out.println("• " + song));
        }
    }

    private void resetIterator() {
        iterator = playlist.listIterator();
        currentSong = null;
    }

}
