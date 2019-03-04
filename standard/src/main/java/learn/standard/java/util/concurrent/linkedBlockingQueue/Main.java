package learn.standard.java.util.concurrent.linkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;
import learn.standard.java.bean.Sweet;

public class Main {

    public static void main(String[] args){
        LinkedBlockingQueue<Sweet> linkedBlockingQueue = new LinkedBlockingQueue<Sweet>(6);

        Producer producer = new Producer(linkedBlockingQueue);
        Consumer consumer1 = new Consumer(linkedBlockingQueue, "Consumer1");
        Consumer consumer2 = new Consumer(linkedBlockingQueue, "Consumer2");

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer1);
        Thread thread3 = new Thread(consumer2);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.stop();
        consumer1.stop();
        consumer2.stop();
    }
}
