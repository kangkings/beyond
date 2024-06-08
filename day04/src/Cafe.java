public class Cafe {

    Integer sales;

    public Cafe() {
        this.sales = 0;
    }

    //다형성을 지원하기 때문에 Coffee타입으로 이를 상속받는 아메리카노, 라떼를 전부 받을 수 있다.
    void sellCoffee(Coffee coffee){
        sales += coffee.getPrice();
    }

}
