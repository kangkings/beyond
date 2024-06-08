public class Main {
    public static void main(String[] args) {


        Car c1 = new Bmw();
        Car c2 = new Kia();
        //추가기능
        Car c3 = new Hyundai();

        Car[] cArr = new Car[3];

        cArr[0] = c1;

        Bmw b2 = (Bmw)cArr[0];
        b2.bmwOnly();

        Bmw b1 = new Bmw();
        c1.brake();
        c1 = (Car) c1;
        c1 = (Kia) c1;
        ((Kia) c1).kiaOnly();

        ((Kia) c1).kiaOnly();
        ((Kia) c1).kiaOnly();

    }
}