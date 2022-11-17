package com.ibrahimatay;

public class MemoryPolluter {
    // JEP 318: Epsilon: A No-Op Garbage Collector
    // https://openjdk.org/jeps/318

    // Understanding the JDK’s New Superfast Garbage Collectors (-XX:+UseZGC)
    // https://blogs.oracle.com/javamagazine/post/understanding-the-jdks-new-superfast-garbage-collectors

    // Epsilon: The JDK’s Do-Nothing Garbage Collector (-XX:+UseEpsilonGC)
    // https://blogs.oracle.com/javamagazine/post/epsilon-the-jdks-do-nothing-garbage-collector
    static final int GIGABYTE = 1024 * 1024 * 1024;
    static final int ITERATIONS = 100;
    public static void main(String[] args) {
        System.out.println("Starting allocations...");

        // allocate memory 1GB at a time
        for (int i = 0; i < ITERATIONS; i++) {
            var array = new byte[GIGABYTE];
        }

        System.out.println("Completed successfully");
    }
}
