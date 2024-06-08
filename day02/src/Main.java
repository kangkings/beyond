import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //연금복권
        Integer num;
        num = 0;
        Integer randomNumber;
        while(num < 6){
             randomNumber= (int)(Math.random()*9)+1;
            System.out.println(randomNumber);
            num = num +1;
        }

        System.out.println();

        //로또(for)
        Integer[] lottoNum;
        lottoNum = new Integer[6];
        Integer selectNum;
        for (int i = 0; i < lottoNum.length; i++) {
            selectNum = (int)(Math.random()*45+1);
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    if (lottoNum[j] == selectNum){
                        i--;
                        break;
                    }
                    if (j == i-1){
                        lottoNum[i] = selectNum;
                        System.out.println(lottoNum[i]);
                    }
                }
            }else {
                lottoNum[i] = selectNum;
                System.out.println(lottoNum[i]);
            }

        }

        System.out.println();

        //로또2
        Lotto l = new Lotto();

        for (int i = 0; i < 6; i++) {
            System.out.println(l.chooseOne().intValue());
        }
        int[] arr = new int[]{1,2,3,4,32} ;

        System.out.println(Arrays.stream(arr).boxed().filter(
                i -> i%2 == 0
        ).collect(Collectors.toList()));

        Arrays.stream(arr).boxed().filter(
                i -> i%2 == 0
        ).collect(Collectors.toList());



    }

}