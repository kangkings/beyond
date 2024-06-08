import java.io.*;
import java.net.Socket;
import java.util.List;

public class RelationThread extends Thread{
    private Socket client;
    private Socket[] clients;
    private Integer index;
    private InputStream inputStream;
    private InputStreamReader reader;
    private BufferedReader br;

    private OutputStream outputStream;
    private PrintStream printStream;

    private List<UserEntity> users;

    public RelationThread(Socket[] clients, List<UserEntity> users,Integer index) throws Exception {
        this.client = clients[index];
        this.clients = clients;
        this.index = index;
        this.inputStream = client.getInputStream();
        this.reader = new InputStreamReader(inputStream);
        this.br = new BufferedReader(reader);
        this.users = users;


    }

    public UserEntity register(){
        String res;
        UserEntity u1 = new UserEntity();
        try {
            if((res = br.readLine()) != null){
                u1.setUserName(res);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return u1;
    }

    public void run(){
        while (true){
            try {
                String res;
                if((res = br.readLine()) != null){
                    if (res.split("/")[0].equals("showList")){
                        outputStream = client.getOutputStream();
                        printStream = new PrintStream(outputStream);
                        printStream.println("현재 접속중인 사용자");
                        for (int i = 0; i < users.size(); i++) {

                            printStream.println(users.get(i).getUserName());
                        }
                        printStream.println("\n친구를 선택 해주세요: ");
                    }else if (res.split("/")[0].equals("to")){
                        for (int i = 0; i < users.size(); i++) {
                            if (users.get(i).getUserName().equals(res.split("/")[1])){
                                outputStream = clients[i].getOutputStream();
                                printStream = new PrintStream(outputStream);
                                printStream.println(users.get(index).getUserName()+"님이 보냄: "+res.split("/")[2]);
                            }
                        }


                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
