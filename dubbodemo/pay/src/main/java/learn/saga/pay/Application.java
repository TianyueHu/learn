package learn.saga.pay;

import org.apache.servicecomb.saga.omega.spring.EnableOmega;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("learn.saga.pay")
@ServletComponentScan("learn.saga.pay")
@SpringBootApplication
@ImportResource({ "classpath:ctx.xml" })
@EnableOmega
public class Application {

    public static void main(String[] args) throws Throwable{

        SpringApplication.run(Application.class, args);
    }
}
