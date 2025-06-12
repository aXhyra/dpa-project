package ex5;

import java.lang.reflect.Field;

public class Profiler {
    public static void registerThreadEnd() {
	try {
	    Thread thread = Thread.currentThread();
	    Field invokeStatic = Thread.class.getDeclaredField("invokeStatic");
	    Field invokeSpecial = Thread.class.getDeclaredField("invokeSpecial");
	    Field invokeVirtual = Thread.class.getDeclaredField("invokeVirtual");
	    Field invokeDynamic = Thread.class.getDeclaredField("invokeDynamic");

	    synchronized (System.out) {
		System.out.format("Thread: %s - #static: %d - #special: %d - #virtual: %d - #dynamic: %d\n",
				  thread.getName(),
				  invokeStatic.getLong(Thread.currentThread()),
				  invokeSpecial.getLong(Thread.currentThread()),
				  invokeVirtual.getLong(Thread.currentThread()),
				  invokeDynamic.getLong(Thread.currentThread()));
	    }
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }
}
