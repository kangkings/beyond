public class JumpChampion extends  Champion{

    private Integer z;

    public JumpChampion(Integer speed, Integer hp, Integer power, Integer shield, Integer x, Integer y) {
        super(speed, hp, power, shield, x, y);
        z = 0;
    }

    public void jump(Integer z){
        this.z = z;
        System.out.println("jump");
        this.z = 0;
    }

    public void test(String s){
        s += "plus";
    }
}
