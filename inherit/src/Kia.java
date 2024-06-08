public class Kia implements Car {
    @Override
    public void accelerate() {
        System.out.println("기아 가속");
    }

    @Override
    public void brake() {
        System.out.println("기아 브레이크");
    }

    @Override
    public void fillOil() {
        System.out.println("기아 주유");
    }

    @Override
    public void parking() {
        System.out.println("기아 주차");
    }

    //추가기능
    public  void kiaOnly(){
        System.out.println("기아차 신기능");
    }
}
