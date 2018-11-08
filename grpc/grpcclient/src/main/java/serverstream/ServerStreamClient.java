package serverstream;

import grpcproto.Config;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import personal.grpcproto.BookNewsGrpc;
import personal.grpcproto.BookRequest;

public class ServerStreamClient {

	private Channel channel;
	private BookNewsGrpc.BookNewsStub stub;
	private NewsStreamObserver newsStreamObserver;
	
	public ServerStreamClient(Channel channel){
		this.channel = channel;
		stub = BookNewsGrpc.newStub(channel);
		newsStreamObserver = new NewsStreamObserver();
	}
	
	public ServerStreamClient(String host, int port){
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
	}
	
	public void bookNews(String name){
		BookRequest bookRequest = BookRequest.newBuilder().setName(name).build();
		stub.bookNews(bookRequest, newsStreamObserver);
	}
	
	
	public static void main(String[] args) throws InterruptedException{
		ServerStreamClient client = new ServerStreamClient(Config.HOST, Config.SERVERSTREAM_PORT);
		client.bookNews("Kikyo");
		client.bookNews("lala");
		Thread.sleep(10000);
	}
}
