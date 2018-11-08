package serverstream;

import java.io.IOException;

import grpcproto.Config;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ServerStreamServer {

	private Server server;
	public void start() throws IOException{
		server = ServerBuilder.forPort(Config.SERVERSTREAM_PORT).addService(new BookNewsImp()).build().start();
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				ServerStreamServer.this.stop();
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
		ServerStreamServer server = new ServerStreamServer();
		server.start();
		server.blockUntilShutdown();
	}
}
