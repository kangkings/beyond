import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class KakaoClient {
    public static void main(String[] args) {
        Socket clientSocket;
        Scanner sc = new Scanner(System.in);
        Thread readOnly;
        Thread writeOnly;

        String name;
        try {

            clientSocket = new Socket("192.168.0.59", 9876);
            readOnly = new ReadThread(clientSocket);
            writeOnly = new WriteThread(clientSocket);

            //쓰기 쓰레드 실행(클라이언트 소켓 넘겨주기)
            writeOnly.start();
            //읽기 쓰레드 실행(클라이언트 소켓 넘겨주기)
            readOnly.start();



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
