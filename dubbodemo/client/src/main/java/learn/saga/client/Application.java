package com.learn.saga.client;

import org.apache.servicecomb.saga.omega.spring.EnableOmega;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("com.learn.saga.client")
@ServletComponentScan("lcom.learn.saga.client")
@SpringBootApplication
@EnableOmega
@ImportResource({ "classpath:consumer.xml" })
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
