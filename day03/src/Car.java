import java.util.Arrays;

public class Car {
    String color;

    Integer price;

    String model;

    Integer nowSpeed = 0;


    public void accelerate(Integer time, Integer intensity){
        this.nowSpeed += time*intensity;
    }

    public void brake(Integer time, Integer intensity){
        this.nowSpeed -= time*intensity;
        if (this.nowSpeed < 0)
            this.nowSpeed = 0;
    }

    public void painting(String color){
        this.color = color;
    }
}
