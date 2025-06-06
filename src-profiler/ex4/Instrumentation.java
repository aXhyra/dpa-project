package ex4;

import ch.usi.dag.disl.annotation.Before;
import ch.usi.dag.disl.marker.BytecodeMarker;
import ch.usi.dag.disl.marker.BodyMarker;

import ex2.Profiler;

public class Instrumentation {
    @Before(marker = BytecodeMarker.class, args = "new, newarray, anewarray, multianewarray", scope = "*.*")
    public static void profileSafeAllocation() {
        ex4.Profiler.addSafeCount();
    }

    @Before(marker = BodyMarker.class, scope = "sun.misc.Unsafe.allocateInstance")
    public static void profileUnsafeAllocation() {
        ex4.Profiler.addUnsafeCount();
    }

}
