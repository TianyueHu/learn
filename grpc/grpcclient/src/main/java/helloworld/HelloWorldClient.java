package helloworld;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import personal.grpcproto.GreeterGrpc;
import personal.grpcproto.HelloReply;
import personal.grpcproto.HelloRequest;

import java.util.concurrent.TimeUnit;

public class HelloWorldClient {


	private final ManagedChannel channel;
	private final GreeterGrpc.GreeterBlockingStub blockingStub;

	/**
	 * Construct client connecting to HelloWorld server at {@code host:port}.
	 */
	public HelloWorldClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port)
				// Channels are secure by default (via SSL/TLS). For the example
				// we disable TLS to avoid
				// needing certificates.
				.usePlaintext().build());
	}

	/**
	 * Construct client for accessing HelloWorld server using the existing
	 * channel.
	 */
	HelloWorldClient(ManagedChannel channel) {
		this.channel = channel;
		blockingStub = GreeterGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	/** Say hello to server. */
	public void greet(String name) {
		HelloRequest request = HelloRequest.newBuilder().setName(name).build();
		HelloReply response;
		try {
			response = blockingStub.sayHello(request);
			System.out.println(response.toString());
		} catch (StatusRuntimeException e) {
			return;
		}
	}

	/**
	 * Greet server. If provided, the first element of {@code args} is the name
	 * to use in the greeting.
	 */
	public static void main(String[] args) throws Exception {
		HelloWorldClient client = new HelloWorldClient("localhost", 50051);
		try {
			/* Access a service running on the local machine on port 50051 */
			String user = "world";
			if (args.length > 0) {
				user = args[0]; /*
								 			* Use the arg as the name to greet if provided
								 			*/
			}
			client.greet(user);
		} finally {
			client.shutdown();
		}
	}
}
