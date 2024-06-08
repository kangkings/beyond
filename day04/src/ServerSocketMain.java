import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketMain {
    public static void main(String[] args) {
        //서버소켓
        ServerSocket serverSocket;
        //소켓의 입력 스트림
        //소켓의 아웃풋 스트림

        try {
            serverSocket = new ServerSocket(9999);
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
