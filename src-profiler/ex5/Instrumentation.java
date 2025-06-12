package ex5;

import ch.usi.dag.disl.annotation.Before;
import ch.usi.dag.disl.annotation.After;
import ch.usi.dag.disl.annotation.ThreadLocal;
import ch.usi.dag.disl.dynamiccontext.DynamicContext;
import ch.usi.dag.disl.marker.BytecodeMarker;
import ch.usi.dag.disl.marker.BodyMarker;

public class Instrumentation {

    @ThreadLocal
    static long invokeStatic = 0;

    @ThreadLocal
    static long invokeSpecial = 0;

    @ThreadLocal
    static long invokeVirtual = 0;

    @ThreadLocal
    static long invokeDynamic = 0;

    @Before(marker = BytecodeMarker.class, args = "invokestatic")
    static void onInvokeStatic() {
	++invokeStatic;
    }

    @Before(marker = BytecodeMarker.class, args="invokespecial")
    static void onInvokeSpecial() {
	++invokeSpecial;
    }

    @Before(marker = BytecodeMarker.class, args="invokevirtual")
    static void onInvokeVirtual() {
	++invokeVirtual;
    }

    @Before(marker = BytecodeMarker.class, args="invokedynamic")
    static void onInvokeDynamic() {
	++invokeDynamic;
    }

    @After(marker = BodyMarker.class, scope="void run()")
    static void onThreadExit(DynamicContext ctx) {
	if (ctx.getThis() instanceof Thread)
	    Profiler.registerThreadEnd();
    }
}
