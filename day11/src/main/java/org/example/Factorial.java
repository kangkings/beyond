package org.example;

public class Factorial {
    public Integer calc(Integer num){
        if(num == 0){
            return 1;
        }else {
            return num * calc(num-1);
        }
    }
}
