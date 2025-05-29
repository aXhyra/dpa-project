package ex6;


public class MainThread extends Thread {

    private int a;
    private static int b;
    private static int[] d;

    public MainThread(String name, int n) {

	super(name);
	a = n;
	b = 2 * a;
	d = new int [1];
	d[0] = b / 2;

    }

    private int sum(int a, int b) {
	return a + b;
    }

    private int mul(int a, int b) {
	return a * b;
    }

    private int div(int a, int b) {
	return a / b;
    }

    public void a() {
	a = sum(a, 1);
	b();
    }

    public void b() {
	b = mul(b, 2);
	c();
    }

    public void c() {
	d();
    }

    public void d() {
	d[0] = div(d[0], 2);
    }

    public void run() {
	this.a();
    }

}
