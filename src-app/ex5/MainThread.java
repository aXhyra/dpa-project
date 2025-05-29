package ex5;

import java.util.List;

public class MainThread extends Thread {


    private int a;
    private static int b;
    private boolean c;
    private static Object d;
    private String e;
    private static int[] f;
    private int n;

    static class HashCode {

	@Override
	public int hashCode() {
	    return 2000;
	}

	@Override
	public String toString() {
	    return String.valueOf(hashCode());
	}
    }

    public MainThread(String name, int n) {

	super(name);

	this.n = n;

	a = n;
	b = 2 * a;
	c = n % 2 == 0 ? true : false;
	d = new HashCode();
	e = String.valueOf(a);
	f = new int [1];
	f[0] = b / 2;

    }

    private static int sum(int a, int b) {
	return a + b;
    }

    private static int mul(int a, int b) {
	return a * b;
    }

    private static int div(int a, int b) {
	return a / b;
    }

    public void a() {
	a = sum(a, 1);
    }

    public static void b() {
	b = mul(b, 2);
    }

    public void c() {
	c=!c;
    }

    public static void d() {
	d = new HashCode();
    }

    public void e() {
	e = String.valueOf(a);
    }

    public static void f() {
	f[0] = div(f[0], 2);
    }

    public int number() {
	int cValue = c ? 1 : 0;
	int dValue = d.hashCode();
	int eValue = Integer.parseInt(e);
	int fValue = f[0];

	return sum(sum(sum(sum(sum(a, b), cValue), dValue), eValue), fValue);
    }

    public void run() {

	for (int i = 0; i < n; i++) {
	    number();
	    a();
	    b();
	    c();
	    d(); 
	    e();
	    f();
	    number();
	    List.of("Red", "Green", "Blue")
	    .stream().filter(c -> c.length() > 3).count();
	}

    }

}
