package ex6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Profiler {

    static class ShutdownThread extends Thread {

        public void run() {
            for (String threadName : threadMethods.keySet()) {
                System.err.println("=== " + threadName + " ===");
                List<String> methods = threadMethods.get(threadName);
                for (String method : methods) {
                    System.err.println(method);
                }
            }
        }

    }

    static {
        Runtime.getRuntime().addShutdownHook(new ShutdownThread());
    }

    private static final ConcurrentHashMap<String, List<String>> threadMethods = new ConcurrentHashMap<>();

    public static void register(String threadName, String methodName) {
        threadMethods.computeIfAbsent(threadName, k -> Collections.synchronizedList(new ArrayList<>())).add(methodName);
    }
}
