package schedule;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ScheduleWithFixedDelayTest {

    private static long time = System.currentTimeMillis();
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void run(){

        scheduler.scheduleAtFixedRate(()->{
            long startTime = System.currentTimeMillis();
            System.out.println("Runnable 1" + (startTime - time));
            //throwsException(null);
        },
        0,
        50,
        MILLISECONDS);
        scheduler.scheduleAtFixedRate(()->{
            long startTime = System.currentTimeMillis();
            System.out.println("Runnable 2" + (startTime - time));
        },
        0,
        50,
        MILLISECONDS);
    }

    public void throwsException(List<Integer> lst){
        lst.isEmpty();
    }

    public static void main(String[] args){
        ScheduleWithFixedDelayTest s = new ScheduleWithFixedDelayTest();
        s.run();
    }

}
