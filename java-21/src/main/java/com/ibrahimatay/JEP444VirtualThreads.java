package com.ibrahimatay;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/*
* JEP 444: Virtual Threads
* https://openjdk.org/jeps/444
* */
public class JEP444VirtualThreads {
    public static void main(String[] args) {
        Runnable fn = () -> {
            IntStream.range(0, 100_000).forEach(i-> {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        };

        // Platform Threads
        new Thread(fn).start();

        Thread.ofPlatform().start(fn);
        Thread.ofPlatform().daemon().name("my-custom-thread").unstarted(fn);

        // Virtual Threads

        Thread.startVirtualThread(() -> {
            IntStream.range(0, 100_000).forEach(i-> {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        var executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(() -> {
            IntStream.range(0, 100_000).forEach(i-> {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }
}
