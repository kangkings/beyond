package org.example.proxytest;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ProxytestApplication {
    public static void main(String[] args) {
        try {
            System.out.println("객체 생성 전");
            ProxyImage image01 = new ProxyImage("/Users/kangking/downloads/img1.png");
            BufferedImage image = image01.getImage();
            System.out.println("메소드 실행 후");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
