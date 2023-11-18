import java.io.*;
import java.net.*;

public class sockethttpclient {
    public static void main(String[] args) {
        String hostname = "www.google.com";
        int portNumber = 80;

        try {
            Socket socket = new Socket(hostname, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("GET / HTTP/1.1\nHost: " + hostname);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();
            out.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("Don't know " + hostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostname);
            System.exit(1);
        }
    }
}
