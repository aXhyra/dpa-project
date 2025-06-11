package ex4;

import java.util.concurrent.atomic.LongAdder;

public class Profiler {
    private static final LongAdder safeCounter = new LongAdder();
    private static final LongAdder unsafeCounter = new LongAdder();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(Profiler::dump));
    }

    public static void dump() {
        System.err.format("Safe allocation: %d%n", safeCounter.sum());
        System.err.format("Unsafe allocation: %d%n", unsafeCounter.sum());
    }

    public static void addSafeCount() {
        safeCounter.increment();
    }

    public static void addUnsafeCount() {
        unsafeCounter.increment();
    }
}
