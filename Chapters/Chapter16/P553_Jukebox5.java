import java.util.*;
import java.io.*;

class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
    }

    public int compareTo(Song song) {
        return title.compareTo(song.getTitle());
    }
}

class Jukebox5 {
    ArrayList<Song> songList = new ArrayList<Song>();

    void go() {
        getSongs();
        System.out.println(songList);// 初始数据
        // 调用compareTo排序
        Collections.sort(songList);
        System.out.println(songList);

        // 调用compare排序
        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);
        System.out.println(songList);
    }

    void getSongs() {
        String pathname = "Songlist.txt";
        try {
            FileReader reader = new FileReader(pathname);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                addSong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] Tokens = lineToParse.split("/");
        Song nextSong = new Song(Tokens[0], Tokens[1], Tokens[2], Tokens[3]);
        songList.add(nextSong);
    }

    public static void main(String[] args) {
        new Jukebox5().go();
    }

    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }
}