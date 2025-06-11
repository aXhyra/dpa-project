package ex6;

import ch.usi.dag.disl.annotation.Before;
import ch.usi.dag.disl.annotation.GuardMethod;
import ch.usi.dag.disl.marker.BodyMarker;
import ch.usi.dag.disl.staticcontext.ClassStaticContext;
import ch.usi.dag.disl.staticcontext.MethodStaticContext;


public class Instrumentation {
    static class MainMethod {
        // Guard method to filter out class static initialization
        @GuardMethod
        public static boolean isMainThreadMethod(ClassStaticContext csc, MethodStaticContext msc) {
            String methodName = msc.thisMethodName();

            return  !methodName.equals("<init>") &&
                    !methodName.equals("<clinit>") &&
                    (csc.getInternalName().equals("java/lang/Thread") ||
                            csc.getSuperClassInternalName().equals("java/lang/Thread"));
        }
    }

    // More targeted scope for better performance
    @Before(marker = BodyMarker.class, scope = "ex6.MainThread.*", guard = MainMethod.class)
    public static void profileMethod(MethodStaticContext msc) {
        String threadName = Thread.currentThread().getName();
        String methodName = msc.thisMethodFullName();


       Profiler.register(threadName, methodName);
    }
}
