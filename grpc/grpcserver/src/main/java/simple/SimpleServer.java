package simple;

import java.io.IOException;

import grpcproto.Config;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SimpleServer {

	private Server server;
	
	public void start() throws IOException{
		server = ServerBuilder.forPort(Config.SIMPLESERVER_PORT).addService(new SimpleGreeterImp()).build().start();
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				SimpleServer.this.stop();
			}
		});
	}
	
	private void stop(){
		if (server != null) {
			server.shutdown();
		}
	}
	
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException{
		SimpleServer simpleServer = new SimpleServer();
		simpleServer.start();
		simpleServer.blockUntilShutdown();
	}

}
