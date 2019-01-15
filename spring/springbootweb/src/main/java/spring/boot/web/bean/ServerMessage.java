package spring.boot.web.bean;

public class ServerMessage {

    private String seviceName;
    private String host;
    private int port;

    public ServerMessage(String serviceName, String host, int port){
        System.out.println("ServerMessage init~");
        this.seviceName = serviceName;
        this.host = host;
        this.port = port;
    }

    public String getSeviceName() {
        return seviceName;
    }

    public String getHost() {
        return host;
    }


    public int getPort() {
        return port;
    }
}
