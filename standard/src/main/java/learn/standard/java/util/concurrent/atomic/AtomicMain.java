package learn.standard.java.util.concurrent.atomic;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicMain {

    private static AtomicInteger count = new AtomicInteger(0);

    public static int countIncrement(){
       return count.addAndGet(1);
    }


    public static void main(String[] args){
        Executor executor = Executors.newFixedThreadPool(5);
        IntStream.range(0, 100).forEach(i ->
        executor.execute(() ->
                System.out.println(AtomicMain.countIncrement())));


        IntStream.range(1,100).forEach(System.out::println);
    }
}
