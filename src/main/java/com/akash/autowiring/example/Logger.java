package com.akash.autowiring.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

@Component
public class Logger {
    private ConsoleWriter consoleWriter;
    private FileWriter fileWriter;

  //  @Resource // here Resource is working same as Autowired
    @Inject
    public void setConsoleWriter(ConsoleWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }
    @Autowired // By setting required =files program can run even if respective bean is not available. It is like optional beans
    @Named(value = "fileWriter") // Named annotation is used to remove ambiguity only. the value of named is work as id of beans.
    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }


   /* private LogWriter consoleWriter;
    private LogWriter fileWriter;

   *//* public Logger(LogWriter consoleWriter, LogWriter fileWriter) {
        this.consoleWriter = consoleWriter;
        this.fileWriter = fileWriter;
    }
*//*
    public void setConsoleWriter(LogWriter consoleWriter) {
        this.consoleWriter = consoleWriter;
    }

    public void setFileWriter(LogWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

*/
    @PostConstruct
    public void init()
    {
        System.out.println("Init");
    }
    @PreDestroy // Scope must not be prototype of bean
    public void destroy()
    {
        System.out.println("Destroy");
    }

    public void writeFile(String text)
    {

        fileWriter.write(text);
    }
    public void writeConsole(String text)
    {
        consoleWriter.write(text);
    }
}
