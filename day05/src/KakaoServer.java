import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KakaoServer {
    public static void main(String[] args) {
// 서버 소켓
        ServerSocket serverSocket;

        Socket[] clients = new Socket[10];
        RelationThread[] relation;
        List<UserEntity> users = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(9876);
            relation = new RelationThread[10];
            for (int i = 0; i < 10; i++) {
                clients[i] = serverSocket.accept();
                relation[i] = new RelationThread(clients,users,i);
                users.add(relation[i].register());
                //중계 스레드 실행
                relation[i].start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
