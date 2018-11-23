package spring.boot.web.bean;

public class Client {

    private ServerMessage serverMessage;

    public Client(ServerMessage serverMessage){
        System.out.println("Client init!");
        this.serverMessage = serverMessage;
    }
}
