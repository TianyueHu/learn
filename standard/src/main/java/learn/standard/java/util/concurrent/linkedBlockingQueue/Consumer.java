package learn.standard.java.util.concurrent.linkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import learn.standard.java.bean.Sweet;

public class Consumer implements Runnable{
    private LinkedBlockingQueue<Sweet> linkedBlockingQueue;

    private AtomicBoolean stop = new AtomicBoolean(false);
    private String name;

    public Consumer(LinkedBlockingQueue<Sweet> linkedBlockingQueue, String name){
        this.linkedBlockingQueue = linkedBlockingQueue;
        this.name = name;
    }


    public void run() {
        while (!stop.get()){
            Sweet sweet = null;
            try {
                sweet = linkedBlockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " : " + sweet.getName());
        }
    }

    public void stop(){
        stop.set(true);
    }
}
