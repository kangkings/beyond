import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.StandardProtocolFamily;

public class WebServer {
    public static void main(String[] args) {
        //서버소켓
        ServerSocket serverSocket;
        //소켓의 입력 스트림
        //소켓의 아웃풋 스트림

        InputStream is;
        InputStreamReader isr;
        BufferedReader br;

        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader br2;


        try {
            serverSocket = new ServerSocket(80);
            Socket clientSocket = serverSocket.accept();
            is = clientSocket.getInputStream();
            isr = new InputStreamReader(is,"UTF-8");
            br = new BufferedReader(isr);
            OutputStream outputStream;
            PrintStream printStream;

            String result;
            result = br.readLine();

            String res = "";
            String total = "";

            if (result.split(" ")[1].equals("/test.html")){
                fileInputStream = new FileInputStream("/Users/kangking/80test/test.html");
                inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
                br2 = new BufferedReader(inputStreamReader);

                while((res = br2.readLine()) != null){
                    total += res;
                }

            }else if(result.split(" ")[1].equals("/abc.html")){

                fileInputStream = new FileInputStream("/Users/kangking/80test/abc.html");
                inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
                br2 = new BufferedReader(inputStreamReader);

                while((res = br2.readLine()) != null){
                    total += res;
                }
            }

            System.out.println(total);

            outputStream = clientSocket.getOutputStream();
            printStream = new PrintStream(outputStream);

            printStream.println("HTTP/1.1 200 OK");
            printStream.println("Content-Length: ");
            printStream.println("Content-Type: text/html");
            printStream.println("");
            printStream.println(total);
            printStream.println("");


        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}
