package learn.saga.flight;

import org.apache.servicecomb.saga.omega.spring.EnableOmega;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("learn.saga.flight")
@ServletComponentScan("learn.saga.flight")
@SpringBootApplication
@ImportResource({ "classpath:ctx.xml" })
@EnableOmega
public class Application {
    public static void main(String[] args) {
        System.out.println("begin to start ...");
        SpringApplication.run(Application.class, args);
        System.out.println("finished start ...");
    }
}
