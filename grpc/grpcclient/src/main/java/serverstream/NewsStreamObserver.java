package serverstream;

import io.grpc.stub.StreamObserver;
import personal.grpcproto.News;

public class NewsStreamObserver implements StreamObserver<News>{

	public void onCompleted() {
		System.out.println("No other news any more, you can send a new bookrequest");
	}

	public void onError(Throwable arg0) {
		System.out.println("Error");
	}

	public void onNext(News arg0) {
		System.out.println(arg0.getName() + " received news :" + arg0.getNews());
	}

}
