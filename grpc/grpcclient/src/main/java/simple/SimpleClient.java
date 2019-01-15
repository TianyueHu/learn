package simple;

import java.util.concurrent.TimeUnit;

import grpcproto.Config;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import personal.grpcproto.SimpleGreeterGrpc;
import personal.grpcproto.SimpleRequest;
import personal.grpcproto.SimpleResponse;

public class SimpleClient {

	private final ManagedChannel channel;
	private final SimpleGreeterGrpc.SimpleGreeterBlockingStub blockingStub;
	
	public SimpleClient(ManagedChannel channel){
		this.channel = channel;
		blockingStub = SimpleGreeterGrpc.newBlockingStub(channel);
	}
	
	public SimpleClient(String host, int port){
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
	}
	
	public void shutdown() throws InterruptedException{
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public void simpleRequest(String name){
		SimpleRequest request = SimpleRequest.newBuilder().setName(name).build();
		SimpleResponse response;
		try{
		    response = blockingStub.sayHello(request);
		    System.out.println(response.toString());
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		SimpleClient client = new SimpleClient(Config.HOST, Config.SIMPLESERVER_PORT);
		try{
			String name = "world";
			client.simpleRequest(name);
		}
		finally{
			client.shutdown();
		}
	}
	
}
