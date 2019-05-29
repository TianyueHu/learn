package schedule;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class SingleThreadScheduledExecutorTest {
    public static long time = System.currentTimeMillis();

    private static final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public static void run(){
        service.scheduleAtFixedRate(()->{
            long startTime = System.currentTimeMillis();
            System.out.println("runnable 1"  + (startTime - time));
        },
                0,
                100,
                MILLISECONDS
        );
        service.scheduleAtFixedRate(()->{
                    long startTime = System.currentTimeMillis();
                    System.out.println("runnable 2"  + (startTime - time));
                },
                0,
                100,
                MILLISECONDS
        );
    }
}
