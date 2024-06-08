import javax.print.StreamPrintService;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread{


    private Socket clientSocket;
    private OutputStream outputStream;
    private PrintStream printStream;

    public WriteThread(Socket clientSocket) throws Exception {

        this.clientSocket = clientSocket;
        this.outputStream = clientSocket.getOutputStream();
        this.printStream = new PrintStream(outputStream);
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        Integer cnt = 0;
        String name;
        String choice;
        String menu ="\n1.친구목록 보기\n2.종료\n초기메뉴로 돌아가려면 '돌아가기'를 입력하세요";
        String query;
        while (true){
            query = "";
            if (cnt == 0){
                System.out.print("사용할 이름을 입력하세요: ");
                name = sc. nextLine();
                printStream.println(name);
                cnt++;
                continue;
            }
            System.out.println(menu);
            System.out.print("메뉴를 선택 해주세요:");
            choice = sc.nextLine();
            if(choice.equals("1")){
                query+= "to";
                printStream.println("showList");

                choice = sc.nextLine();
                query+= "/"+choice;

                if(choice.equals("돌아가기")) {
                    continue;
                }
                System.out.println(choice +"님과의 대화방에 입장하셨습니다.\n나가시려면 'exit'을 입력하세요 :)");
                do{
                    String chat = query;
                    System.out.print("메시지 입력: ");
                    choice = sc.nextLine();
                    chat+= "/"+choice;
                    printStream.println(chat);
                }while(!choice.equals("exit"));


            } else if(choice.equals("돌아가기")) {
                continue;
            }else {
                break;

            }


        }
        return;
    }
}
