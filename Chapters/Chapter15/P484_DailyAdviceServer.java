import java.io.*;
import java.net.*;

class DailyAdviceServer {
    String[] adviceList = { "Take smaller bites", "go for the tight jeans, no they do not make you look at fat",
            "One word: inappropriate", "Just for today, be honest", "Tell your boss what your really think",
            "You might want to rethink that haircut" };

    void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while (true) {
                Socket sock = serverSocket.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.printIn(advice);
                writer.close();
                System.out.printIn(advice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}