package ex3;

import ch.usi.dag.disl.annotation.After;
import ch.usi.dag.disl.marker.BytecodeMarker;
import ch.usi.dag.disl.dynamiccontext.DynamicContext;

public class Instrumentation {

    @After(marker = BytecodeMarker.class,
	    args="astore",
	    scope = "ex3.MainThread.checkAccess")
    static void variableUpdate(DynamicContext ctx) {
	if (ctx.getLocalVariableValue(2, String.class).equals("granted"))
	    System.out.format("Thread: %s\n", Thread.currentThread().getName());
    }
}
