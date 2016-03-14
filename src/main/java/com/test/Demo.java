package com.test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Smit on 3/13/16.
 */
@SpringBootApplication
public class Demo {
    public static void main(String[] args) {
        //System.out.println("Hello world! Args: " + args[0] + " " + args[1]);
        SpringApplication.run(Demo.class, args);
    }

    @Bean
    ExecutorService getExecutorService() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        return service;
    }

    @Bean
    public TestInstance getTestInstance() {
        return new TestInstance();
    }
}
