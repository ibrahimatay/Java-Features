package com.ibrahimatay;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JSR166ConcurrencyUtilities {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //Creates a ExecutorService object having a single thread.

        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        // Creates a ExecutorService object having a pool of 10 threads.

        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
        //Creates a scheduled thread pool executor with 10 threads.
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

    }
}
