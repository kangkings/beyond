import java.net.StandardProtocolFamily;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Baseball {
    public static void main(String[] args) {

        int strike;
        int ball;
        int out;
        int cnt;
        //숫자 입력
        Scanner sc = new Scanner(System.in);
        int my;
        int com;
        int[] myNum = new int[3];
        int[] comNum = new int[3];
        my = sc.nextInt();
        int myTmp = my;
        cnt = 0;

        do{
            myTmp = my;
            strike = 0;
            ball = 0;
            out = 0;
            com = (int)(Math.random()*1000);

            //자리수 나누기
            for (int i = 0; i < myNum.length; i++) {
                myNum[i] = myTmp%10;
                comNum[i] = com%10;
                myTmp = (myTmp-myNum[i])/10;
                com = (com-comNum[i])/10;
            }
            //판별
            for (int i = 0; i < myNum.length; i++) {
                for (int j = 0; j < myNum.length; j++) {

                    if(comNum[i] == myNum[j]){
                        if (i == j){
                            strike++;
                        }else {
                            ball++;
                        }

                    }
                }
            }
            out= 3-strike-ball;
            cnt++;

        }while( comNum[0] == comNum[1] || comNum[0] == comNum[2] || comNum[1] == comNum[2] || strike < 3);

        System.out.printf("%ds, %db, %do\n",strike,ball,out);
        System.out.println(cnt);
        //출력


    }
}
