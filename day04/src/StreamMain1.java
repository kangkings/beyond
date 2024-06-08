import java.io.*;

public class StreamMain1 {
    public static void main(String[] args){
        //입출력 스트림
        //H/W장치와의 연결 통로(마우스, 키보드, 모니터, 랜카드 등)

        try {
            //파일과의 통로를 열어서 바이트 단위로 데이터를 읽어오는 객체
            FileInputStream fileInputStream = new FileInputStream("/Users/kangking/zzz.txt");

            //글자 단위로 데이터를 읽어오는 스트림. 인코딩을 지정할 수 있다.
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");

            //읽어온 내용을 담는다 (Buffer는 일종의 완충제 역할 - 속도가 빠름) 스캐너보다 빠름
            BufferedReader br = new BufferedReader(inputStreamReader);

            int res;
            while ((res = br.read()) != -1){
                System.out.print((char) res);
            }
            br.close();
            inputStreamReader.close();
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
