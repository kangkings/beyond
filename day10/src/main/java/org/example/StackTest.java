package org.example;

public class StackTest {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(3);
        s.push(5);


        s.display();

        System.out.println(s.peek());

        Integer[] arr = {3,2,6,5,8};;
        Stack s2 = new Stack(arr.length);

        arr = s2.reverse(arr);

        for(Integer n : arr){
            System.out.println(n);
        }

        String res = "3+2*4-9/3";
        Stack s3 =new Stack(res.length());

        System.out.println(Character.toString((int) res.charAt(1)));
        System.out.println(Character.toString(res.charAt(1)));
        System.out.println(Character.valueOf(res.charAt(1)));
        System.out.println((int)Character.valueOf('+'));






    }
}
