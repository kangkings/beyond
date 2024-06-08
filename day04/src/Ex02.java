public class Ex02 {
    public static void main(String[] args) {
        //인터페이스
        //일반적인 메소드는 없고 추상메소드만 있음
        //변수도 만들 수 있긴 하나 잘 만들지 않음 (값을 꼭 줘야함)
        //인터페이스는 구현이 안되어있기 때문에 객체를 만들 수 없다.
        //추상메소드는 객체생성함과 동시에 구현하거나 구현해두면 객체를 사용할 수 있다.

        InterfaceImplements1 it01 = new InterfaceImplements1();
        InterfaceImplements2 it02 = new InterfaceImplements2();
        InterfaceTest it03 = new InterfaceImplements1();
        InterfaceTest it04 = new InterfaceImplements2();


        Cafe c = new Cafe();

        c.sellCoffee(new Americano());
        c.sellCoffee(new Latte());

        System.out.println(c.sales);

    }
}
