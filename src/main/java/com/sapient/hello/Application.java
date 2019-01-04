package com.sapient.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sapient")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

}