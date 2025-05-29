package ex4;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class MainThread extends Thread {

    private int n;

    public MainThread(int i) {
	super();
	this.n = i;
    }

    public int getN() {
	return n;
    }

    static class Player {
	private int age = 12;

	private int ACCESS_ALLOWED = 1;

	public Player() {
	    this.age = 50;
	}

	public int getAge() {
	    return age;
	}

	public void setAge(int age) {
	    this.age = age;
	}

	public boolean giveAccess() {
	    return 42 == ACCESS_ALLOWED;
	}


    }

    public void run() {
	Field f = null;
	try {
	    f = Unsafe.class.getDeclaredField("theUnsafe");
	} catch (NoSuchFieldException e) {
	    throw new RuntimeException(e);
	}

	f.setAccessible(true);
	Unsafe unsafe = null;
	try {
	    unsafe = (Unsafe) f.get(null);
	} catch (IllegalAccessException e) {
	    throw new RuntimeException(e);
	}

	// create instance without calling the constructor
	Player p = null;
	for (int i = 0; i < Math.pow(this.getN(), 2); i ++) {
	    try {
		p = (Player) unsafe.allocateInstance(Player.class);
	    } catch (InstantiationException e) {
		throw new RuntimeException(e);
	    }
	}

	p.setAge(35);

	Player p1 = new Player();

	Field f2 = null;
	try {
	    f2 = p1.getClass().getDeclaredField("ACCESS_ALLOWED");
	} catch (NoSuchFieldException e) {
	    throw new RuntimeException(e);
	}
	unsafe.putInt(p1, unsafe.objectFieldOffset(f2), 42);

    }

}
