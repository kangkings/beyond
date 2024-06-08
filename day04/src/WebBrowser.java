import java.io.*;
import java.net.Socket;
import java.net.StandardProtocolFamily;

public class WebBrowser {
    public static void main(String[] args) {
        Socket clientSocket;
        PrintStream printStream;
        OutputStream outputStream;

        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String res = "";
        String total = "";
        try{
            //아웃풋 스트림으로

            clientSocket = new Socket("www.naver.com",80);
            outputStream = clientSocket.getOutputStream();
            printStream = new PrintStream(outputStream);

            printStream.println("GET / HTTP/1.1");
            printStream.println("HOST: www.naver.com");
            printStream.println("");

            inputStream = clientSocket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);


            while((res = bufferedReader.readLine()) != null){
                total += res+"\n";
                System.out.println();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            printStream.close();
            outputStream.close();
            clientSocket.close();

            //GET / HTTP/1.1
            //Host: www.naver.com

            //인풋스트림으로
            //데이터를 받아와서
            //화면에 출력
            System.out.println(total);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
