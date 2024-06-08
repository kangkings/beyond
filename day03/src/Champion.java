public class Champion {

    private Integer level;
    private Integer speed;
    private Integer hp;
    private Integer power;
    private Integer shield;
    private Integer x;
    private Integer y;
    private String[] items;

    public Champion(Integer speed, Integer hp, Integer power, Integer shield, Integer x, Integer y) {
        this.level = 1;
        this.speed = speed;
        this.hp = hp;
        this.power = power;
        this.shield = shield;
        this.x = x;
        this.y = y;
        this.items = new String[6];
    }
    public void move(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public void attack(Champion champion){
        champion.setHp(champion.getHp() - (this.power-champion.getShield()));
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getShield() {
        return shield;
    }

    public void setShield(Integer shield) {
        this.shield = shield;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }
}
