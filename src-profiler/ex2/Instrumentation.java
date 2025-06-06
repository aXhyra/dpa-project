package ex2;

import ch.usi.dag.disl.annotation.Before;
import ch.usi.dag.disl.marker.BytecodeMarker;
import ch.usi.dag.disl.staticcontext.FieldAccessStaticContext;


public class Instrumentation {

    @Before(marker = BytecodeMarker.class, args = "getfield", scope = "*.*")
    public static void profileFieldReadAccess(FieldAccessStaticContext fsc) {
        Profiler.addReadCount();
    }

    @Before(marker = BytecodeMarker.class, args = "putfield", scope = "*.*")
    public static void profileFieldWriteAccess(FieldAccessStaticContext fsc) {
        Profiler.addWriteCount();
    }

}
