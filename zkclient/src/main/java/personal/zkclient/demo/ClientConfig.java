package personal.zkclient.demo;


import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Value("${zookeeper.servers:localhost:2181}")
    private String zkServers;

    @Value("${zookeeper.servers:connectTimeout:500}")
    private int connectTimeout;

    @Value("${zookeeper.servers:sessionTimeout:50000}")
    private int sessionTimeout;

    @Bean
    ZkClient zkClient(){
        return new ZkClient(zkServers);
    }

    @Bean
    ClientHelper clientHelper(ZkClient zkClient){
        return new ClientHelper(zkClient);
    }


}
