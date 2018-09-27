package helloworld;

import io.grpc.stub.StreamObserver;
import personal.grpcproto.GreeterGrpc;
import personal.grpcproto.HelloReply;
import personal.grpcproto.HelloRequest;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}