import java.net.StandardProtocolFamily;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.IntStream;

public class ChampionTest {
    public static void main(String[] args) {
        Champion zed = new Champion(100, 600, 55, 30, 0, 0);
        Champion katarina = new Champion(100, 550, 60, 30, 200, 200);
        Champion akali = new Champion(100, 650, 50, 35, 0, 0);
        Champion kasadin = new Champion(100, 620, 45, 35, 200, 200);

        kasadin.attack(zed);
        System.out.println(zed.getHp());

        JumpChampion zed2 = new JumpChampion(100, 600, 55, 30, 0, 0);
        zed2.jump(10);

        String s = "base";
        String s2 = new String("base2");
        zed2.test(s);
        zed2.test(s2);
        System.out.println(s);
        System.out.println(s2);







    }
}
