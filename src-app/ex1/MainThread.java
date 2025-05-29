package ex1;

public class MainThread extends Thread {
    
	private int n;
	private static int first() {
		return 1;
	}

	private static int second() {
		return 2;
	}

	private static int third() {
		return 3;
	}

	private int factorial(int a) {
		int fact = 1;
		for (int i = 1; i <= a; i++){
			fact = fact * i;
		}

		return fact;
	}
	public MainThread(String name, int n) {
		super(name);
		this.n = n;

	}

	public void run() {
		factorial(n);
		first();
		second();
		third();
	}
}
