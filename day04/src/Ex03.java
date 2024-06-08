public class Ex03 {
    public static void main(String[] args) {

        //예외처리
        //문법적으로 틀린 것은 아니지만 실행중 발생할 수 있는 다양한 문제에 대한 처리

        Integer num01 =10;
        Integer num02 = 0;
        Integer result;
        try {
            result = num01 / num02;

        }catch (ArithmeticException e1){
            e1.printStackTrace();
            result = 10;
        } catch (Exception e2){
            e2.printStackTrace();
            result = 0;
        }

        System.out.println(result);
    }
}
