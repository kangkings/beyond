import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReadThread extends Thread{
    private Socket clientSocket;
    private InputStream inputStream;
    private InputStreamReader reader;
    private BufferedReader br;

    public ReadThread(Socket clientSocket) throws Exception {
        this.clientSocket = clientSocket;
        this.inputStream = clientSocket.getInputStream();
        this.reader = new InputStreamReader(this.inputStream,"UTF-8");
        this.br = new BufferedReader(reader);
    }

    public void run(){
        while (true){
            String result = "";
            try {
                result += br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("\n"+result);
        }
    }
}
