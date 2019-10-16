package com.akash.autowiring.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
// This class created to understand SPEL in spring
@Component
public class Robot {
    private String id="00";
    private String speach="hello";

   // @Autowired
  //  @Resource
    @Inject
    public void setId(@Value("#{randomText.getText()}") String id) {
        this.id = id;
    }

    public void setSpeech(@Value("#{randomText.getText()}") String speach) {
        this.speach = speach;
    }

    public void speak()
    {
        System.out.println(id+": " + speach);
    }
}
