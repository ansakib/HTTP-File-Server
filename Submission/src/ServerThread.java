import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    private InputStream ins;
    private BufferedReader br;
    private OutputStream outs;
    private PrintWriter logWriter;
    ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        ins = socket.getInputStream();
        br = new BufferedReader(new InputStreamReader(ins));
        outs = socket.getOutputStream();
        logWriter = new PrintWriter(new FileWriter("log.txt"));
    }

    public void run(){
        try {
            String request = br.readLine();
            System.out.println(request);
            if(request == null || request.length()<=0) return;
            logWriter.write(request);
            logWriter.write('\n');

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
