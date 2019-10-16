package com.akash.autowiring.example;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements LogWriter {

    public void write(String text) {
        //write to a file here
        // Dummy Implementation

        System.out.println("write to console: "+ text);
    }
}
