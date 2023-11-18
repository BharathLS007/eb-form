import java.io.*;
import java.net.*;
public class EchoServer {
    private ServerSocket server;
    public EchoServer(int portNumber) {
        try {
            server = new ServerSocket(portNumber);
        } catch (Exception err) {
            System.out.println(err);
        }
    }
    public void startServer() {
        try {
            while (true) {
                Socket client = server.accept();
                BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter w = new PrintWriter(client.getOutputStream(), true);
                w.println("Welcome to echo server type bye to close");
                String line;
                do {
                    line = r.readLine();
                    if (line != null) {
                        w.println("GOT " + line);
                        System.out.println(line);
                    }
                } while (!line.trim().equals("bye"));
                client.close();
            }
        } catch (Exception err) {
            System.out.println(err);
        }
    }
    public static void main(String[] args) {
        EchoServer s = new EchoServer(9999);
        s.startServer();
    }
}
