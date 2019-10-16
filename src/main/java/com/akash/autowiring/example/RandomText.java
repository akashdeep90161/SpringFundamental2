package com.akash.autowiring.example;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class RandomText {
    private static String[] texts={"I will be back,","Get Out","fdfffsf"};
    public String getText()
    {
        Random random =new Random();
        return texts[random.nextInt(texts.length)];
    }
}
