import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 5107;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server Started on PORT: " + PORT);
        while (true){
            Socket socket = serverSocket.accept();
            Thread serverTh = new ServerThread(socket);
            serverTh.start();
        }
    }
}
