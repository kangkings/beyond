import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "11234";
        StringBuffer sb = new StringBuffer(s);
        sb.deleteCharAt(3);
        sb.insert(3,'g');
        System.out.println(sb.toString());
    }
}