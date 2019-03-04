package schedule;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ScheduleWithFixedDelayTest {

    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void run(){

        scheduler.scheduleAtFixedRate(()->{
            System.out.println("start");
            throwsException(null);
        },
        0,
        500,
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
