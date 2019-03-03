import java.io.*;
import java.net.*;

class DailyAdviceClient {
    void go() {
        try {
            Socket socket = new Socket("127.0.0.1", 4242);
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader read = new BufferedReader(isr);

            String advice = read.readLine();
            System.out.println("Today you should: " + advice);
            isr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}