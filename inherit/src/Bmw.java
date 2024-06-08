public class Bmw implements Car {

    //공통기능: 가속
    @Override
    public void accelerate() {
        System.out.println("BMW 가속");
    }

    //공통기능: 브레이크
    @Override
    public void brake() {
        System.out.println("BMW 브레이크");
    }

    //공통기능: 주유
    @Override
    public void fillOil() {
        System.out.println("BMW 주유");
    }

    //공통기능: 주차
    @Override
    public void parking() {
        System.out.println("BMW 주차");
    }

    //추가기능
    public  void bmwOnly(){
        System.out.println("BMW 신기능");
    }
}
