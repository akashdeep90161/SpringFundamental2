package com.akash.autowiring.example;

import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component
@Named(value = "fileWriter")
public class FileWriter implements LogWriter{
    public void write(String text) {
        //write to a file here
        // Dummy Implementation

        System.out.println("write to file: "+ text);
    }
}
