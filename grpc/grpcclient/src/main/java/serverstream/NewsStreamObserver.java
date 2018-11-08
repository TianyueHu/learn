package serverstream;

import io.grpc.stub.StreamObserver;
import personal.grpcproto.News;

public class NewsStreamObserver implements StreamObserver<News>{

	@Override
	public void onCompleted() {
		System.out.println("No other news any more, you can send a new bookrequest");
	}

	@Override
	public void onError(Throwable arg0) {
		System.out.println("Error");
	}

	@Override
	public void onNext(News arg0) {
		System.out.println(arg0.getName() + " received news :" + arg0.getNews());
	}

}
