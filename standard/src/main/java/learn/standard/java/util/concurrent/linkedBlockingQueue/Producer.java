package learn.standard.java.util.concurrent.linkedBlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import learn.standard.java.bean.Sweet;

public class Producer implements Runnable{
    private LinkedBlockingQueue<Sweet> linkedBlockingQueue;

    private AtomicBoolean stop = new AtomicBoolean(false);
    public Producer(LinkedBlockingQueue<Sweet> linkedBlockingQueue){
        this.linkedBlockingQueue = linkedBlockingQueue;
    }

    public void run() {
        int i = 0;
        while (!stop.get()){

            try {
                String sweetName = "sweet " + i;
                Sweet sweet = new Sweet(sweetName);
                linkedBlockingQueue.put(sweet);

                System.out.println("Produce : " + sweetName + "  " + linkedBlockingQueue.size());
                ++i;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        stop.set(true);
    }
}
