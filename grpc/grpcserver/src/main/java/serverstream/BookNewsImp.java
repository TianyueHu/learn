package serverstream;

import io.grpc.stub.StreamObserver;
import personal.grpcproto.BookNewsGrpc;
import personal.grpcproto.BookRequest;
import personal.grpcproto.News;
public class BookNewsImp extends BookNewsGrpc.BookNewsImplBase{

	public void bookNews(BookRequest request, StreamObserver<News> responseObserver) {
		System.out.println("Received " + request.getName() +"'s booking request.");
		responseObserver.onNext(News.newBuilder().setName(request.getName()).setNews("News1").build());
		responseObserver.onNext(News.newBuilder().setName(request.getName()).setNews("News2").build());
		responseObserver.onNext(News.newBuilder().setName(request.getName()).setNews("News3").build());
		responseObserver.onCompleted();
	}
}
