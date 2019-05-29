package learn.standard.java.thread;

import sun.tools.tree.NewArrayExpression;

import java.util.concurrent.*;

public class NewThread {

    public static void newThread(){
        // 1、继承Thread，重写run方法

        class MyThread extends Thread{
            public void run(){
                System.out.println("MyThread run");
            }
        }
        Thread th1 = new MyThread();
        th1.start();

        // 2、实现Runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        };
        Thread th2 = new Thread(runnable);
        th2.start();

        // 3、实现Callable
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return new String("Callable");
            }
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> result = executor.submit(callable);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        NewThread.newThread();
    }
}
