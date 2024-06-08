import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Factorial {
    Integer factorial(Integer num){
        Integer res;
        if(num == 1){
            res = 1;
        }else {
            res = num * factorial(num-1);
        }
        StringBuffer sb = new StringBuffer("12345");
        String s = "!234";
        return res;
    }
}
