import java.util.*;
import java.io.*;

// 以HashSet取代ArrayList
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

    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    public int hashCode(){
        return title.hashCode();
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

class Jukebox8 {
    ArrayList<Song> songList = new ArrayList<Song>();

    void go() {
        getSongs();
        System.out.println(songList);// 初始数据
        // 调用compareTo排序
        Collections.sort(songList);
        System.out.println(songList);

        // // 调用compare排序
        // ArtistCompare artistCompare = new ArtistCompare();
        // Collections.sort(songList, artistCompare);
        // System.out.println(songList);

        // 以HashSet取代ArrayList
        // HashSet<Song> songSet = new HashSet<Song>();
        // songSet.addAll(songList);
        // System.out.println(songSet);

        //Use TreeSet
        TreeSet<Song> songSet = new TreeSet<Song>();
        songSet.addAll(songList);
        System.out.println(songSet);
    }

    void getSongs() {
        String pathname = "Songlist_01.txt";
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
        new Jukebox8().go();
    }

    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }
}