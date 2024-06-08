import java.util.Arrays;
import java.util.Random;

public class Lotto {
    Integer[] number;
    Integer cnt;
    Integer selectOne;
    Random r;
    public Lotto() {
        this.number = new Integer[6];
        cnt = 0;
        r = new Random();
    }

    public Integer chooseOne(){
        if (cnt < 6){
             selectOne= r.nextInt(45)+1;
            if (!check(selectOne)){
                number[cnt] = selectOne;
                cnt++;
            }else chooseOne();
        }
        return number[cnt-1];
    }

    public Boolean check(Integer checkNum){
        return Arrays.stream(number).toList().contains(checkNum.intValue());
    }
}
