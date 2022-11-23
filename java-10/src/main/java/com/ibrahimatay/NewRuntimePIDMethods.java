package com.ibrahimatay;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class NewRuntimePIDMethods {
    public static void main(String[] args) {
        final RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        final long pid = runtime.getPid();
        System.out.println("Process ID is: " + pid);
        // Process ID is: 49402
    }
}
