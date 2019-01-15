package spring.boot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.boot.web.bean.Client;
import spring.boot.web.bean.ServerMessage;


@Configuration
public class Config {

    @Value("${server.serviceName:alpha}")
    private String serviceName;

    @Value("${server.host:localhost}")
    private String host;

    @Value("${server.port:8080}")
    private int port;

    @Bean
    ServerMessage serverMessage(){
        return new ServerMessage(serviceName, host ,port);
    }

    @Bean
    Client client(ServerMessage serverMessage){
        return new Client(serverMessage);
    }
}
