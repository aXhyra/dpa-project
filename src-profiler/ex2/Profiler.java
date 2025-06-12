package ex2;

import java.util.concurrent.atomic.LongAdder;

public class Profiler {
    private static final LongAdder readCounter = new LongAdder();
    private static final LongAdder writeCounter = new LongAdder();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(Profiler::dump));
    }

    public static void dump() {
        System.err.format("Instance field read accesses: %d%n", readCounter.sum());
        System.err.format("Instance field write accesses: %d%n", writeCounter.sum());
    }

    public static void addReadCount() {
        readCounter.increment();
    }

    public static void addWriteCount() {
        writeCounter.increment();
    }
}
