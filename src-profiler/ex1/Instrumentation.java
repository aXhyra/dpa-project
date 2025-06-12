package ex1;

import ch.usi.dag.disl.annotation.After;
import ch.usi.dag.disl.annotation.Before;
import ch.usi.dag.disl.annotation.SyntheticLocal;
import ch.usi.dag.disl.marker.BodyMarker;
import ch.usi.dag.disl.staticcontext.MethodStaticContext;

public class Instrumentation {

    @SyntheticLocal
    static long begin;

    @Before(marker = BodyMarker.class, scope = "ex1.MainThread.factorial")
    static void enterMethod() {
	begin = System.nanoTime();
    }

    @After(marker = BodyMarker.class, scope = "ex1.MainThread.factorial")
    static void exitMethod(MethodStaticContext ctx) {
	System.out.format("%s - Execution time for %s: %dns\n",
			  Thread.currentThread().getName(),
			  ctx.getUniqueInternalName(),
			  System.nanoTime() - begin);
    }
}
