package com.ibrahimatay;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class JSR166ConcurrencyUtilities {
    public static void main(String[] args) throws IOException {
        // ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        // Creates a ExecutorService object having a single thread.

        // ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        // Creates a ExecutorService object having a pool of 10 threads.

        // ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
        // Creates a scheduled thread pool executor with 10 threads.
        // In scheduled thread pool, we can schedule tasks of the threads.

        // https://www.javatpoint.com/java-executorservice
        // https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html
        // shutdown() method
        // shutdownNow() method
        // awaitTermination() method
        // execute(Runnable task)
        // submit(Runnable task) / submit(Callable<T> task)
        // invokeAny(Collection<? extends Callable<T>> tasks)
        // invokeAll(Collection<? extends Callable<T>> tasks)

        /*
        AtomicVariableExample atomicVariableExample = new AtomicVariableExample(5);
        for (int i=0;i<5;i++){
            System.out.println(atomicVariableExample.next());
        }
         */
        JSR166ConcurrencyUtilities jsr166ConcurrencyUtilities = new JSR166ConcurrencyUtilities();
        /*

        jsr166ConcurrencyUtilities.threadPool();;

         */

        // jsr166ConcurrencyUtilities.callable();
    }

    public void threadPool() throws IOException {
        Executor pool = Executors.newFixedThreadPool(7);
        ServerSocket socket = new ServerSocket(8081);

        for(;;){
            final Socket connection = socket.accept();
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("running...");
                    new Handler().process(connection);
                    System.out.println("handled...");
                }
            });
        }
    }

    public void callable() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callable = new JSR166ConcurrencyCallable();
        for (int i = 0; i < 100; i++) {
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        for(Future<String> fut : list){
            try{
                System.out.println(new Date()+ "::"+fut.get());
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }
    }

    class Handler{
        void process(Socket s){

        }
    }

    static class AtomicVariableExample {
        private AtomicLong seed;
        AtomicVariableExample(long s){
            seed = new AtomicLong(s);
        }

        long next() {
            for(;;) {
                long s = seed.get();
                long nextS = s * 42 + 13;
                if(seed.compareAndSet(s, nextS)){
                    return s;
                }
            }
        }
    }

    class JSR166ConcurrencyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(100);
            return Thread.currentThread().getName();
        }
    }
}
