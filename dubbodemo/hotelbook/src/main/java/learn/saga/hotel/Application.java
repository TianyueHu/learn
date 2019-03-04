package learn.saga.hotel;

import org.apache.servicecomb.saga.omega.spring.EnableOmega;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("learn.saga.hotel")
@ServletComponentScan("learn.saga.hotel")
@SpringBootApplication
@ImportResource({ "classpath:ctx.xml" })
@EnableOmega

public class Application {

    public static void main(String[] args) {
        try{
            SpringApplication.run(Application.class, args);
        }catch(Throwable ex){
            ex.printStackTrace();
        }
    }
}
