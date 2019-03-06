import java.util.*;
import java.io.*;

class Jukebox1 {
    ArrayList<String> songList = new ArrayList<String>();

    void go() {
        getSongs();
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
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }

    public static void main(String[] args) {
        new Jukebox1().go();
    }
}