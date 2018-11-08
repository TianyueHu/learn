package simple;

import io.grpc.stub.StreamObserver;
import personal.grpcproto.SimpleGreeterGrpc;
import personal.grpcproto.SimpleRequest;
import personal.grpcproto.SimpleResponse;

public class SimpleGreeterImp extends SimpleGreeterGrpc.SimpleGreeterImplBase {

	public void sayHello(SimpleRequest simpleRequest, StreamObserver<SimpleResponse> responseObserver){
		String name = simpleRequest.getName();
		System.out.println("I've received a name ---" + name);
		SimpleResponse simpleResponse = SimpleResponse.newBuilder().setMessage("Hello, " + name).build();
		responseObserver.onNext(simpleResponse);
		responseObserver.onCompleted();
	}
}
